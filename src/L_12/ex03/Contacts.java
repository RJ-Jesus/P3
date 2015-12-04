package L_12.ex03;

import rjj.human.Person;

import java.util.*;
import java.util.stream.Stream;

public class Contacts implements Iterable<Person> {
    private Set<Person> contacts;

    public Contacts() {
        this.contacts = new TreeSet<>();
    }

    public Contacts(Person[] contacts) {
        this.contacts = new TreeSet<>(Arrays.asList(Objects.requireNonNull(contacts)));
    }

    public boolean add(Person p) {
        return contacts.add(p);
    }

    public boolean remove(Person elem) {
        return contacts.remove(elem);
    }

    public Person[] toArray() {
        return contacts.toArray(new Person[contacts.size()]);
    }

    public Stream<Person> stream() {
        return contacts.stream();
    }

    @Override
    public Iterator<Person> iterator() {
        return contacts.iterator();
    }

    @Override
    public String toString() {
        return stream().map(Person::toString).reduce("", (s1, s2) -> s1 + s2 + "\n");
    }

    public static class ExtensionManager {
        private static final Map<String, IRWContacts> plugins;

        static {
            plugins = new HashMap<>();
        }

        public static IRWContacts loadPlugin(final String pluginName) {
            try {
                final IRWContacts plugin = (IRWContacts) Class.forName(pluginName).newInstance();
                plugins.put(pluginName, plugin);
                return plugin;
            } catch (ClassNotFoundException e) {
                System.err.println(pluginName + " was not found.");
                return null;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static IRWContacts forName(final String pluginName) {
            return plugins.get(pluginName);
        }

        public static int size() {
            return plugins.size();
        }
    }
}
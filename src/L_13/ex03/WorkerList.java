package L_13.ex03;

import java.util.*;

public class WorkerList {
    private Map<String, Integer> workers;

    public WorkerList() {
        this.workers = new HashMap<>();
    }

    public void addWorker(final String workerName) {
        Objects.requireNonNull(workerName);
        workers.put(workerName, workers.getOrDefault(workerName, 0) + 1);
    }

    public String[] getWorkers() {
        return workers.keySet().toArray(new String[workers.size()]);
    }

    public SortedSet<Map.Entry<String, Integer>> getUniqueNamesByOccurrence() {
        SortedSet<Map.Entry<String, Integer>> entrySortedSet = new TreeSet<>((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        entrySortedSet.addAll(workers.entrySet());
        return entrySortedSet;
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            List<String> workers = new ArrayList<>(WorkerList.this.workers.keySet());
            private int currentWinner = 0;

            @Override
            public boolean hasNext() {
                return workers.size() != 0;
            }

            @Override
            public String next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                String worker = workers.get(currentWinner);
                currentWinner = (currentWinner + 1) % workers.size();
                return worker;
            }
        };
    }

}

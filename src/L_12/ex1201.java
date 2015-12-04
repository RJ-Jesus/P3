package L_12;

import L_12.ex01.ObjectList;
import rjj.util.Validate;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ex1201 {
    static final Scanner sc = new Scanner(System.in);
    static final ObjectList oList = new ObjectList();
    static Class<?> cCurrent;

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            switch (menu()) {
                case 1:
                    System.out.print("Class name (example: 'rjj.human.Person'): ");
                    String cName = sc.nextLine();
                    try {
                        cCurrent = Class.forName(cName);
                    } catch (ClassNotFoundException e) {
                        System.err.println("Error: Couldn't add the class " + cName);
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    showInterfaces();
                    break;
                case 3:
                    showSuperclass();
                    break;
                case 4:
                    showConstructors();
                    break;
                case 5:
                    showMethods();
                    break;
                case 6:
                    showFields();
                    break;
                case 7:
                    createInstance();
                    break;
                case 8:
                    invokeSpecific();
                    break;
                case 9:
                    invokeAll();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.err.println("Error: Something odd happened... Please try again.");
            }
        }
    }

    public static void invokeSpecific() {
        printIndexed(oList);
        Object o = oList.get(Validate.getInRange(sc, "Object #: ", 0, oList.size()));
        Method[] allMethods = o.getClass().getMethods();
        printIndexed(allMethods);
        Method m = allMethods[Validate.getInRange(sc, "Method #: ", 0, allMethods.length)];
        Class[] paramTypes = m.getParameterTypes();
        Object[] params = new Object[paramTypes.length];
        for (int i = 0; i < params.length; i++) {
            System.out.printf("Parameter # %d: ", i);
            params[i] = ObjectList.readVarPrimitive(paramTypes[i], sc.nextLine());
        }
        try {
            System.out.println("Result:\n" + m.invoke(o, params));
            System.out.println("Successful.");
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            System.err.println("Error: Couldn't create the requested object.\nMaybe there were wrong parameters " +
                    "(notice that currently this method only accepts primitive types (or their reference " +
                    "counterparts) and Strings).");
            e.printStackTrace();
        }
    }

    public static void invokeAll() {
        Method[] allCommonMethods = oList.getCommonMethods();
        printIndexed(allCommonMethods);
        Method m = allCommonMethods[Validate.getInRange(sc, "Method #: ", 0, allCommonMethods.length)];
        Class[] paramTypes = m.getParameterTypes();
        Object[] params = new Object[paramTypes.length];
        for (int i = 0; i < params.length; i++) {
            System.out.printf("Parameter # %d: ", i);
            params[i] = ObjectList.readVarPrimitive(paramTypes[i], sc.nextLine());
        }
        try {
            Object[] arr = oList.invokeAll(m, params);
            System.out.println("Results:");
            for (Object o : arr)
                System.out.println(o);
            System.out.println("Successful.");
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            System.err.println("Error: Couldn't create the requested object.\nMaybe there were wrong parameters " +
                    "(notice that currently this method only accepts primitive types (or their reference " +
                    "counterparts) and Strings).");
            e.printStackTrace();
        }
    }

    public static void createInstance() {
        if (cCurrent != null)
            oList.add(createInstance(cCurrent));
        else
            System.err.println("Error: No class defined.");
    }

    private static Object createInstance(final Class c) {
        Constructor[] allConstructors = c.getConstructors();
        if (allConstructors.length == 0) {
            System.err.println("No available constructor found. Can't complete this action.");
            return null;
        }
        Constructor cons;
        if (allConstructors.length == 1)
            System.out.println("Using only available constructor: " + (cons = allConstructors[0]));
        else {
            printIndexed(allConstructors);
            cons = allConstructors[Validate.getInRange(sc, "Use constructor at index: ",
                    0, allConstructors.length)];
        }
        Class[] paramTypes = cons.getParameterTypes();
        if (paramTypes.length == 0)
            try {
                return cons.newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                System.err.println("Error: Couldn't create the requested object.");
                e.printStackTrace();
                return null;
            }
        Object[] params = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            System.out.printf("Evaluating parameter [%d, %s]: ", i, paramTypes[i].getName());
            switch (paramTypes[i].getSimpleName()) {
                case "Byte":
                case "byte":
                    params[i] = Byte.parseByte(sc.nextLine());
                    break;
                case "Short":
                case "short":
                    params[i] = Short.parseShort(sc.nextLine());
                    break;
                case "Integer":
                case "int":
                    params[i] = Integer.parseInt(sc.nextLine());
                    break;
                case "Long":
                case "long":
                    params[i] = Long.parseLong(sc.nextLine());
                    break;
                case "Float":
                case "float":
                    params[i] = Float.parseFloat(sc.nextLine());
                    break;
                case "Double":
                case "double":
                    params[i] = Double.parseDouble(sc.nextLine());
                    break;
                case "Boolean":
                case "boolean":
                    params[i] = Boolean.parseBoolean(sc.nextLine());
                    break;
                case "Character":
                case "char":
                    String s = sc.nextLine();
                    params[i] = s.length() >= 1 ? s.charAt(0) : '\0';
                    break;
                case "String":
                    params[i] = sc.nextLine();
                    break;
                default:
                    System.out.println("\nWARNING: Current parameter was not of primitive type.");
                    System.out.println("Initializing recursive construction.");
                    try {
                        params[i] = createInstance(Class.forName(paramTypes[i].getName()));
                        System.out.println("Building process completed successfully.");
                        System.out.println("Continuing from last point.");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
            }
        }
        try {
            return cons.newInstance(params);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.err.println("Error: Couldn't create the requested object.\nMaybe there were wrong parameters, or " +
                    "some constructors for each object were poorly chosen.");
            e.printStackTrace();
            return null;
        }
    }

    private static int printIndexed(Iterable itr) {
        int i = 0;
        for (Object o : itr)
            System.out.printf("%d - %s\n", i++, o);
        return i;
    }

    private static int printIndexed(Object[] arr) {
        int i = 0;
        for (Object o : arr)
            System.out.printf("%d - %s\n", i++, o);
        return i;
    }

    public static void showInterfaces() {
        if (cCurrent != null)
            for (Class i : cCurrent.getInterfaces())
                System.out.println(i);
        else
            System.err.println("Error: No class defined.");
    }

    public static void showSuperclass() {
        if (cCurrent != null)
            System.out.println(cCurrent.getSuperclass());
        else
            System.err.println("Error: No class defined.");
    }

    public static void showConstructors() {
        if (cCurrent != null)
            for (Constructor c : cCurrent.getConstructors())
                System.out.println(c);
        else
            System.err.println("Error: No class defined.");
    }

    public static void showMethods() {
        if (cCurrent != null)
            for (Method m : cCurrent.getMethods())
                System.out.println(m);
        else
            System.err.println("Error: No class defined.");
    }

    public static void showFields() {
        if (cCurrent != null)
            for (Field f : cCurrent.getFields())
                System.out.println(f);
        else
            System.err.println("Error: No class defined.");
    }

    public static int menu() {
        String[] opts = {"1 - Class from String", "2 - Show implemented interfaces of current class",
                "3 - Show superclass of current class", "4 - Show constructors of current class",
                "5 - Show methods of current class", "6 - Show fields of current class",
                "7 - Create instance of current class", "8 - Invoke method on specific object",
                "9 - Invoke method on all created objects", "0 - Exit"};
        for (String opt : opts)
            System.out.println(opt);
        int i = -1;
        while (i < 0 || i >= opts.length) {
            System.out.print("option: ");
            i = Integer.parseInt(sc.nextLine());
        }
        return i;
    }
}

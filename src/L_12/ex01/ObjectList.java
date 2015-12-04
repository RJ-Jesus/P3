package L_12.ex01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Objects;

public class ObjectList extends LinkedList<Object> {
    private static boolean in(Object o, Object[] others) {
        Objects.requireNonNull(o);
        Objects.requireNonNull(others);
        for (Object otherObject : others)
            if (o.equals(otherObject))
                return true;
        return false;
    }

    public static Object readVarPrimitive(Class c, String s) {
        switch (c.getSimpleName()) {
            case "Byte":
            case "byte":
                return Byte.parseByte(s);
            case "Short":
            case "short":
                return Short.parseShort(s);
            case "Integer":
            case "int":
                return Integer.parseInt(s);
            case "Long":
            case "long":
                return Long.parseLong(s);
            case "Float":
            case "float":
                return Float.parseFloat(s);
            case "Double":
            case "double":
                return Double.parseDouble(s);
            case "Boolean":
            case "boolean":
                return Boolean.parseBoolean(s);
            case "Character":
            case "char":
                return s.length() >= 1 ? s.charAt(0) : '\0';
            case "String":
                return s;
            default:
                return null;
        }
    }

    @Override
    public boolean add(Object o) {
        return o != null && super.add(o);
    }

    public Object[] invokeAll(final Method m, final Object... args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object[] rtn = new Object[this.size()];
        int i = 0;
        for (Object o : this)
            rtn[i++] = m.invoke(o, args);
        return rtn;
    }

    public Method[] getCommonMethods() {
        if (isEmpty())
            return null;
        Method[] rtn = getFirst().getClass().getMethods();
        int k = rtn.length;
        for (int i = 1; i < this.size(); i++) {
            Method[] methods = get(i).getClass().getMethods();
            for (int j = 0; j < rtn.length; j++)
                if (rtn[j] != null && !in(rtn[j], methods)) {
                    rtn[j] = null;
                    k--;
                }
        }
        Method[] rtnTrim = new Method[k];
        for (int i = 0, j = 0; j < rtn.length; j++)
            if (rtn[j] != null)
                rtnTrim[i++] = rtn[j];
        return rtnTrim;
    }

}
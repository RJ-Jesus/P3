package rjj.util;

import java.lang.reflect.Array;
import java.util.*;

public class Compare {

    @SafeVarargs
    public static <E extends Comparable<? super E>> E findMax(final E... arr) {
        if (arr.length == 0)
            throw new IllegalArgumentException("Invalid array length.");
        E rtn = arr[0];
        for (E elem : arr)
            rtn = rtn.compareTo(elem) < 0 ? elem : rtn;
        return rtn;
    }

    @SafeVarargs
    public static <E extends Comparable<? super E>> E findMin(final E... arr) {
        if (arr.length == 0)
            throw new IllegalArgumentException("Invalid array length.");
        E rtn = arr[0];
        for (E elem : arr)
            rtn = rtn.compareTo(elem) > 0 ? elem : rtn;
        return rtn;
    }

    public static <E extends Comparable<? super E>> void sortArray(final E[] arr) {
        sortArray(arr, 0, arr.length);
    }

    private static <E extends Comparable<? super E>> void sortArray(final E[] arr, final int start, final int end) {
        if (end - start > 1) {
            int mid = (end + start) / 2;
            sortArray(arr, start, mid);
            sortArray(arr, mid, end);
            sortArray(arr, start, mid, end);
        }
    }

    private static <E extends Comparable<? super E>> void sortArray(final E[] arr, final int start, final int mid, final int end) {
        @SuppressWarnings("unchecked")
        E[] brr = (E[]) Array.newInstance(arr.getClass().getComponentType(), end - start);
        int i = start, j = mid, k = 0;
        while (i < mid && j < end)
            brr[k++] = arr[i].compareTo(arr[j]) < 0 ? arr[i++] : arr[j++];
        while (i < mid)
            brr[k++] = arr[i++];
        while (j < end)
            brr[k++] = arr[j++];
        System.arraycopy(brr, 0, arr, start, end - start);
    }

    public static class MapUtil
    {
        public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
            List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
            Collections.sort(list, (o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));

            Map<K, V> rtn = new LinkedHashMap<>();
            for (Map.Entry<K, V> entry : list) {
                rtn.put(entry.getKey(), entry.getValue());
            }
            return rtn;
        }
    }
}

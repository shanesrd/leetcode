package util;

import java.util.Comparator;
import java.util.List;

/**
 * @author Lixiaochun
 */
public class ResUtils {

    public static void print(int res, int expected) {
        sysout(String.valueOf(res), String.valueOf(expected));

        boolean match = res == expected;
        printFlag(match);
    }

    public static void print(int[] res, int[] expected) {
        sysout(string(res), string(expected));
        boolean match = checkArr(res, expected);

        printFlag(match);
    }

    public static void printNotStrict(int[] res, int[] expected) {
        sysout(string(res), string(expected));
        boolean match = checkArrNotStrict(res, expected);

        printFlag(match);
    }

    public static void print(int[][] res, int[][] expected) {
        sysout(string(res), string(expected));
        boolean match = checkArr(res, expected);

        printFlag(match);
    }

    public static void print(char[] res, char[] expected) {
        sysout(string(res), string(expected));
        boolean match = checkArr(res, expected);

        printFlag(match);
    }

    public static void print(String res, String expected) {
        sysout(res, expected);
        boolean match = expected.equals(res);

        printFlag(match);
    }

    public static void print(boolean res, boolean expected) {
        sysout(String.valueOf(res), String.valueOf(expected));
        boolean match = res == expected;

        printFlag(match);
    }

    public static void print(double[] res, double expected) {

    }

    public static void print(List<String> res, List<String> expected) {
        sysout(String.valueOf(res), String.valueOf(expected));
        boolean match = ResUtils.checkListIgnoreOrder(res, expected);

        printFlag(match);
    }

    public static <T> void print12(List<T> res, List<T> expected) {
        sysout(String.valueOf(res), String.valueOf(expected));
        boolean match = ResUtils.checkList(res, expected);

        printFlag(match);
    }

    public static void print2(List<List<Integer>> res, List<List<Integer>> expected) {
        sysout(String.valueOf(res), String.valueOf(expected));
        boolean match = res.size() == expected.size();
        if (match) {
            for (int i = 0; i < res.size(); i++) {
                if (checkListIgnoreOrder(res.get(i), expected.get(i))) {
                    continue;
                }

                match = false;
                break;
            }
        }

        printFlag(match);
    }

    private static void printFlag(boolean res) {
        if (res) {
            System.out.println("==========================");
        } else {
            System.err.println("xxxxxxxxxxxxxxxxxxxxxxxxxx");
            throw new RuntimeException("not match");
        }
    }

    private static boolean checkArr(int[] a1, int[] a2) {
        int len = a2.length;

        if (a1.length != len) {
            return false;
        }

        for (int idx = 0; idx < len; idx++) {
            if (a1[idx] != a2[idx]) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkArrNotStrict(int[] a1, int[] a2) {
        for (int idx = 0; idx < a2.length; idx++) {
            if (a1[idx] != a2[idx]) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkArr(int[][] a1, int[][] a2) {
        int len = a2.length;

        if (a1.length != len) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            int slen = a2[i].length;

            if (a1[i].length != slen) {
                return false;
            }

            for (int j = 0; j < slen; j++) {
                if (a1[i][j] != a2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkArr(char[] a1, char[] a2) {
        int len = a2.length;

        if (a1.length != len) {
            return false;
        }

        for (int idx = 0; idx < len; idx++) {
            if (a1[idx] != a2[idx]) {
                return false;
            }
        }

        return true;
    }

    private static <T extends Comparable> boolean checkListIgnoreOrder(List<T> al, List<T> bl) {
        al.sort(Comparator.naturalOrder());
        bl.sort(Comparator.naturalOrder());

        return al.equals(bl);
    }

    private static <T> boolean checkList(List<T> al, List<T> bl) {
        return al.equals(bl);
    }

    private static String string(int[] arr) {
        StringBuilder builder = new StringBuilder("[");

        int len = arr.length;
        for (int idx = 0; idx < len - 1; idx++) {
            builder.append(arr[idx]).append(",");
        }
        if (len > 0) {
            builder.append(arr[len - 1]);
        }
        builder.append("]");

        return builder.toString();
    }

    private static String string(int[][] arr) {
        StringBuilder builder = new StringBuilder("[");

        int ilen = arr.length;
        for (int i = 0; i < ilen; i++) {
            builder.append("[");

            int jlen = arr[i].length;
            for (int j = 0; j < jlen; j++) {
               builder.append(arr[i][j]);
                if (j < jlen - 1) {
                    builder.append(",");
                }
            }

            builder.append("]");
            if (i < ilen - 1) {
                builder.append(",");
            }
        }
        builder.append("]");

        return builder.toString();
    }

    private static String string(char[] arr) {
        StringBuilder builder = new StringBuilder("[");

        int len = arr.length;
        for (int idx = 0; idx < len - 1; idx++) {
            builder.append(arr[idx]).append(",");
        }
        if (len > 0) {
            builder.append(arr[len - 1]);
        }
        builder.append("]");

        return builder.toString();
    }

    private static void sysout(String res, String expected) {
        System.out.printf("result  : %s\nexpected: %s\n", res, expected);
    }

}

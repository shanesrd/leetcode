package util;

/**
 * @author Lixiaochun
 */
public class ResUtils {

    public static void print(int res, int expected) {
        boolean match = res == expected;

        System.out.printf("result: %s, expected: %s\n", res, expected);
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

}

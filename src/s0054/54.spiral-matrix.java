package s0054;
/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (40.20%)
 * Likes:    6029
 * Dislikes: 780
 * Total Accepted:    653.1K
 * Total Submissions: 1.6M
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import util.ResUtils;

/*
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i <= m / 2 + m % 2 && i <= n / 2 + n % 2; i++) {
            for (int a = i; a <= n - i + 1; a++) {
                res.add(matrix[i - 1][a - 1]);
            }
            for (int a = i + 1; a <= m - i; a++) {
                res.add(matrix[a - 1][n - i]);
            }
            for (int a = n - i + 1; m > 2 * i - 1 && a >= i; a--) {
                res.add(matrix[m - i][a - 1]);
            }
            for (int a = m - i; n > 2 * i - 1 && a >= i + 1; a--) {
                res.add(matrix[a - 1][i - 1]);
            }
        }

        return res;
    }
}
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int rn = matrix.length, cn = matrix[0].length, top = 0, bottom = rn - 1, left = 0, right = cn - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            for (int i = top + 1; i < bottom; i++) {
                res.add(matrix[i][right]);
            }
            for (int i = right; top < bottom && i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            for (int i = bottom - 1; left < right && i > top; i--) {
                res.add(matrix[i][left]);
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return res;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            List<Integer> res = new Solution().spiralOrder(c.matrix);
            int[] resArr = res.stream().mapToInt(i -> i).toArray();

            ResUtils.print(resArr, c.expected.stream().mapToInt(i -> i).toArray());
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[][]{{1}}, Collections.singletonList(1)));
        cases.add(new Case(new int[][]{{1, 2}}, Arrays.asList(1, 2)));
        cases.add(new Case(new int[][]{{1, 2}, {4, 3}}, Arrays.asList(1, 2, 3, 4)));
        cases.add(new Case(new int[][]{{1, 2, 3}, {6, 5, 4}}, Arrays.asList(1, 2, 3, 4, 5, 6)));
        cases.add(new Case(new int[][]{{1, 2}, {8, 3}, {7, 4}, {6, 5}}, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)));
        cases.add(new Case(new int[][]{{1, 2, 3}, {12, 13, 4}, {11, 14, 5}, {10, 15, 6}, {9, 8, 7}},
                           Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)));
        cases.add(new Case(new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}},
                           Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)));
        cases.add(new Case(new int[][]{{1,  2,  3,  4,  5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8}, {13, 12, 11, 10, 9}},
                           Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25)));
        cases.add(new Case(new int[][]{{7}, {9}, {6}}, Arrays.asList(7, 9, 6)));
        cases.add(new Case(new int[][]{{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}},
                           Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        return cases;
    }

}

class Case {
    int[][] matrix;
    List<Integer> expected;

    public Case(int[][] matrix, List<Integer> expected) {
        this.matrix = matrix;
        this.expected = expected;
    }

}

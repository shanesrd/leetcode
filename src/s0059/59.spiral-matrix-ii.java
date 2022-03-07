package s0059;
/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (61.36%)
 * Likes:    2432
 * Dislikes: 157
 * Total Accepted:    296.8K
 * Total Submissions: 483.7K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate an n x n matrix filled with elements
 * from 1 to n^2 in spiral order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1
 * Output: [[1]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 20
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int val = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j <= n - i; j++) {
                res[i - 1][j] = ++val;
            }

            for (int j = i; j <= n - i - 1; j++) {
                res[j][n - i] = ++val;
            }

            for (int j = n - i; ((n % 2 == 1 && i != n / 2 + 1) || n % 2 == 0) && j >= i - 1; j--) {
                res[n - i][j] = ++val;
            }

            for (int j = n - i - 1; j >= i; j--) {
                res[j][i - 1] = ++val;
            }
        }

        return res;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int[][] res = new Solution().generateMatrix(c.n);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(1, new int[][]{{1}}));
        cases.add(new Case(2, new int[][]{{1, 2}, {4, 3}}));
        cases.add(new Case(3, new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}));
        cases.add(new Case(4, new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}}));
        cases.add(new Case(5, new int[][]{{1, 2, 3, 4, 5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8}, {13, 12, 11, 10, 9}}));

        return cases;
    }

}

class Case {
    int n;
    int[][] expected;

    public Case(int n, int[][] expected) {
        this.n = n;
        this.expected = expected;
    }

}

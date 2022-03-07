package s0509;
/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 *
 * https://leetcode.com/problems/fibonacci-number/description/
 *
 * algorithms
 * Easy (68.07%)
 * Likes:    3040
 * Dislikes: 255
 * Total Accepted:    679.9K
 * Total Submissions: 998.8K
 * Testcase Example:  '2'
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
 * Fibonacci sequence, such that each number is the sum of the two preceding
 * ones, starting from 0 and 1. That is,
 * 
 * 
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * 
 * 
 * Given n, calculate F(n).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 30
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int res = 0;

        int[] dp = new int[]{0, 1};
        for (int i = 2; i <=n; i++) {
            res = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = res;
        }

       return res;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int res = new Solution().fib(c.n);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(2, 1));
        cases.add(new Case(3, 2));
        cases.add(new Case(4, 3));

        return cases;
    }

}

class Case {
    int n;
    int expected;

    public Case(int n, int expected) {
        this.n = n;
        this.expected = expected;
    }

}


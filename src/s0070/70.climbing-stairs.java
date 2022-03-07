package s0070;
/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (50.77%)
 * Likes:    10656
 * Dislikes: 328
 * Total Accepted:    1.4M
 * Total Submissions: 2.8M
 * Testcase Example:  '2'
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 45
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int res = 0;

        int[] dp = new int[]{1, 2};
        for (int i = 3; i <= n; i++) {
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
            int res = new Solution().climbStairs(c.n);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(2, 2));
        cases.add(new Case(3, 3));

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

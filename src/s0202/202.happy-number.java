package s0202;
/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 *
 * https://leetcode.com/problems/happy-number/description/
 *
 * algorithms
 * Easy (52.77%)
 * Likes:    4746
 * Dislikes: 656
 * Total Accepted:    756K
 * Total Submissions: 1.4M
 * Testcase Example:  '19'
 *
 * Write an algorithm to determine if a number n is happy.
 * 
 * A happy number is a number defined by the following process:
 * 
 * 
 * Starting with any positive integer, replace the number by the sum of the
 * squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it
 * loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * 
 * 
 * Return true if n is a happy number, and false if not.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 2
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 2^31 - 1
 * 
 * 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.ResUtils;

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> calSet = new HashSet<>();

        while (true) {
            int calRes = 0;
            while (n > 0) {
                int num = n % 10;
                n = n / 10;
                calRes += Math.pow(num, 2);
            }

            if (1 == calRes) {
                return true;
            } else {
                if (!calSet.add(calRes)) {
                    return false;
                }
            }
            //
            n = calRes;
        }
    }

}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            boolean res = new Solution().isHappy(c.num);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(19, true));
        cases.add(new Case(2, false));
        cases.add(new Case(2147483647, false));

        return cases;
    }

}

class Case {
    int num;
    boolean expected;

    public Case(int num, boolean expected) {
        this.num = num;
        this.expected = expected;
    }

}

package s0053;
/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (49.44%)
 * Likes:    18821
 * Dislikes: 897
 * Total Accepted:    2.1M
 * Total Submissions: 4.3M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1]
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * 
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;

        int plus = 0;
        for (int i = 0; i < nums.length; i++) {
            plus += nums[i];
            res = Math.max(res, plus);
            if (plus < 0) {
                plus = 0;
            }
        }

        return res;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int res = new Solution().maxSubArray(c.nums);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4},  6));
        cases.add(new Case(new int[]{1},  1));
        cases.add(new Case(new int[]{5, 4, -1, 7, 8},  23));

        return cases;
    }

}

class Case {
    int[] nums;
    int expected;

    public Case(int[] nums, int expected) {
        this.nums = nums;
        this.expected = expected;
    }

}

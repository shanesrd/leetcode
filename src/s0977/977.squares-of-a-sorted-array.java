package s0977;
/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 *
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 *
 * algorithms
 * Easy (71.47%)
 * Likes:    4335
 * Dislikes: 143
 * Total Accepted:    803.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '[-4,-1,0,3,10]'
 *
 * Given an integer array nums sorted in non-decreasing order, return an array
 * of the squares of each number sorted in non-decreasing order.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in non-decreasing order.
 *
 *
 *
 * Follow up: Squaring each element and sorting the new array is very trivial,
 * could you find an O(n) solution using a different approach?
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int lidx = 0;
        int ridx = nums.length - 1;
        int idx = ridx;

        while (lidx <= ridx) {
            int lv = nums[lidx] * nums[lidx];
            int rv = nums[ridx] * nums[ridx];

            if (lv >= rv) {
                res[idx--] = lv;
                lidx++;
            } else {
                res[idx--] = rv;
                ridx--;
            }
        }

        return res;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int[] res = new Solution().sortedSquares(c.nums);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{1}, new int[]{1}));
        cases.add(new Case(new int[]{1, 1}, new int[]{1, 1}));
        cases.add(new Case(new int[]{1, 2}, new int[]{1, 4}));
        cases.add(new Case(new int[]{2, 1}, new int[]{1, 4}));
        cases.add(new Case(new int[]{-1, 0, 1}, new int[]{0, 1, 1}));
        cases.add(new Case(new int[]{-2, 0, 1}, new int[]{0, 1, 4}));
        cases.add(new Case(new int[]{-2, -1, 1}, new int[]{1, 1, 4}));
        cases.add(new Case(new int[]{-2, -2, 0, 1}, new int[]{0, 1, 4, 4}));
        cases.add(new Case(new int[]{-2, -2, 1, 1}, new int[]{1, 1, 4, 4}));

        return cases;
    }

}

class Case {
    int[] nums;
    int[] expected;

    public Case(int[] nums, int[] expected) {
        this.nums = nums;
        this.expected = expected;
    }

}

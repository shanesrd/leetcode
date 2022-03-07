package s0034;
/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (39.39%)
 * Likes:    8809
 * Dislikes: 265
 * Total Accepted:    951.3K
 * Total Submissions: 2.4M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in non-decreasing order, find the
 * starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 *
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 *
 *
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = searchIdx(nums, target, true);
        int rightIdx = searchIdx(nums, target, false);

        leftIdx = -1 == leftIdx ? rightIdx : leftIdx;
        rightIdx = -1 == rightIdx ? leftIdx : rightIdx;

        return new int[]{leftIdx, rightIdx};
    }

    public int searchIdx(int[] nums, int target, boolean left) {
        int sidx = 0;
        int eidx = nums.length - 1;
        int midx = 0;
        int idx = -1;
        boolean toLeft = false;

        while (sidx <= eidx) {
            midx = (sidx + eidx) / 2;
            if (target == nums[midx]) {
                idx = midx;
                toLeft = left;
            } else {
                toLeft = target < nums[midx];
            }

            if (toLeft) {
                eidx = midx - 1;
            } else {
                sidx = midx + 1;
            }
        }

        return idx;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int[] res = new Solution().searchRange(c.nums, c.target);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{1}, 0, arr(-1, -1)));
        cases.add(new Case(new int[]{1}, 2, arr(-1, -1)));
        cases.add(new Case(new int[]{1}, 1, arr(0, 0)));
        cases.add(new Case(new int[]{1, 2}, 0, arr(-1, -1)));
        cases.add(new Case(new int[]{1, 2}, 3, arr(-1, -1)));
        cases.add(new Case(new int[]{1, 2}, 1, arr(0, 0)));
        cases.add(new Case(new int[]{1, 2}, 2, arr(1, 1)));
        cases.add(new Case(new int[]{1, 2, 3}, 0, arr(-1, -1)));
        cases.add(new Case(new int[]{1, 2, 3}, 4, arr(-1, -1)));
        cases.add(new Case(new int[]{1, 2, 3}, 1, arr(0, 0)));
        cases.add(new Case(new int[]{1, 2, 3}, 2, arr(1, 1)));
        cases.add(new Case(new int[]{1, 2, 3}, 3, arr(2, 2)));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 0, arr(-1, -1)));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 2, arr(-1, -1)));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 4, arr(-1, -1)));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 6, arr(-1, -1)));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 8, arr(-1, -1)));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 1, arr(0, 0)));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 3, arr(1, 1)));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 5, arr(2, 2)));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 7, arr(3, 3)));
        cases.add(new Case(new int[]{1, 1}, 1, arr(0, 1)));
        cases.add(new Case(new int[]{1, 1}, 1, arr(0, 1)));
        cases.add(new Case(new int[]{1, 2, 2, 3}, 2, arr(1, 2)));
        cases.add(new Case(new int[]{1, 2, 3, 3}, 3, arr(2, 3)));
        cases.add(new Case(new int[]{1, 3, 3, 3, 3, 3, 4, 5}, 3, arr(1, 5)));

        return cases;
    }

    private static int[] arr(int... ints) {
        return ints;
    }

}

class Case {
    int[] nums;
    int target;
    int[] expected;

    public Case(int[] nums, int target, int[] expected) {
        this.nums = nums;
        this.target = target;
        this.expected = expected;
    }

}

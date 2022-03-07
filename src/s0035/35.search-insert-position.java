package s0035;
/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (42.58%)
 * Likes:    6372
 * Dislikes: 365
 * Total Accepted:    1.2M
 * Total Submissions: 2.8M
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 *
 * Example 3:
 *
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 *
 *
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int sidx = 0;
        int eidx = nums.length - 1;
        int midx = 0;

        while (sidx <= eidx) {
            midx = (sidx + eidx) / 2;

            if (target == nums[midx]) {
                return midx;
            } else if (target > nums[midx]) {
                sidx = midx + 1;
            } else {
                eidx = midx - 1;
            }
        }

        return sidx;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int res = new Solution().searchInsert(c.nums, c.target);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{1}, 0, 0));
        cases.add(new Case(new int[]{1}, 2, 1));
        cases.add(new Case(new int[]{1}, 1, 0));
        cases.add(new Case(new int[]{1, 2}, 0, 0));
        cases.add(new Case(new int[]{1, 2}, 3, 2));
        cases.add(new Case(new int[]{1, 2}, 1, 0));
        cases.add(new Case(new int[]{1, 2}, 2, 1));
        cases.add(new Case(new int[]{1, 2, 3}, 0, 0));
        cases.add(new Case(new int[]{1, 2, 3}, 4, 3));
        cases.add(new Case(new int[]{1, 2, 3}, 1, 0));
        cases.add(new Case(new int[]{1, 2, 3}, 2, 1));
        cases.add(new Case(new int[]{1, 2, 3}, 3, 2));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 0, 0));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 2, 1));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 4, 2));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 6, 3));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 8, 4));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 1, 0));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 3, 1));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 5, 2));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 7, 3));

        return cases;
    }

}

class Case {
    int[] nums;
    int target;
    int expected;

    public Case(int[] nums, int target, int expected) {
        this.nums = nums;
        this.target = target;
        this.expected = expected;
    }

}

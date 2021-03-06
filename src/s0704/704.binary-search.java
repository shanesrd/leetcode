package s0704;
/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 *
 * https://leetcode.com/problems/binary-search/description/
 *
 * algorithms
 * Easy (54.61%)
 * Likes:    3160
 * Dislikes: 86
 * Total Accepted:    582.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '[-1,0,3,5,9,12]\n9'
 *
 * Given an array of integers nums which is sorted in ascending order, and an
 * integer target, write a function to search target in nums. If target exists,
 * then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 10^4
 * -10^4 < nums[i], target < 10^4
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 *
 *
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

/*
class Solution {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int sidx, int eidx) {
        if (sidx >= eidx) {
            return target == nums[sidx] ? sidx : -1;
        }

        int midx = (sidx + eidx) / 2;
        if (target == nums[midx]) {
            return midx;
        } else if (target > nums[midx]) {
            return search(nums, target, midx + 1, eidx);
        } else {
            return search(nums, target, sidx, midx - 1);
        }
    }

}
*/

// @lc code=start
class Solution {

    public int search(int[] nums, int target) {
        int sidx = 0;
        int eidx = nums.length - 1;
        int midx = 0;

        while (true) {
            if (sidx >= eidx) {
                return target == nums[sidx] ? sidx : -1;
            }

            midx = (sidx + eidx) / 2;
            if (target == nums[midx]) {
                return midx;
            } else if (target > nums[midx]) {
                sidx = midx + 1;
            } else {
                eidx = midx -1;
            }
        }
    }

}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int res = new Solution().search(c.nums, c.target);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{1}, 0, -1));
        cases.add(new Case(new int[]{1}, 2, -1));
        cases.add(new Case(new int[]{1}, 1, 0));
        cases.add(new Case(new int[]{1, 2}, 0, -1));
        cases.add(new Case(new int[]{1, 2}, 3, -1));
        cases.add(new Case(new int[]{1, 2}, 1, 0));
        cases.add(new Case(new int[]{1, 2}, 2, 1));
        cases.add(new Case(new int[]{1, 2, 3}, 0, -1));
        cases.add(new Case(new int[]{1, 2, 3}, 4, -1));
        cases.add(new Case(new int[]{1, 2, 3}, 1, 0));
        cases.add(new Case(new int[]{1, 2, 3}, 2, 1));
        cases.add(new Case(new int[]{1, 2, 3}, 3, 2));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 0, -1));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 2, -1));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 4, -1));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 6, -1));
        cases.add(new Case(new int[]{1, 3, 5, 7}, 8, -1));
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

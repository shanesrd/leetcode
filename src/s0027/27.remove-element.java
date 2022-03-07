package s0027;
/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 *
 * https://leetcode.com/problems/remove-element/description/
 *
 * algorithms
 * Easy (50.70%)
 * Likes:    3041
 * Dislikes: 4649
 * Total Accepted:    1.1M
 * Total Submissions: 2.2M
 * Testcase Example:  '[3,2,2,3]\n3'
 *
 * Given an integer array nums and an integer val, remove all occurrences of
 * val in nums in-place. The relative order of the elements may be changed.
 *
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array
 * nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not
 * matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 *
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 * ⁠                           // It is sorted with no values equaling val.
 *
 * int k = removeElement(nums, val); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 * ⁠   assert nums[i] == expectedNums[i];
 * }
 *
 *
 * If all assertions pass, then your solution will be accepted.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements
 * of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements
 * of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 *
 *
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[idx++] = nums[i];
            }
        }

        return idx;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int res = new Solution().removeElement(c.nums, c.val);
            ResUtils.print(res, c.expected);
            ResUtils.printNotStrict(c.nums, c.numsExpected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        //cases.add(new Case(new int[]{0}, 1, 1, new int[]{0}));
        cases.add(new Case(new int[]{0}, 0, 0, new int[]{}));
        //cases.add(new Case(new int[]{0, 1}, 2, 2, new int[]{0, 1}));
        //cases.add(new Case(new int[]{0, 1}, 1, 1, new int[]{0}));
        //cases.add(new Case(new int[]{0, 1}, 0, 1, new int[]{1}));
        //cases.add(new Case(new int[]{0, 0, 1, 2}, 0, 2, new int[]{1, 2}));
        //cases.add(new Case(new int[]{0, 0, 1, 1, 2}, 1, 3, new int[]{0, 0, 2}));
        //cases.add(new Case(new int[]{0, 0, 1, 1, 2, 2}, 2, 4, new int[]{0, 0, 1, 1}));

        return cases;
    }

}

class Case {
    int[] nums;
    int val;
    int expected;
    int [] numsExpected;

    public Case(int[] nums, int val, int expected, int[] numsExpected) {
        this.nums = nums;
        this.val = val;
        this.expected = expected;
        this.numsExpected = numsExpected;
    }

}

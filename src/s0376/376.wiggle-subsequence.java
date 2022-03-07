package s0376;
/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 *
 * https://leetcode.com/problems/wiggle-subsequence/description/
 *
 * algorithms
 * Medium (44.55%)
 * Likes:    2511
 * Dislikes: 88
 * Total Accepted:    131.3K
 * Total Submissions: 294.7K
 * Testcase Example:  '[1,7,4,9,2,5]'
 *
 * A wiggle sequence is a sequence where the differences between successive
 * numbers strictly alternate between positive and negative. The first
 * difference (if one exists) may be either positive or negative. A sequence
 * with one element and a sequence with two non-equal elements are trivially
 * wiggle sequences.
 * 
 * 
 * For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences
 * (6, -3, 5, -7, 3) alternate between positive and negative.
 * In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences.
 * The first is not because its first two differences are positive, and the
 * second is not because its last difference is zero.
 * 
 * 
 * A subsequence is obtained by deleting some elements (possibly zero) from the
 * original sequence, leaving the remaining elements in their original order.
 * 
 * Given an integer array nums, return the length of the longest wiggle
 * subsequence of nums.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,7,4,9,2,5]
 * Output: 6
 * Explanation: The entire sequence is a wiggle sequence with differences (6,
 * -3, 5, -7, 3).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * Explanation: There are several subsequences that achieve this length.
 * One is [1, 17, 10, 13, 10, 16, 8] with differences (16, -7, 3, -3, 6, -8).
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * 
 * 
 * 
 * Follow up: Could you solve this in O(n) time?
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import util.ResUtils;

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int res = 1;

        int fi = 1;
        Boolean isPositive = null;

        for (; fi < nums.length; fi++) {
            int minus = nums[fi] - nums[fi - 1];
            Boolean minusBol = minus > 0 ? Boolean.TRUE : (minus == 0 ? null : Boolean.FALSE);
            if (Objects.isNull(minusBol)) {
                continue;
            }
            if (minusBol != isPositive) {
                isPositive = minusBol;
                res++;
            }
        }

        return res;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int res = new Solution().wiggleMaxLength(c.nums);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{1, 7, 4, 9, 2, 5},  6));
        cases.add(new Case(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8},  7));
        cases.add(new Case(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},  2));
        cases.add(new Case(new int[]{1},  1));
        cases.add(new Case(new int[]{1, 1},  1));
        cases.add(new Case(new int[]{1, 2},  2));

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


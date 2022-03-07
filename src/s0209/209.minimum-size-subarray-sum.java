package s0209;
/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (42.26%)
 * Likes:    5505
 * Dislikes: 169
 * Total Accepted:    456.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ...,
 * numsr-1, numsr] of which the sum is greater than or equal to target. If
 * there is no such subarray, return 0 instead.
 *
 *
 * Example 1:
 *
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem
 * constraint.
 *
 *
 * Example 2:
 *
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 *
 *
 * Example 3:
 *
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 *
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log(n)).
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

/*
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int len = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    len = j - i + 1;
                    break;
                }
            }

            if (len > 0 && (res > len || res == 0)) {
                res = len;
            }
        }

       return res;
    }
}
*/

// @lc code=start
class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int res = 0;

        int lidx = 0;
        int ridx = 0;
        int sum = 0;
        for (; ridx < nums.length; ridx++) {
            sum += nums[ridx];
            while (sum >= target) {
                int len = ridx - lidx + 1;
                res = (res > len || res == 0) ? len : res;
                sum -= nums[lidx++];
            }
        }

        return res;
    }

}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int res = new Solution().minSubArrayLen(c.target, c.nums);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{2, 3, 1, 2, 4, 3}, 7, 2));
        cases.add(new Case(new int[]{1, 4, 4}, 4, 1));
        cases.add(new Case(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 11, 0));
        cases.add(new Case(new int[]{1}, 3, 0));
        cases.add(new Case(new int[]{1, 1}, 3, 0));
        cases.add(new Case(new int[]{1, 1, 1}, 1, 1));
        cases.add(new Case(new int[]{1, 1, 1}, 3, 3));
        cases.add(new Case(new int[]{1, 1, 1}, 2, 2));
        cases.add(new Case(new int[]{1, 1, 2}, 2, 1));
        cases.add(new Case(new int[]{1, 1, 1, 3, 1, 2}, 3, 1));
        cases.add(new Case(new int[]{1, 1, 1, 3, 4, 1, 2, 2}, 4, 1));

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

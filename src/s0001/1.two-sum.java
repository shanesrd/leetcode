package s0001;
/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (48.27%)
 * Likes:    29437
 * Dislikes: 935
 * Total Accepted:    6M
 * Total Submissions: 12.4M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Only one valid answer exists.
 * 
 * 
 * 
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time
 * complexity?
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.ResUtils;

/*
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numMap.containsKey(nums[i])) {
                numMap.put(nums[i], new ArrayList<>());
            }
            numMap.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int minus = target - nums[i];

            if (!numMap.containsKey(minus)) {
                continue;
            }

            if (minus != nums[i]) {
                return new int[]{i, numMap.get(minus).get(0)};
            } else {
                if (numMap.get(minus).size() >= 2) {
                    return new int[]{numMap.get(minus).get(0), numMap.get(minus).get(1)};
                }
            }
        }

        return null;
    }
}
*/

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int minus = target - nums[i];
            if (map.containsKey(minus)) {
                return new int[]{i, map.get(minus)};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int[] res = new Solution().twoSum(c.nums, c.target);
            Arrays.sort(res);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}));
        cases.add(new Case(new int[]{3, 2, 4}, 6, new int[]{1, 2}));
        cases.add(new Case(new int[]{3, 3}, 6, new int[]{0, 1}));

        return cases;
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

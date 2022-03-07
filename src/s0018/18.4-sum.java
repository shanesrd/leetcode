package s0018;
/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (37.05%)
 * Likes:    5651
 * Dislikes: 644
 * Total Accepted:    545.9K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers, return an array of all the unique
 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 
 * 
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 
 * 
 * You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int lidx = j + 1;
                int ridx = nums.length - 1;

                while (lidx < ridx && lidx < nums.length) {
                    if (lidx > j + 1 && nums[lidx] == nums[lidx - 1]) {
                        lidx++;
                        continue;
                    }
                    if (ridx < nums.length - 1 && nums[ridx] == nums[ridx + 1]) {
                        ridx--;
                        continue;
                    }

                    int sum = nums[i] + nums[j] + nums[lidx] + nums[ridx];
                    if (target == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lidx], nums[ridx]));
                        lidx++;
                        ridx--;
                    } else if (target < sum) {
                        ridx--;
                    } else {
                        lidx++;
                    }
                }
            }
        }

        return res;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            List<List<Integer>> res = new Solution().fourSum(c.nums, c.target);
            ResUtils.print2(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        //cases.add(new Case(new int[]{1, 0, -1, 0, -2, 2}, 0, Arrays.asList(
        //    Arrays.asList(-2, -1, 1, 2), Arrays.asList(-2, 0, 0, 2), Arrays.asList(-1, 0, 0, 1))));
        //cases.add(new Case(new int[]{2, 2, 2, 2, 2}, 8, Collections.singletonList(Arrays.asList(2, 2, 2, 2))));
        cases.add(new Case(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0, Arrays.asList(Arrays.asList(-2,-1,1,2), Arrays.asList(-1,-1,1,1))));

        return cases;
    }

}

class Case {
    int[] nums;
    int target;
    List<List<Integer>> expected;

    public Case(int[] nums, int target, List<List<Integer>> expected) {
        this.nums = nums;
        this.target = target;
        this.expected = expected;
    }

}

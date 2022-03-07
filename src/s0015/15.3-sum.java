package s0015;
/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (30.64%)
 * Likes:    16188
 * Dislikes: 1550
 * Total Accepted:    1.8M
 * Total Submissions: 5.8M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * Input: nums = []
 * Output: []
 * Example 3:
 * Input: nums = [0]
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import util.ResUtils;

/*
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int num : nums) {
            Integer val = map.get(num);
            map.put(num, Objects.isNull(val) ? 1 : val + 1);
            if (Objects.isNull(val)) {
                list.add(num);
                idxMap.put(num, list.size() - 1);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int minus = -list.get(i) - list.get(j);
                if (minus != list.get(i) && minus != list.get(j)
                    && idxMap.containsKey(minus) && idxMap.get(minus) > j) {
                    res.add(Arrays.asList(list.get(i), list.get(j), minus));
                }
            }

            if (map.get(list.get(i)) >= 2) {
                int minus = -list.get(i) * 2;
                if (minus != list.get(i) && map.containsKey(minus)) {
                    res.add(Arrays.asList(list.get(i), list.get(i), minus));
                }
            }

            if (map.get(list.get(i)) >= 3 && 0 == list.get(i)) {
                res.add(Arrays.asList(0, 0, 0));
            }
        }

        return res;
    }
}
*/

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int lidx = i + 1;
            int ridx = nums.length - 1;

            while (lidx < ridx && lidx < nums.length) {
                if (lidx > i + 1 && nums[lidx] == nums[lidx - 1]) {
                    lidx++;
                    continue;
                }
                if (ridx < nums.length - 1 && nums[ridx] == nums[ridx + 1]) {
                    ridx--;
                    continue;
                }

                int sum = nums[i] + nums[lidx] + nums[ridx];
                if (0 == sum) {
                    res.add(Arrays.asList(nums[i], nums[lidx], nums[ridx]));
                    lidx++;
                    ridx--;
                } else if (0 < sum) {
                    ridx--;
                } else {
                    lidx++;
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
            List<List<Integer>> res = new Solution().threeSum(c.nums);
            ResUtils.print2(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{-1, 0, 1, 2, -1, -4}, Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1))));
        cases.add(new Case(new int[]{}, Collections.emptyList()));
        cases.add(new Case(new int[]{0}, Collections.emptyList()));
        cases.add(new Case(new int[]{0, 0, 0, 0, 0, 0}, Collections.singletonList(Arrays.asList(0, 0, 0))));
        cases.add(new Case(new int[]{-2, 0, 1, 1, 2}, Arrays.asList(Arrays.asList(-2, 0, 2), Arrays.asList(-2, 1, 1))));

        return cases;
    }

}

class Case {
    int[] nums;
    List<List<Integer>> expected;

    public Case(int[] nums, List<List<Integer>> expected) {
        this.nums = nums;
        this.expected = expected;
    }

}

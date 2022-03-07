package s0349;/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (68.45%)
 * Likes:    2486
 * Dislikes: 1849
 * Total Accepted:    618.5K
 * Total Submissions: 903.5K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two integer arrays nums1 and nums2, return an array of their
 * intersection. Each element in the result must be unique and you may return
 * the result in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];

        for (int i : nums1) {
            arr[i] = 1;
        }

        List<Integer> res = new ArrayList<>();
        for (int i : nums2) {
            if (arr[i] == -1) {
                continue;
            }

            if (arr[i] > 0) {
                res.add(i);
                arr[i] = -1;
            }
        }

        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }

        return resArr;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int[] res = new Solution().intersection(c.nums1, c.nums2);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{1,2,2,1}, new int[]{2, 2}, new int[]{2}));
        cases.add(new Case(new int[]{4,9,5}, new int[]{9,4,9,8,4}, new int[]{9, 4}));

        return cases;
    }

}

class Case {
    int[] nums1;
    int[] nums2;
    int[] expected;

    public Case(int[] nums1, int[] nums2, int[] expected) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.expected = expected;
    }

}

package s0347;
/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (64.46%)
 * Likes:    7492
 * Dislikes: 329
 * Total Accepted:    823K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * 
 * 
 * 
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 * 
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import util.ResUtils;

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cmap = new HashMap<>();
        for (int n : nums) {
            cmap.put(n, cmap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(cmap::get));
        cmap.forEach((key, value) -> {
            if (pq.size() < k) {
                pq.offer(key);
            } else if (cmap.get(pq.peek()) < value) {
                pq.poll();
                pq.offer(key);
            }
        });

        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }

       return res;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int[] res = new Solution().topKFrequent(c.nums, c.k);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{1, 1, 1, 2, 2, 3},  2,  new int[]{2, 1}));
        cases.add(new Case(new int[]{1}, 1, new int[]{1}));
        cases.add(new Case(new int[]{4, 1, -1, 2, -1, 2, 3},  2,  new int[]{-1, 2}));

        return cases;
    }

}

class Case {
    int[] nums;
    int k;
    int[] expected;

    public Case(int[] nums, int k, int[] expected) {
        this.nums = nums;
        this.k = k;
        this.expected = expected;
    }

}

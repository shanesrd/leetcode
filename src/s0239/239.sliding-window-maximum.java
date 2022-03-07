package s0239;
/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 *
 * https://leetcode.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (46.10%)
 * Likes:    8956
 * Dislikes: 312
 * Total Accepted:    532.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation: 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int ri = 0;

        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            push(q, nums[i]);
        }
        res[ri++] = front(q);

        for (int i = k; i < nums.length; i++) {
            pop(q, nums[i - k]);
            push(q, nums[i]);
            res[ri++] = front(q);
        }

        return res;
    }

    private void push(Deque<Integer> q, int n) {
        while (!q.isEmpty() && q.peekLast() < n) {
            q.pollLast();
        }
        q.offerLast(n);
    }

    private void pop(Deque<Integer> q, int n) {
        if (!q.isEmpty() && q.peekFirst() == n) {
            q.pollFirst();
        }
    }

    @SuppressWarnings("ConstantConditions")
    private int front(Deque<Integer> q) {
        return q.peekFirst();
    }

}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int[] res = new Solution().maxSlidingWindow(c.nums, c.k);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{1, 3, -1, -3, 5, 3, 6, 7},  3,  new int[]{3, 3, 5, 5, 6, 7}));
        cases.add(new Case(new int[]{1},  1,  new int[]{1}));

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

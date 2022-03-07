package s0024;
/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (57.03%)
 * Likes:    5571
 * Dislikes: 270
 * Total Accepted:    769.1K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head. You
 * must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1]
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import util.ResUtils;

/*
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode res = null;

        ListNode cur = head;
        ListNode[] preSr = null;
        while (Objects.nonNull(cur)) {
            ListNode tmp = Objects.nonNull(cur.next) ? cur.next.next : null;
            ListNode[] sr = swap(cur);

            if (Objects.nonNull(preSr)) {
                preSr[1].next = sr[0];
            } else {
                res = sr[0];
            }

            cur = tmp;
            preSr = sr;
        }

        return res;
    }

    private ListNode[] swap(ListNode node) {
        if (Objects.isNull(node.next)) {
            return new ListNode[]{node};
        }

        ListNode next = node.next;
        next.next = node;
        node.next = null;

        return new ListNode[]{next, node};
    }
}
*/

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }

        ListNode tmp = head.next.next;
        ListNode next = head.next;
        next.next = head;
        head.next = swapPairs(tmp);

        return next;
    }

}
// @lc code=end

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            ListNode ln = toList(c.nums);
            ListNode res = new Solution().swapPairs(ln);
            int[] resArr = toNums(res);
            ResUtils.print(resArr, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{}, new int[]{}));
        cases.add(new Case(new int[]{1}, new int[]{1}));
        cases.add(new Case(new int[]{1, 2}, new int[]{2, 1}));
        cases.add(new Case(new int[]{1, 2, 3}, new int[]{2, 1, 3}));
        cases.add(new Case(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 3}));
        cases.add(new Case(new int[]{1, 2, 3, 4, 5}, new int[]{2, 1, 4, 3, 5}));

        return cases;
    }

    private static ListNode toList(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        ListNode head = new ListNode(nums[0]);

        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }

        return head;
    }

    private static int[] toNums(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode cur = head;
        while (Objects.nonNull(cur)) {
            list.add(cur.val);
            cur = cur.next;
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

}

class Case {
    int[] nums;
    int[] expected;

    public Case(int[] nums, int[] expected) {
        this.nums = nums;
        this.expected = expected;
    }

}

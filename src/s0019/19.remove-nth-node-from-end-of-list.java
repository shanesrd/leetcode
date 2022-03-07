package s0019;
/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (37.84%)
 * Likes:    8789
 * Dislikes: 419
 * Total Accepted:    1.2M
 * Total Submissions: 3.3M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given the head of a linked list, remove the n^th node from the end of the
 * list and return its head.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1], n = 1
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1,2], n = 1
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 
 * 
 * 
 * Follow up: Could you do this in one pass?
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import util.ResUtils;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode v = new ListNode(0, head);
        ListNode f = v;
        ListNode b = v;

        while (Objects.nonNull(f)) {
            f = f.next;
            if (n-- < 0) {
                b = b.next;
            }
        }

        b.next = b.next.next;

        return v.next;
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
            ListNode res = new Solution().removeNthFromEnd(ln, c.th);
            int[] resArr = toNums(res);

            ResUtils.print(resArr, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{1}, 1, new int[]{}));
        cases.add(new Case(new int[]{1, 2}, 1, new int[]{1}));
        cases.add(new Case(new int[]{1, 2}, 2, new int[]{2}));
        cases.add(new Case(new int[]{1, 2, 3}, 1, new int[]{1, 2}));
        cases.add(new Case(new int[]{1, 2, 3}, 2, new int[]{1, 3}));
        cases.add(new Case(new int[]{1, 2, 3}, 3, new int[]{2, 3}));

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
    int th;
    int[] expected;

    public Case(int[] nums, int th, int[] expected) {
        this.nums = nums;
        this.th = th;
        this.expected = expected;
    }

}

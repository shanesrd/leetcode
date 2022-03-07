package s0142;/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 *
 * algorithms
 * Medium (43.65%)
 * Likes:    6597
 * Dislikes: 441
 * Total Accepted:    619.9K
 * Total Submissions: 1.4M
 * Testcase Example:  '[3,2,0,-4]\n1'
 *
 * Given the head of a linked list, return the node where the cycle begins. If
 * there is no cycle, return null.
 * 
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos
 * is used to denote the index of the node that tail's next pointer is
 * connected to (0-indexed). It is -1 if there is no cycle. Note that pos is
 * not passed as a parameter.
 * 
 * Do not modify the linked list.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * second node.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * first node.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of the nodes in the list is in the range [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * pos is -1 or a valid index in the linked-list.
 * 
 * 
 * 
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import util.ResUtils;

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode i1 = head;
                ListNode i2 = fast;

                while (i1 != i2) {
                    i1 = i1.next;
                    i2 = i2.next;
                }

                return i1;
            }
        }

        return null;
    }
}
// @lc code=end

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            ListNode ln = toList(c.nums, c.pos);
            ListNode rn = new Solution().detectCycle(ln);
            int res = Objects.isNull(rn) ? 0 : rn.val;
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{3, 2, 0, -4}, 1, 2));
        cases.add(new Case(new int[]{1, 2}, 0, 1));
        cases.add(new Case(new int[]{1}, -1, 0));
        cases.add(new Case(new int[]{1}, 0, 1));

        return cases;
    }

    private static ListNode toList(int[] nums, int pos) {
        ListNode v = new ListNode(0);

        ListNode cur = v;
        ListNode t = null;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;

            if (i == pos) {
                t = node;
            }
        }
        cur.next = t;

        return v.next;
    }

}

class Case {
    int[] nums;
    int pos;
    int expected;

    public Case(int[] nums, int pos, int expected) {
        this.nums = nums;
        this.pos = pos;
        this.expected = expected;
    }
}

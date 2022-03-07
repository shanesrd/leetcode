package s0203;
/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
 *
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (42.68%)
 * Likes:    4315
 * Dislikes: 154
 * Total Accepted:    631.5K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * Given the head of a linked list and an integer val, remove all the nodes of
 * the linked list that has Node.val == val, and return the new head.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [], val = 1
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 10^4].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import util.ResUtils;

/*
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (Objects.isNull(head)) {
            return null;
        }

        ListNode res = null;
        ListNode next = null;

        ListNode cur = head;
        while (Objects.nonNull(cur)) {
            if (cur.val != val) {
                if (Objects.isNull(res)) {
                    res = cur;
                } else {
                    next.next = cur;
                }

                next = cur;
            }

            cur = cur.next;
        }

        if (Objects.nonNull(next)) {
            next.next = null;
        }

        return res;
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode vn = new ListNode();

        if (Objects.isNull(head)) {
            return null;
        }

        ListNode next = vn;
        ListNode cur = head;
        while (Objects.nonNull(cur)) {
            if (cur.val != val) {
                next.next = cur;
                next = cur;
            }

            cur = cur.next;
        }
        next.next = null;

        return vn.next;
    }
}
// @lc code=end

/**
 * Definition for singly-linked list.
 */
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
            ListNode ln = fromNums(c.nums);
            ListNode resLn = new Solution().removeElements(ln, c.val);
            int[] res = toNums(resLn);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{1, 2, 6, 3, 4, 5, 6}, 6, new int[]{1, 2, 3, 4, 5}));
        cases.add(new Case(new int[]{}, 1, new int[]{}));

        return cases;
    }

    private static ListNode fromNums(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        ListNode head = null;
        ListNode next = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            head = new ListNode(nums[i]);
            head.next = next;
            next = head;
        }

        return head;
    }

    private static int[] toNums(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (Objects.nonNull(head)) {
            list.add(head.val);
            head = head.next;
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

}

class Case {
    int[] nums;
    int val;
    int[] expected;

    public Case(int[] nums, int val, int[] expected) {
        this.nums = nums;
        this.val = val;
        this.expected = expected;
    }

}

package s0206;
/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (69.20%)
 * Likes:    10219
 * Dislikes: 176
 * Total Accepted:    1.9M
 * Total Submissions: 2.7M
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2]
 * Output: [2,1]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = []
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * 
 * 
 * 
 * Follow up: A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import util.ResUtils;

/*
class Solution {
    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }

        ListNode cur = head;
        int i = 0;
        while (Objects.nonNull(cur.next)) {
            i++;
            cur = cur.next;
        }

        ListNode tail = cur;
        cur = null;

        for (; i > 0; i--) {
            ListNode icur = head;
            ListNode ipre = null;
            while (Objects.nonNull(icur.next)) {
                ipre = icur;
                icur = icur.next;
            }

            ListNode itail = icur;
            itail.next = head;
            ipre.next = null;
            if (Objects.nonNull(cur)) {
                cur.next = itail;
            }

            cur = itail;
        }

        return tail;
    }
}
*/

/*
class Solution {
    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }

        ListNode res = null;

        ListNode pre = null;
        ListNode tailPre = null;
        while (true) {
            ListNode tail = head;
            while (Objects.nonNull(tail.next)) {
                tailPre = tail;
                tail = tail.next;
            }

            if (Objects.nonNull(pre)) {
                pre.next = tail;
            } else {
                res = tail;
            }

            pre = tail;
            tailPre.next = null;

            if (tail == head) {
                break;
            }
        }

        return res;
    }
}
*/


/*
class Solution {
    public ListNode reverseList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();

         ListNode cur = head;
         while (Objects.nonNull(cur)) {
             nodes.add(cur);
             cur = cur.next;
         }

         int count = nodes.size();

         if (0 == count) {
             return null;
         }

         for (int i = count - 1; i > 0; i--) {
             nodes.get(i).next = nodes.get(i - 1);
         }
         nodes.get(0).next = null;

         return nodes.get(count - 1);
    }

}
*/

/*
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (Objects.nonNull(cur)) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
*/

/*
class Solution {
    public ListNode reverseList(ListNode head) {
        return reversed(head)[0];
    }

    private ListNode[] reversed(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return new ListNode[]{head, null};
        }

        if (Objects.isNull(head.next.next)) {
            ListNode tail = head.next;
            tail.next = head;
            head.next = null;

            return new ListNode[]{tail, head};
        }

        ListNode[] res = reversed(head.next);
        head.next = null;
        res[1].next = head;


        return new ListNode[]{res[0], head};
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
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur) {
        if (Objects.isNull(cur)) {
            return pre;
        }

        ListNode next = cur.next;
        cur.next = pre;

        return reverse(cur, next);
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
            ListNode resList = new Solution().reverseList(toList(c.nums));
            ResUtils.print(toNums(resList), c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{}, new int[]{}));
        cases.add(new Case(new int[]{1}, new int[]{1}));
        cases.add(new Case(new int[]{1, 2}, new int[]{2, 1}));
        cases.add(new Case(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
        cases.add(new Case(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1}));

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

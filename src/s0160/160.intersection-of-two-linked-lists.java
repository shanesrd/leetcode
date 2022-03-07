package s0160;/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 *
 * algorithms
 * Easy (48.93%)
 * Likes:    8017
 * Dislikes: 809
 * Total Accepted:    866K
 * Total Submissions: 1.8M
 * Testcase Example:  '8\n[4,1,8,4,5]\n[5,6,1,8,4,5]\n2\n3'
 *
 * Given the heads of two singly linked-lists headA and headB, return the node
 * at which the two lists intersect. If the two linked lists have no
 * intersection at all, return null.
 * 
 * For example, the following two linked lists begin to intersect at node c1:
 * 
 * The test cases are generated such that there are no cycles anywhere in the
 * entire linked structure.
 * 
 * Note that the linked lists must retain their original structure after the
 * function returns.
 * 
 * Custom Judge:
 * 
 * The inputs to the judge are given as follows (your program is not given
 * these inputs):
 * 
 * 
 * intersectVal - The value of the node where the intersection occurs. This is
 * 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head)
 * to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head)
 * to get to the intersected node.
 * 
 * 
 * The judge will then create the linked structure based on these inputs and
 * pass the two heads, headA and headB to your program. If you correctly return
 * the intersected node, then your solution will be accepted.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA =
 * 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0
 * if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as
 * [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are
 * 3 nodes before the intersected node in B.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3,
 * skipB = 1
 * Output: Intersected at '2'
 * Explanation: The intersected node's value is 2 (note that this must not be 0
 * if the two lists intersect).
 * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as
 * [3,2,4]. There are 3 nodes before the intersected node in A; There are 1
 * node before the intersected node in B.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB =
 * 2
 * Output: No intersection
 * Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it
 * reads as [1,5]. Since the two lists do not intersect, intersectVal must be
 * 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes of listA is in the m.
 * The number of nodes of listB is in the n.
 * 1 <= m, n <= 3 * 10^4
 * 1 <= Node.val <= 10^5
 * 0 <= skipA < m
 * 0 <= skipB < n
 * intersectVal is 0 if listA and listB do not intersect.
 * intersectVal == listA[skipA] == listB[skipB] if listA and listB
 * intersect.
 * 
 * 
 * 
 * Follow up: Could you write a solution that runs in O(m + n) time and use
 * only O(1) memory?
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
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);
        int gap = lenA - lenB;

        if (gap < 0) {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
            gap = -gap;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        while (gap-- > 0) {
            curA = curA.next;
        }

        while (Objects.nonNull(curA)) {
            if (curA == curB) {
                return curA;
            }

            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }

    private int len(ListNode ln) {
        int len = 0;

        while (Objects.nonNull(ln)) {
            len++;
            ln = ln.next;
        }

        return len;
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
            ListNode[] lns = toList(c.numsA, c.numsB, c.skipA, c.skipB);
            ListNode ln = new Solution().getIntersectionNode(lns[0], lns[1]);
            int res = Objects.isNull(ln) ? 0 : ln.val;
            ResUtils.print(res, c.expeceted);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{4, 1, 8, 4, 5}, new int[]{5, 6, 1, 8, 4, 5}, 2, 3, 8));
        cases.add(new Case(new int[]{1, 9, 1, 2, 4}, new int[]{3, 2, 4}, 3, 1, 2));
        cases.add(new Case(new int[]{2, 6, 4}, new int[]{1, 5}, 3, 2, 0));
        cases.add(new Case(new int[]{2}, new int[]{1}, 1, 1, 0));
        cases.add(new Case(new int[]{2}, new int[]{2}, 0, 0, 2));
        cases.add(new Case(new int[]{1, 2}, new int[]{3, 2}, 1, 1, 2));
        cases.add(new Case(new int[]{1, 2}, new int[]{3, 4}, 2, 2, 0));

        return cases;
    }

    private static ListNode[] toList(int[] numsA, int[] numsB, int skipA, int skipB) {
        ListNode interNode = null;

        ListNode vha = new ListNode(-1);
        ListNode vca = vha;
        for (int j : numsA) {
            ListNode node = new ListNode(j);
            vca.next = node;
            vca = node;

            if (skipA-- == 0) {
                interNode = node;
            }
        }


        ListNode vhb = new ListNode(-1);
        ListNode vcb = vhb;
        for (int j : numsB) {
            if (skipB-- == 0) {
                vcb.next = interNode;
                break;
            }

            ListNode node = new ListNode(j);
            vcb.next = node;
            vcb = node;
        }

        return new ListNode[]{vha.next, vhb.next};
    }

}

class Case {
    int[] numsA;
    int[] numsB;
    int skipA;
    int skipB;
    int expeceted;

    public Case(int[] numsA, int[] numsB, int skipA, int skipB, int expeceted) {
        this.numsA = numsA;
        this.numsB = numsB;
        this.skipA = skipA;
        this.skipB = skipB;
        this.expeceted = expeceted;
    }

}

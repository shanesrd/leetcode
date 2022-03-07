package s0707;
/*
 * @lc app=leetcode id=707 lang=java
 *
 * [707] Design Linked List
 *
 * https://leetcode.com/problems/design-linked-list/description/
 *
 * algorithms
 * Medium (26.71%)
 * Likes:    1266
 * Dislikes: 1094
 * Total Accepted:    164.1K
 * Total Submissions: 614.2K
 * Testcase Example:  '["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]\n' +
  '[[],[1],[3],[1,2],[1],[1],[1]]'
 *
 * Design your implementation of the linked list. You can choose to use a
 * singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val
 * is the value of the current node, and next is a pointer/reference to the
 * next node.
 * If you want to use the doubly linked list, you will need one more attribute
 * prev to indicate the previous node in the linked list. Assume all nodes in
 * the linked list are 0-indexed.
 * 
 * Implement the MyLinkedList class:
 * 
 * 
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the index^th node in the linked list. If
 * the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of
 * the linked list. After the insertion, the new node will be the first node of
 * the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of
 * the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the
 * index^th node in the linked list. If index equals the length of the linked
 * list, the node will be appended to the end of the linked list. If index is
 * greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the index^th node in the linked list,
 * if the index is valid.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get",
 * "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 * 
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and
 * deleteAtIndex.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import util.ResUtils;

// @lc code=start
class MyLinkedList {

    Node head;

    public MyLinkedList() {
    }
    
    public int get(int index) {
        Node cur = head;

        while (Objects.nonNull(cur) && index > 0) {
            cur = cur.next;
            index--;
        }

        return Objects.isNull(cur) ? -1 : cur.val;
    }
    
    public void addAtHead(int val) {
        head = new Node(val, head);
    }

    public void addAtTail(int val) {
        Node vn = new Node(0, head);

        Node cur = vn;
        while (Objects.nonNull(cur.next)) {
            cur = cur.next;
        }

        cur.next = new Node(val, null);
        head = vn.next;
    }
    
    public void addAtIndex(int index, int val) {
        Node vn = new Node(0, head);

        Node cur = vn;
        while (Objects.nonNull(cur) && index-- > 0) {
            cur = cur.next;
        }

        if (Objects.nonNull(cur)) {
            cur.next = new Node(val, cur.next);
        }

        head = vn.next;
    }
    
    public void deleteAtIndex(int index) {
        Node vn = new Node(0, head);

        Node pre = vn, cur = vn;
        while (Objects.nonNull(cur) && index-- >= 0) {
            pre = cur;
            cur = cur.next;
        }

        if (Objects.nonNull(cur)) {
            pre.next = cur.next;
        }

        head = vn.next;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}



/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

class Main {

    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();

        int[] vals = new int[]{mll.get(0), mll.get(1)};
        ResUtils.print(vals, new int[]{-1, -1});

        mll.addAtHead(10);
        ResUtils.print(toVals(mll), new int[]{10});

        mll.addAtHead(9);
        ResUtils.print(toVals(mll), new int[]{9, 10});

        mll.addAtIndex(3, 12);
        ResUtils.print(toVals(mll), new int[]{9, 10});

        mll.addAtIndex(0, 6);
        ResUtils.print(toVals(mll), new int[]{6, 9, 10});

        mll.addAtIndex(1, 8);
        ResUtils.print(toVals(mll), new int[]{6, 8, 9, 10});

        mll.addAtIndex(3, 29);
        ResUtils.print(toVals(mll), new int[]{6, 8, 9, 29, 10});

        mll.deleteAtIndex(6);
        ResUtils.print(toVals(mll), new int[]{6, 8, 9, 29, 10});

        mll.deleteAtIndex(0);
        ResUtils.print(toVals(mll), new int[]{8, 9, 29, 10});

        mll.deleteAtIndex(3);
        ResUtils.print(toVals(mll), new int[]{8, 9, 29});

        mll.deleteAtIndex(1);
        ResUtils.print(toVals(mll), new int[]{8, 29});

        mll = new MyLinkedList();

        mll.addAtTail(5);
        ResUtils.print(toVals(mll), new int[]{5});

        mll.addAtTail(6);
        ResUtils.print(toVals(mll), new int[]{5, 6});

        mll = new MyLinkedList();
        mll.addAtIndex(1, 3);
        ResUtils.print(toVals(mll), new int[]{});

        mll.addAtIndex(0, 3);
        ResUtils.print(toVals(mll), new int[]{3});

        mll = new MyLinkedList();
        mll.deleteAtIndex(1);
        ResUtils.print(toVals(mll), new int[]{});

        mll.addAtHead(1);
        mll.deleteAtIndex(0);
        ResUtils.print(toVals(mll), new int[]{});
    }

    private static int[] toVals(MyLinkedList mll) {
        List<Integer> vals = new ArrayList<>();

        for (int idx = 0; idx <=10000; idx++) {
            int val = mll.get(idx);
            if (-1 == val) {
                break;
            }

            vals.add(val);
        }

        return vals.stream().mapToInt(i -> i).toArray();
    }

}

package s0117;
/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * algorithms
 * Medium (45.97%)
 * Likes:    3461
 * Dislikes: 232
 * Total Accepted:    415.6K
 * Total Submissions: 904K
 * Testcase Example:  '[1,2,3,4,5,null,7]'
 *
 * Given a binary tree
 * 
 * 
 * struct Node {
 * ⁠ int val;
 * ⁠ Node *left;
 * ⁠ Node *right;
 * ⁠ Node *next;
 * }
 * 
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should
 * populate each next pointer to point to its next right node, just like in
 * Figure B. The serialized output is in level order as connected by the next
 * pointers, with '#' signifying the end of each level.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 6000].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow-up:
 * 
 * 
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not
 * count as extra space for this problem.
 * 
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {
    public Node connect(Node root) {
        if (Objects.isNull(root)) {
            return null;
        }

        Node levelHead = root;
        while (Objects.nonNull(levelHead)) {
            Node node = levelHead;
            while (Objects.nonNull(node)) {
                Node nnlf = Objects.nonNull(node.next) ? nextLevelFirst(node.next) : null;
                if (Objects.nonNull(node.left)) {
                    node.left.next = Objects.nonNull(node.right) ? node.right : nnlf;
                }
                if (Objects.nonNull(node.right)) {
                    node.right.next = nnlf;
                }

                node = node.next;
            }


            levelHead = nextLevelFirst(levelHead);
        }

        return root;
    }

    private Node nextLevelFirst(Node node) {
        while (Objects.nonNull(node)) {
            if (Objects.nonNull(node.left)) {
                return node.left;
            }
            if (Objects.nonNull(node.right)) {
                return node.right;
            }

            node = node.next;
        }

        return null;
    }
}
// @lc code=end

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            Node res = new Solution().connect(c.root);
            System.out.println(res);
        });
    }

    @SuppressWarnings("ConstantConditions")
    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        Node n11 = new Node(1);
        Node n12 = new Node(2);
        Node n13 = new Node(3);
        Node n14 = new Node(4);
        Node n15 = new Node(5);
        Node n16 = new Node(7);
        n11.left = n12;
        n11.right = n13;
        n12.left = n14;
        n12.right = n15;
        n13.right = n16;

        Node n21 = null;

        cases.add(new Case(n11));
        cases.add(new Case(n21));

        return cases;
    }

}

class Case {
    Node root;

    public Case(Node root) {
        this.root = root;
    }

}

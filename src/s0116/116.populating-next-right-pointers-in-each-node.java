package s0116;/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 *
 * algorithms
 * Medium (56.08%)
 * Likes:    5958
 * Dislikes: 219
 * Total Accepted:    694.3K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,4,5,6,7]'
 *
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following
 * definition:
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
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function
 * should populate each next pointer to point to its next right node, just like
 * in Figure B. The serialized output is in level order as connected by the
 * next pointers, with '#' signifying the end of each level.
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
 * The number of nodes in the tree is in the range [0, 2^12 - 1].
 * -1000 <= Node.val <= 1000
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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
class Solution {
    public Node connect(Node root) {
        if (Objects.isNull(root)) {
            return null;
        }

        next(root, root.left, root.right);

        return root;
    }

    private void next(Node parent, Node left, Node right) {
        if (Objects.isNull(left)) {
            return;
        }

        left.next = right;
        if (Objects.nonNull(parent.next)) {
            right.next = parent.next.left;
        }

        next(left, left.left, left.right);
        next(right, right.left, right.right);
    }
}
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
class Solution {
    public Node connect(Node root) {
        if (Objects.isNull(root)) {
            return null;
        }

        Node levelHead = root;
        while (Objects.nonNull(levelHead.left)) {
            Node node = levelHead;
            while (Objects.nonNull(node)) {
                node.left.next = node.right;
                if (Objects.nonNull(node.next)) {
                    node.right.next = node.next.left;
                }

                node = node.next;
            }

            levelHead = levelHead.left;
        }

        return root;
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

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        Node n11 = new Node(1);
        Node n12 = new Node(2);
        Node n13 = new Node(3);
        Node n14 = new Node(4);
        Node n15 = new Node(5);
        Node n16 = new Node(6);
        Node n17 = new Node(7);
        n11.left = n12;
        n11.right = n13;
        n12.left = n14;
        n12.right = n15;
        n13.left = n16;
        n13.right = n17;

        cases.add(new Case(n11));

        return cases;
    }

}

class Case {
    Node root;

    public Case(Node root) {
        this.root = root;
    }

}

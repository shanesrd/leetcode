package s0094;
/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Easy (70.14%)
 * Likes:    7040
 * Dislikes: 311
 * Total Accepted:    1.4M
 * Total Submissions: 1.9M
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes'
 * values.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1]
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import util.ResUtils;

/*
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        traversal(root, list);

        return list;
    }

    private void traversal(TreeNode node, List<Integer> list) {
        if (Objects.isNull(node)) {
            return;
        }

        traversal(node.left, list);
        list.add(node.val);
        traversal(node.right, list);
    }
}
*/

/*
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (Objects.isNull(root)) {
            return list;
        }

        Deque<TreeNode> d = new LinkedList<>();
        TreeNode cur = root;
        while (Objects.nonNull(cur) || !d.isEmpty()) {
            if (Objects.nonNull(cur)) {
                d.push(cur);
                cur = cur.left;
            } else {
                cur = d.pop();
                list.add(cur.val);
                cur  = cur.right;
            }
        }

        return list;
    }
}
*/

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (Objects.isNull(root)) {
            return list;
        }

        Deque<TreeNode> d = new LinkedList<>();
        d.push(root);
        while (!d.isEmpty()) {
            TreeNode node = d.pop();

            if (Objects.nonNull(node)) {
                if (Objects.nonNull(node.right)) {
                    d.push(node.right);
                }
                d.push(node);
                d.push(null);
                if (Objects.nonNull(node.left)) {
                    d.push(node.left);
                }
            } else {
                node = d.pop();
                list.add(node.val);
            }
        }

        return list;
    }
}
// @lc code=end

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            List<Integer> res = new Solution().inorderTraversal(c.root);
            ResUtils.print12(res, c.expected);
        });
    }

    @SuppressWarnings("ConstantConditions")
    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        TreeNode tr1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        List<Integer> e1 = Arrays.asList(1, 3, 2);

        TreeNode tr2 = null;
        List<Integer> e2 = Collections.emptyList();

        TreeNode tr3 = new TreeNode(1, null, null);
        List<Integer> e3 = Collections.singletonList(1);

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        TreeNode t12 = new TreeNode(12);
        TreeNode t13 = new TreeNode(13);
        TreeNode t14 = new TreeNode(14);
        TreeNode t15 = new TreeNode(15);
        t4.left = t8;
        t4.right = t9;
        t5.left = t10;
        t5.right = t11;
        t6.left = t12;
        t6.right = t13;
        t7.left = t14;
        t7.right = t15;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t1.left = t2;
        t1.right = t3;

        cases.add(new Case(tr1, e1));
        cases.add(new Case(tr2, e2));
        cases.add(new Case(tr3, e3));
        cases.add(new Case(t1, Arrays.asList(8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15)));

        return cases;
    }

}

class Case {
    TreeNode root;
    List<Integer> expected;

    public Case(TreeNode root, List<Integer> expected) {
        this.root = root;
        this.expected = expected;
    }

}

package s0226;/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
 *
 * https://leetcode.com/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (70.97%)
 * Likes:    7721
 * Dislikes: 103
 * Total Accepted:    951K
 * Total Submissions: 1.3M
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * 
 * 
 * Example 3:
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
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/*
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
*/

/*
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }

        Deque<TreeNode> q = new LinkedList<>();
        q.push(root);
        while (!q.isEmpty()) {
            TreeNode node = q.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (Objects.nonNull(node.left)) {
                q.push(node.left);
            }
            if (Objects.nonNull(node.right)) {
                q.push(node.right);
            }
        }

        return root;
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
    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }

        Queue<TreeNode > q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (Objects.nonNull(node.left)) {
                q.offer(node.left);
            }
            if (Objects.nonNull(node.right)) {
                q.offer(node.right);
            }
        }

        return root;
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
            TreeNode res = new Solution().invertTree(c.root);
            System.out.println(res);
        });
    }

    @SuppressWarnings("ConstantConditions")
    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        TreeNode n11 = new TreeNode(4);
        TreeNode n12 = new TreeNode(2);
        TreeNode n13 = new TreeNode(7);
        TreeNode n14 = new TreeNode(1);
        TreeNode n15 = new TreeNode(3);
        TreeNode n16 = new TreeNode(6);
        TreeNode n17 = new TreeNode(9);
        n11.left = n12;
        n11.right = n13;
        n12.left = n14;
        n12.right = n15;
        n13.left = n16;
        n13.right = n17;

        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(1);
        TreeNode n23 = new TreeNode(3);
        n21.left = n22;
        n21.right = n23;

        TreeNode n31 = null;

        cases.add(new Case(n11));
        cases.add(new Case(n21));
        cases.add(new Case(n31));

        return cases;
    }

}

class Case {
    TreeNode root;

    public Case(TreeNode root) {
        this.root = root;
    }

}

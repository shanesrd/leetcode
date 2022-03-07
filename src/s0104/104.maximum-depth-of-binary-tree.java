package s0104;
/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (71.45%)
 * Likes:    6406
 * Dislikes: 120
 * Total Accepted:    1.5M
 * Total Submissions: 2.2M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,null,2]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^4].
 * -100 <= Node.val <= 100
 * 
 * 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

import util.ResUtils;

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
    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (Objects.nonNull(node.left)) {
                    q.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    q.offer(node.right);
                }
            }
        }

        return res;
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
            int res = new Solution().maxDepth(c.root);
            ResUtils.print(res, c.expected);
        });
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        TreeNode n11 = new TreeNode(3);
        TreeNode n12 = new TreeNode(5);
        TreeNode n13 = new TreeNode(20);
        TreeNode n14 = new TreeNode(15);
        TreeNode n15 = new TreeNode(7);
        n11.left = n12;
        n11.right = n13;
        n13.left = n14;
        n13.right = n15;

        TreeNode n21 = new TreeNode(1);
        TreeNode n22 = new TreeNode(2);
        n21.right = n22;

        cases.add(new Case(n11, 3));
        cases.add(new Case(n21, 2));

        return cases;
    }

}

class Case {
    TreeNode root;
    int expected;

    public Case(TreeNode root, int expected) {
        this.root = root;
        this.expected = expected;
    }

}

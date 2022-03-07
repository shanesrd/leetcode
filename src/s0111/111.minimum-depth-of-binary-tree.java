package s0111;
/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (42.14%)
 * Likes:    3779
 * Dislikes: 931
 * Total Accepted:    711.9K
 * Total Submissions: 1.7M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^5].
 * -1000 <= Node.val <= 1000
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
    public int minDepth(TreeNode root) {
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
                if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
                    return res;
                }
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
            int res = new Solution().minDepth(c.root);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        TreeNode n11 = new TreeNode(3);
        TreeNode n12 = new TreeNode(9);
        TreeNode n13 = new TreeNode(20);
        TreeNode n14 = new TreeNode(15);
        TreeNode n15 = new TreeNode(7);
        n11.left = n12;
        n11.right = n13;
        n13.left = n14;
        n13.right = n15;

        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(3);
        TreeNode n23 = new TreeNode(4);
        TreeNode n24 = new TreeNode(5);
        TreeNode n25 = new TreeNode(6);
        n21.right = n22;
        n22.right = n23;
        n23.right = n24;
        n24.right = n25;

        cases.add(new Case(n11, 2));
        cases.add(new Case(n21, 5));

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

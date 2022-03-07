package s0515;
/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (64.24%)
 * Likes:    1892
 * Dislikes: 80
 * Total Accepted:    180.2K
 * Total Submissions: 280.6K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * Given the root of a binary tree, return an array of the largest value in
 * each row of the tree (0-indexed).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3]
 * Output: [1,3]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree will be in the range [0, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (Objects.isNull(root)) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                max = Math.max(node.val, max);

                if (Objects.nonNull(node.left)) {
                    q.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    q.offer(node.right);
                }
            }
            res.add(max);
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
            List<Integer> res = new Solution().largestValues(c.root);
            ResUtils.print12(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        TreeNode n11 = new TreeNode(1);
        TreeNode n12 = new TreeNode(3);
        TreeNode n13 = new TreeNode(2);
        TreeNode n14 = new TreeNode(5);
        TreeNode n15 = new TreeNode(3);
        TreeNode n16 = new TreeNode(9);
        n11.left = n12;
        n11.right = n13;
        n12.left = n14;
        n12.right = n15;
        n13.right = n16;
        List<Integer> e1 = Arrays.asList(1, 3, 9);

        TreeNode n21 = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        List<Integer> e2 = Arrays.asList(1, 3);

        cases.add(new Case(n11, e1));
        cases.add(new Case(n21, e2));

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

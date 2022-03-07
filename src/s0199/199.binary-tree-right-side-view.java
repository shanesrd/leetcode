package s0199;
/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (59.19%)
 * Likes:    5989
 * Dislikes: 324
 * Total Accepted:    623.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * Given the root of a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from top to
 * bottom.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,null,3]
 * Output: [1,3]
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
import java.util.Arrays;
import java.util.Collections;
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (Objects.isNull(root)) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (Objects.nonNull(node.left)) {
                    q.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    q.offer(node.right);
                }

                if (i == size - 1) {
                    res.add(node.val);
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
            List<Integer> res = new Solution().rightSideView(c.root);
            ResUtils.print12(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        TreeNode tr1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5, null, null)),
                                                    new TreeNode(3, null, new TreeNode(4, null, null)));
        List<Integer> e1 = Arrays.asList(1, 3, 4);

        TreeNode tr2 = new TreeNode(1, null, new TreeNode(3, null, null));
        List<Integer> e2 = Arrays.asList(1, 3);

        TreeNode tr3 = null;
        List<Integer> e3 = Collections.emptyList();

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
        cases.add(new Case(t1, Arrays.asList(1, 3, 7, 15)));

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

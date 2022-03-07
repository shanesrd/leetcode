package s0102;
/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (60.37%)
 * Likes:    7422
 * Dislikes: 148
 * Total Accepted:    1.1M
 * Total Submissions: 1.9M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given the root of a binary tree, return the level order traversal of its
 * nodes' values. (i.e., from left to right, level by level).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1]
 * Output: [[1]]
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
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
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

/*
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        traversal(root, res, 0);

        return res;
    }

    private void traversal(TreeNode node, List<List<Integer>> list, int deep) {
        if (Objects.isNull(node)) {
            return;
        }

        if (list.size() < deep + 1) {
            list.add(new ArrayList<>());
        }
        List<Integer> ilist = list.get(deep);
        ilist.add(node.val);

        deep++;
        traversal(node.left, list, deep);
        traversal(node.right, list, deep);
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (Objects.isNull(root)) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (Objects.nonNull(node.left)) {
                    q.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    q.offer(node.right);
                }
            }
            res.add(list);
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
            List<List<Integer>> res = new Solution().levelOrder(c.root);
            ResUtils.print2(res, c.expected);
        });
    }

    @SuppressWarnings("ConstantConditions")
    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        TreeNode tr1 = new TreeNode(3, new TreeNode(9, null, null),
                                    new TreeNode(20, new TreeNode(15, null, null),
                                                 new TreeNode(7, null, null)));
        List<List<Integer>> e1 = Arrays.asList(Collections.singletonList(3), Arrays.asList(9, 20), Arrays.asList(15, 7));

        TreeNode tr2 = new TreeNode(1, null, null);
        List<List<Integer>> e2 = Collections.singletonList(Collections.singletonList(1));

        TreeNode tr3 = null;
        List<List<Integer>> e3 = Collections.emptyList();

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
        cases.add(new Case(t1, Arrays.asList(Collections.singletonList(1), Arrays.asList(2, 3),
                                             Arrays.asList(4, 5, 6, 7), Arrays.asList(8, 9, 10, 11, 12, 13, 14, 15))));

        return cases;
    }

}

class Case {
    TreeNode root;
    List<List<Integer>> expected;

    public Case(TreeNode root, List<List<Integer>> expected) {
        this.root = root;
        this.expected = expected;
    }

}

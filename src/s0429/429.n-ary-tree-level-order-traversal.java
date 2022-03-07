package s0429;
/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (68.63%)
 * Likes:    1681
 * Dislikes: 81
 * Total Accepted:    165.6K
 * Total Submissions: 241.3K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * 
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
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
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        if (Objects.isNull(root)) {
            return res;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> ilist = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                ilist.add(node.val);
                if (Objects.isNull(node.children)) {
                    continue;
                }

                for (Node cnode : node.children) {
                    q.offer(cnode);
                }
            }
            res.add(ilist);
        }

       return res;
    }
}
// @lc code=end

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            List<List<Integer>> res = new Solution().levelOrder(c.root);
            ResUtils.print2(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        Node n1 = new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)));
        List<List<Integer>> e1 = Arrays.asList(Collections.singletonList(1), Arrays.asList(3, 2, 4), Arrays.asList(5, 6));

        Node n21 = new Node(1);
        Node n22 = new Node(2);
        Node n23 = new Node(3);
        Node n24 = new Node(4);
        Node n25 = new Node(5);
        Node n26 = new Node(6);
        Node n27 = new Node(7);
        Node n28 = new Node(8);
        Node n29 = new Node(9);
        Node n210 = new Node(10);
        Node n211 = new Node(11);
        Node n212 = new Node(12);
        Node n213 = new Node(13);
        Node n214 = new Node(14);
        n21.children = Arrays.asList(n22, n23, n24, n25);
        n23.children = Arrays.asList(n26, n27);
        n24.children = Collections.singletonList(n28);
        n25.children = Arrays.asList(n29, n210);
        n27.children = Collections.singletonList(n211);
        n28.children = Collections.singletonList(n212);
        n29.children = Collections.singletonList(n213);
        n211.children = Collections.singletonList(n214);
        List<List<Integer>> e2 = Arrays.asList(Collections.singletonList(1), Arrays.asList(2, 3, 4, 5),
                                               Arrays.asList(6, 7, 8, 9, 10), Arrays.asList(11, 12, 13), Collections.singletonList(14));

        cases.add(new Case(n1, e1));
        cases.add(new Case(n21, e2));

        return cases;
    }

}

class Case {
    Node root;
    List<List<Integer>> expected;

    public Case(Node root, List<List<Integer>> expected) {
        this.root = root;
        this.expected = expected;
    }

}

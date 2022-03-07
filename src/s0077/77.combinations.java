package s0077;
/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (63.07%)
 * Likes:    3800
 * Dislikes: 126
 * Total Accepted:    488.3K
 * Total Submissions: 774.2K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of the range [1, n].
 * 
 * You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1, k = 1
 * Output: [[1]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 20
 * 1 <= k <= n
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        backtracking(1, n, k, res, new LinkedList<>());

        return res;
    }

    private void backtracking(int si, int n, int k, List<List<Integer>> list, LinkedList<Integer> ilist) {
        if (ilist.size() == k) {
            list.add(new LinkedList<>(ilist));
            return;
        }

        for (int i = si; i <= n - (k - ilist.size()) + 1; i++) {
            ilist.add(si);
            backtracking(++si, n, k, list, ilist);
            ilist.removeLast();
        }
    }

}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            List<List<Integer>> res = new Solution().combine(c.n, c.k);
            ResUtils.print2(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(4, 2, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(1, 4),
                                               Arrays.asList(2, 3), Arrays.asList(2, 4), Arrays.asList(3, 4))));
        cases.add(new Case(1, 1, Collections.singletonList(Collections.singletonList(1))));

        return cases;
    }

}

class Case {
    int n;
    int k;
    List<List<Integer>> expected;

    public Case(int n, int k, List<List<Integer>> expected) {
        this.n = n;
        this.k = k;
        this.expected = expected;
    }
}

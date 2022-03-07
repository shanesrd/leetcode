package s0216;
/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 *
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (63.56%)
 * Likes:    2633
 * Dislikes: 73
 * Total Accepted:    276.7K
 * Total Submissions: 435.3K
 * Testcase Example:  '3\n7'
 *
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 * 
 * 
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * 
 * 
 * Return a list of all possible valid combinations. The list must not contain
 * the same combination twice, and the combinations may be returned in any
 * order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * 
 * Example 2:
 * 
 * 
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations.
 * Using 4 different numbers in the range [1,9], the smallest sum we can get is
 * 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= k <= 9
 * 1 <= n <= 60
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

    private static final int MAX_NUM = 9;

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        backtracking(1, k, n, res, new LinkedList<>());

        return res;
    }

    private void backtracking(int si, int k, int n, List<List<Integer>> res, LinkedList<Integer> ilist) {
        if (ilist.size() == k) {
            if (n == 0) {
                res.add(new LinkedList<>(ilist));
            }
            return;
        } else {
            if (si > n) {
                return;
            }
        }

        for (int i = si; i <= MAX_NUM; i++) {
            if (n < si) {
                break;
            }

            ilist.add(si);
            n = n - si;
            ++si;
            backtracking(si, k, n, res, ilist);
            n = n + ilist.removeLast();
        }
    }

}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            List<List<Integer>> res = new Solution().combinationSum3(c.k, c.n);
            ResUtils.print2(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(3, 7, Collections.singletonList(Arrays.asList(1, 2, 4))));
        cases.add(new Case(3, 9, Arrays.asList(Arrays.asList(1, 2, 6), Arrays.asList(1, 3, 5), Arrays.asList(2, 3, 4))));
        cases.add(new Case(4, 1, Collections.emptyList()));

        return cases;
    }

}

class Case {
    int k;
    int n;
    List<List<Integer>> expected;

    public Case(int k, int n, List<List<Integer>> expected) {
        this.k = k;
        this.n = n;
        this.expected = expected;
    }

}

package s0459;
/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 *
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 *
 * algorithms
 * Easy (43.52%)
 * Likes:    3101
 * Dislikes: 298
 * Total Accepted:    229.2K
 * Total Submissions: 526.8K
 * Testcase Example:  '"abab"'
 *
 * Given a string s, check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aba"
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc"
 * twice.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of lowercase English letters.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int[] next = new int[len];
        next[0] = 0;
        int j = 0;

        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            next[i] = j;
        }

        return (next[len - 1] > 0) && (len % (len - next[len - 1]) == 0);
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            boolean res = new Solution().repeatedSubstringPattern(c.s);
            ResUtils.print(res, c.expecetd);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case("abab", true));
        cases.add(new Case("aba", false));
        cases.add(new Case("abababab", true));
        cases.add(new Case("abcabcabcabc", true));
        cases.add(new Case("abcaabcabcaabcabcaabcabcaabc", true));
        cases.add(new Case("a", false));
        cases.add(new Case("ab", false));
        cases.add(new Case("aa", true));
        cases.add(new Case("aaaa", true));

        return cases;
    }

}

class Case {
    String s;
    boolean expecetd;

    public Case(String s, boolean expecetd) {
        this.s = s;
        this.expecetd = expecetd;
    }

}

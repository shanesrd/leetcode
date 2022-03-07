package s0242;
/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (60.97%)
 * Likes:    4237
 * Dislikes: 200
 * Total Accepted:    1.1M
 * Total Submissions: 1.8M
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 * 
 * 
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you
 * adapt your solution to such a case?
 * 
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sarr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            int idx = sc - 'a';
            sarr[idx] = sarr[idx] + 1;
        }

        for (int i = 0; i < t.length(); i++) {
            char tc = t.charAt(i);
            int idx = tc - 'a';
            if (sarr[idx] < 1) {
                return false;
            }

            sarr[idx] = sarr[idx] - 1;
        }

        return true;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            boolean res = new Solution().isAnagram(c.s, c.t);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case("anagram", "nagaram", true));
        cases.add(new Case("rat", "car", false));
        cases.add(new Case("a", "a", true));
        cases.add(new Case("a", "b", false));

        return cases;
    }

}

class Case {
    String s;
    String t;
    boolean expected;

    public Case(String s, String t, boolean expected) {
        this.s = s;
        this.t = t;
        this.expected = expected;
    }
}

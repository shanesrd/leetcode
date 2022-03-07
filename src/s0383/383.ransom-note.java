package s0383;
/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 *
 * https://leetcode.com/problems/ransom-note/description/
 *
 * algorithms
 * Easy (55.53%)
 * Likes:    1513
 * Dislikes: 287
 * Total Accepted:    344.1K
 * Total Submissions: 619.6K
 * Testcase Example:  '"a"\n"b"'
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * 
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote and magazine consist of lowercase English letters.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            int idx = magazine.charAt(i) - 'a';
            arr[idx]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 'a';
            if (arr[idx] < 1) {
                return false;
            }
            arr[idx]--;
        }

        return true;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            boolean res = new Solution().canConstruct(c.r, c.m);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case("a", "b", false));
        cases.add(new Case("aa", "ab", false));
        cases.add(new Case("aa", "aab", true));

        return cases;
    }

}

class Case {
    String r;
    String m;
    boolean expected;

    public Case(String r, String m, boolean expected) {
        this.r = r;
        this.m = m;
        this.expected = expected;
    }

}

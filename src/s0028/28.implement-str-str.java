package s0028;
/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (35.64%)
 * Likes:    3606
 * Dislikes: 3372
 * Total Accepted:    1.2M
 * Total Submissions: 3.2M
 * Testcase Example:  '"hello"\n"ll"'
 *
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 * 
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Example 3:
 * Input: haystack = "", needle = ""
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= haystack.length, needle.length <= 5 * 10^4
 * haystack and needle consist of only lower-case English characters.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if (0 == needle.length()) {
            return 0;
        }

        // build next_array
        int[] next = new int[needle.length()];

        int j = 0;
        next[0] = 0;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }

            next[i] = j;
        }

        // search str
        j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }

       return -1;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int res = new Solution().strStr(c.h, c.n);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case("hello", "ll", 2));
        cases.add(new Case("aaaaa", "bba", -1));
        cases.add(new Case("", "", 0));

        return cases;
    }

}

class Case {
    String h;
    String n;
    int expected;

    public Case(String h, String n, int expected) {
        this.h = h;
        this.n = n;
        this.expected = expected;
    }
}

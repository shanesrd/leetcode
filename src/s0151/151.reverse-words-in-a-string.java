package s0151;/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (27.87%)
 * Likes:    2821
 * Dislikes: 3772
 * Total Accepted:    667.4K
 * Total Submissions: 2.4M
 * Testcase Example:  '"the sky is blue"'
 *
 * Given an input string s, reverse the order of the words.
 * 
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * 
 * Return a string of the words in reverse order concatenated by a single
 * space.
 * 
 * Note that s may contain leading or trailing spaces or multiple spaces
 * between two words. The returned string should only have a single space
 * separating the words. Do not include any extra spaces.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing
 * spaces.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a
 * single space in the reversed string.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s contains English letters (upper-case and lower-case), digits, and spaces '
 * '.
 * There is at least one word in s.
 * 
 * 
 * 
 * Follow-up: If the string data type is mutable in your language, can you
 * solve it in-place with O(1) extra space?
 * 
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();

        int b = 0;
        int e = 0;
        boolean startWord = false;
        boolean endWord = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (' ' == c) {
                if (startWord) {
                    b = i + 1;
                    endWord = true;
                }
            } else {
                if (!startWord) {
                    e = i;
                    startWord = true;
                }
            }

            if (i == 0 && startWord && !endWord) {
                b = i;
                endWord = true;
            }

            if (startWord && endWord) {
                if (builder.length() > 0) {
                    builder.append(" ");
                }
                builder.append(s, b, e + 1);

                startWord = false;
                endWord = false;
            }
        }

       return builder.toString();
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            String res = new Solution().reverseWords(c.s);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case("the sky is blue", "blue is sky the"));
        cases.add(new Case("  hello world  ", "world hello"));
        cases.add(new Case("a good   example", "example good a"));

        return cases;
    }

}

class Case {
    String s;
    String expected;

    public Case(String s, String expected) {
        this.s = s;
        this.expected = expected;
    }
}

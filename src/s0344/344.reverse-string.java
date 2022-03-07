package s0344;/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 *
 * https://leetcode.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (73.72%)
 * Likes:    3997
 * Dislikes: 896
 * Total Accepted:    1.4M
 * Total Submissions: 1.9M
 * Testcase Example:  '["h","e","l","l","o"]'
 *
 * Write a function that reverses a string. The input string is given as an
 * array of characters s.
 * 
 * You must do this by modifying the input array in-place with O(1) extra
 * memory.
 * 
 * 
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s[i] is a printable ascii character.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length - 1 - i; i++) {
           char temp = s[i];
           s[i] = s[s.length - 1 - i];
           s[s.length - 1 - i] = temp;
        }
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            new Solution().reverseString(c.s);
            ResUtils.print(c.s, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new char[]{'h', 'e', 'l', 'l', 'o'}, new char[]{'o', 'l', 'l', 'e', 'h'}));
        cases.add(new Case(new char[]{'H', 'a', 'n', 'n', 'a', 'h'}, new char[]{'h', 'a', 'n', 'n', 'a', 'H'}));

        return cases;
    }

}

class Case {
    char[] s;
    char[] expected;

    public Case(char[] s, char[] expected) {
        this.s = s;
        this.expected = expected;
    }

}

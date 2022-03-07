package s1047;/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 *
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 *
 * algorithms
 * Easy (71.00%)
 * Likes:    2877
 * Dislikes: 147
 * Total Accepted:    258.9K
 * Total Submissions: 364.7K
 * Testcase Example:  '"abbaca"'
 *
 * You are given a string s consisting of lowercase English letters. A
 * duplicate removal consists of choosing two adjacent and equal letters and
 * removing them.
 * 
 * We repeatedly make duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made. It
 * can be proven that the answer is unique.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation: 
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent
 * and equal, and this is the only possible move.  The result of this move is
 * that the string is "aaca", of which only "aa" is possible, so the final
 * string is "ca".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "azxxzy"
 * Output: "ay"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.ResUtils;

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        int size = stack.size();
        char[] chars = new char[size];
        while (!stack.isEmpty()) {
            chars[--size] = stack.pop();
        }

        return new String(chars);
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            String res = new Solution().removeDuplicates(c.s);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case("abbaca", "ca"));
        cases.add(new Case("azxxzy", "ay"));
        cases.add(new Case("aa", ""));
        cases.add(new Case("aaa", "a"));

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

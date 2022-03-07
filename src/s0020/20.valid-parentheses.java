package s0020;
/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (40.61%)
 * Likes:    11439
 * Dislikes: 498
 * Total Accepted:    2M
 * Total Submissions: 4.9M
 * Testcase Example:  '"()"'
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "(]"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.ResUtils;

/*
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c || '{' == c || '[' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char p = stack.pop();
                if (!((')' == c && '(' == p)
                      || ('}' == c && '{' == p)
                      || (']' == c && '[' == p))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
*/

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('('  == c) {
                stack.push(')');
            } else if ('{' == c) {
                stack.push('}');
            } else if ('[' == c) {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            boolean res = new Solution().isValid(c.s);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case("()", true));
        cases.add(new Case("()[]{}", true));
        cases.add(new Case("(]", false));

        return cases;
    }

}

class Case {
    String s;
    boolean expected;

    public Case(String s, boolean expected) {
        this.s = s;
        this.expected = expected;
    }

}

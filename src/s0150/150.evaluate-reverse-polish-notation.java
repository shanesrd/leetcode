package s0150;/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * algorithms
 * Medium (41.72%)
 * Likes:    2628
 * Dislikes: 598
 * Total Accepted:    373.3K
 * Total Submissions: 894.9K
 * Testcase Example:  '["2","1","+","3","*"]'
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, and /. Each operand may be an integer or
 * another expression.
 * 
 * Note that division between two integers should truncate toward zero.
 * 
 * It is guaranteed that the given RPN expression is always valid. That means
 * the expression would always evaluate to a result, and there will not be any
 * division by zero operation.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= tokens.length <= 10^4
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the
 * range [-200, 200].
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> d = new LinkedList<>();
        for (String t : tokens) {
            if ("+".equals(t) || "-".equals(t) || "*".equals(t) || "/".equals(t)) {
                int calRes = cal(d.pop(), d.pop(), t);
                d.push(calRes);
            } else {
                d.push(Integer.valueOf(t));
            }
        }

        return d.pop();
    }

    private int cal(int o1, int o2, String op) {
        if ("+".equals(op)) {
            return o2 + o1;
        } else if ("-".equals(op)) {
            return o2 - o1;
        } else if ("*".equals(op)) {
            return o2 * o1;
        } else if ("/".equals(op)) {
            return o2 / o1;
        }

        return 0;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int res = new Solution().evalRPN(c.tokens);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new String[]{"2", "1", "+", "3", "*"}, 9));
        cases.add(new Case(new String[]{"4", "13", "5", "/", "+"},  6));
        cases.add(new Case(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"},  22));

        return cases;
    }

}

class Case {
    String[] tokens;
    int expected;

    public Case(String[] tokens, int expected) {
        this.tokens = tokens;
        this.expected = expected;
    }

}

package s0017;
/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (53.12%)
 * Likes:    9155
 * Dislikes: 639
 * Total Accepted:    1.1M
 * Total Submissions: 2.1M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in
 * any order.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: digits = ""
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import util.ResUtils;

// @lc code=start
class Solution {
    private static final Map<Character, List<Character>> numChars = new HashMap<>();

    static {
        numChars.put('2', Arrays.asList('a', 'b', 'c'));
        numChars.put('3', Arrays.asList('d', 'e', 'f'));
        numChars.put('4', Arrays.asList('g', 'h', 'i'));
        numChars.put('5', Arrays.asList('j', 'k', 'l'));
        numChars.put('6', Arrays.asList('m', 'n', 'o'));
        numChars.put('7', Arrays.asList('p', 'q', 'r', 's'));
        numChars.put('8', Arrays.asList('t', 'u', 'v'));
        numChars.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (Objects.isNull(digits) || digits.length() == 0) {
            return res;
        }

        backtracking(0,  digits, res, new LinkedList<>());

        return res;
    }

    private void backtracking(int si, String digits, List<String> res, LinkedList<Character> ilist) {
        if (ilist.size() == digits.length()) {
            res.add(ilist.stream().map(String::valueOf).collect(Collectors.joining()));
            return;
        }

        for (int i = si; i <= digits.length() - 1; i++) {
            char c = digits.charAt(i);
            List<Character> cs = numChars.get(c);
            ++si;
            for (Character character : cs) {
                ilist.add(character);
                backtracking(si, digits, res, ilist);
                ilist.removeLast();
            }
        }
    }

}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            List<String> res = new Solution().letterCombinations(c.digits);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case("23", Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")));
        cases.add(new Case("", Collections.emptyList()));
        cases.add(new Case("2", Arrays.asList("a", "b", "c")));

        return cases;
    }

}

class Case {
    String digits;
    List<String> expected;

    public Case(String digits, List<String> expected) {
        this.digits = digits;
        this.expected = expected;
    }

}


package s0541;/*
 * @lc app=leetcode id=541 lang=java
 *
 * [541] Reverse String II
 *
 * https://leetcode.com/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (50.02%)
 * Likes:    870
 * Dislikes: 2223
 * Total Accepted:    142.8K
 * Total Submissions: 285.5K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * Given a string s and an integer k, reverse the first k characters for every
 * 2k characters counting from the start of the string.
 * 
 * If there are fewer than k characters left, reverse all of them. If there are
 * less than 2k but greater than or equal to k characters, then reverse the
 * first k characters and leave the other as original.
 * 
 * 
 * Example 1:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Example 2:
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of only lowercase English letters.
 * 1 <= k <= 10^4
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

import util.ResUtils;

/*
class Solution {
    public String reverseStr(String s, int k) {
        char[] sc = s.toCharArray();
        int len = s.length();
        int r = 0;

        while (true) {
            int b = r * 2 * k;
            if (b >= len) {
                break;
            }

            int e = (r * 2 + 1) * k - 1;
            e = e >= len ? len - 1 : e;

            while (b < e) {
                char temp = sc[b];
                sc[b] = sc[e];
                sc[e] = temp;
                b++;
                e--;
            }

            r++;
        }

        return new String(sc);
    }
}
*/

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] sc = s.toCharArray();
        int len = s.length();

        for (int i = 0; i < len; i = i + 2 * k) {
            int b = i;
            int e = Math.min(i + k - 1, len - 1);

            while (b < e) {
                char temp = sc[b];
                sc[b] = sc[e];
                sc[e] = temp;
                b++;
                e--;
            }
        }

        return new String(sc);
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            String res = new Solution().reverseStr(c.s, c.k);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case("abcdefg", 2, "bacdfeg"));
        cases.add(new Case("abcd", 2, "bacd"));
        cases.add(new Case("a", 2, "a"));

        return cases;
    }

}

class Case {
    String s;
    int k;
    String expected;

    public Case(String s, int k, String expected) {
        this.s = s;
        this.k = k;
        this.expected = expected;
    }

}

package s0076;
/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (38.34%)
 * Likes:    9080
 * Dislikes: 510
 * Total Accepted:    679.6K
 * Total Submissions: 1.8M
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given two strings s and t of lengths m and n respectively, return the
 * minimum window substring of s such that every character in t (including
 * duplicates) is included in the window. If there is no such substring, return
 * the empty string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
 * from string t.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s and t consist of uppercase and lowercase English letters.
 * 
 * 
 * 
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */

import java.util.ArrayList;
import java.util.List;

import util.FileUtils;
import util.ResUtils;

/*
class Solution {

    public String minWindow(String s, String t) {
        int[] resIdx = new int[]{0, 0};

        int[] idx = new int[]{0, 0};
        int cc = 0;
        Map<Character, Integer> map = charCntMap(t);
        Map<Character, Integer> ccmap = new HashMap<>();

        while (idx[1] < s.length()) {
            Character c = s.charAt(idx[1]++);
            Integer cnt = map.get(c);
            if (Objects.nonNull(cnt)) {
                Integer ccnt = ccmap.getOrDefault(c, 0);
                ccmap.put(c, ccnt + 1);
                if (ccnt + 1 == cnt) {
                    cc++;
                }
            }

            while (cc == map.size()) {
                if (idx[1] - idx[0] < resIdx[1] - resIdx[0] || resIdx[1] == 0) {
                    resIdx[0] = idx[0];
                    resIdx[1] = idx[1];
                }

                c = s.charAt(idx[0]++);
                cnt = map.get(c);
                if (Objects.nonNull(cnt)) {
                    Integer ccnt = ccmap.get(c);
                    ccmap.put(c, ccnt - 1);
                    if (ccnt - 1 < cnt) {
                        cc--;
                    }
                }
            }
        }

        return resIdx[1] > 0 ? s.substring(resIdx[0], resIdx[1]) : "";
    }

    private static Map<Character, Integer> charCntMap(String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

}
*/

// @lc code=start
class Solution {

    public String minWindow(String s, String t) {
        int[] resIdx = new int[]{0, 0};

        int[] idx = new int[]{0, 0};
        int tt = 0;
        int cc = 0;
        int[] arr = new int[100];
        int[] ccarr = new int[100];

        for (int i = 0; i < t.length(); i++) {
            int ii = t.charAt(i) - 65;
            arr[ii]++;
            if (arr[ii] == 1) {
                tt++;
            }
        }

        while (idx[1] < s.length()) {
            int c = s.charAt(idx[1]++) - 65;
            if (++ccarr[c] == arr[c]) {
                cc++;
            }

            while (cc == tt) {
                if (idx[1] - idx[0] < resIdx[1] - resIdx[0] || resIdx[1] == 0) {
                    resIdx[0] = idx[0];
                    resIdx[1] = idx[1];
                }

                c = s.charAt(idx[0]++) - 65;
                if (--ccarr[c] < arr[c]) {
                    cc--;
                }
            }
        }

        return resIdx[1] > 0 ? s.substring(resIdx[0], resIdx[1]) : "";
    }

}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            String res = new Solution().minWindow(c.src, c.search);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case("ADOBECODEBANC", "ABC", "BANC"));
        cases.add(new Case("a", "a", "a"));
        cases.add(new Case("a", "aa", ""));
        cases.add(new Case("ab", "ab", "ab"));
        cases.add(new Case("abcccabac", "aab", "aba"));

        List<String> lines = FileUtils.readlines("/input/s0076_input");
        cases.add(new Case(lines.get(0), lines.get(1), lines.get(2)));

        return cases;
    }

}

class Case {
    String src;
    String search;
    String expected;

    public Case(String src, String search, String expected) {
        this.src = src;
        this.search = search;
        this.expected = expected;
    }

}

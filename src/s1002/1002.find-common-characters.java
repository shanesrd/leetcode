package s1002;
/*
 * @lc app=leetcode id=1002 lang=java
 *
 * [1002] Find Common Characters
 *
 * https://leetcode.com/problems/find-common-characters/description/
 *
 * algorithms
 * Easy (68.41%)
 * Likes:    2128
 * Dislikes: 178
 * Total Accepted:    135.7K
 * Total Submissions: 198.3K
 * Testcase Example:  '["bella","label","roller"]'
 *
 * Given a string array words, return an array of all characters that show up
 * in all strings within the words (including duplicates). You may return the
 * answer in any order.
 * 
 * 
 * Example 1:
 * Input: words = ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 * Input: words = ["cool","lock","cook"]
 * Output: ["c","o"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of lowercase English letters.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.ResUtils;

// @lc code=start
class Solution {
    public List<String> commonChars(String[] words) {
        int[] arr= new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 100;
        }

        for (String w : words) {
            int[] iarr = new int[26];
            for (int i = 0; i < w.length(); i++) {
                int idx =  w.charAt(i) - 'a';
                iarr[idx] = iarr[idx] + 1;
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] =  Math.min(arr[i], iarr[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                res.add(String.valueOf((char)(i + (int)'a')));
            }
        }

        return res;
    }
}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            List<String> res = new Solution().commonChars(c.words);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new String[]{"bella","label","roller"}, Arrays.asList("e", "l", "l")));
        cases.add(new Case(new String[]{"cool","lock","cook"}, Arrays.asList("c","o")));

        return cases;
    }

}

class Case {
    String[] words;
    List<String> expected;

    public Case(String[] words, List<String> expected) {
        this.words = words;
        this.expected = expected;
    }

}

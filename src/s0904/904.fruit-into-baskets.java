package s0904;
/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 *
 * https://leetcode.com/problems/fruit-into-baskets/description/
 *
 * algorithms
 * Medium (43.02%)
 * Likes:    631
 * Dislikes: 37
 * Total Accepted:    176.6K
 * Total Submissions: 410.4K
 * Testcase Example:  '[1,2,1]'
 *
 * You are visiting a farm that has a single row of fruit trees arranged from
 * left to right. The trees are represented by an integer array fruits where
 * fruits[i] is the type of fruit the i^th tree produces.
 * 
 * You want to collect as much fruit as possible. However, the owner has some
 * strict rules that you must follow:
 * 
 * 
 * You only have two baskets, and each basket can only hold a single type of
 * fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from
 * every tree (including the start tree) while moving to the right. The picked
 * fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must
 * stop.
 * 
 * 
 * Given the integer array fruits, return the maximum number of fruits you can
 * pick.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees
 * [1,2].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= fruits.length <= 10^5
 * 0 <= fruits[i] < fruits.length
 * 
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.ResUtils;

/*
class Solution {
    public int totalFruit(int[] fruits) {
        int res = 1;

        int lidx = 0;
        int ridx = 1;
        int[] picked = new int[]{fruits[lidx], -1};

        for (; ridx < fruits.length; ridx++) {
            int val = fruits[ridx];

            if (picked[0] != val && picked[1] != val) {
                if (picked[1] == -1) {
                    picked[1] = val;
                    res = res >= 2 ? res + 1 : 2;
                    continue;
                }

                int[] temp = new int[3];
                int cnt = 3;
                while (cnt > 2) {
                    Arrays.fill(temp, -1);
                    lidx++;
                    cnt = 0;
                    for (int i = lidx; i <= ridx; i++) {
                        if (cnt > 2) {
                            break;
                        }

                        for (int j = 0; j < temp.length; j++) {
                            if (temp[j] == fruits[i]) {
                                break;
                            }

                            if (temp[j] == -1) {
                                temp[j] = fruits[i];
                                cnt = j + 1;
                                break;
                            }
                        }
                    }
                }

                picked[0] = temp[0];
                picked[1] = temp[1];
            }

            int len = ridx - lidx + 1;
            res = len > res ? len : res;
        }

        return res;
    }
}
*/

// @lc code=start
class Solution {

    public int totalFruit(int[] fruits) {
        int res = 1;

        int lidx = 0;
        int ridx = 1;
        Map<Integer, Integer> picked = new HashMap<>();

        putDelta(picked, fruits[lidx], 1);
        for (; ridx < fruits.length; ridx++) {
            int val = fruits[ridx];

            putDelta(picked, val, 1);

            while (picked.size() > 2) {
                int delVal = fruits[lidx++];
                int delCnt = putDelta(picked, delVal, -1);
                if (0 == delCnt) {
                    picked.remove(delVal);
                }
            }

            int len = ridx - lidx + 1;
            res = res < len ? len : res;
        }

        return res;
    }

    private static int putDelta(Map<Integer, Integer> map, Integer key, Integer delta) {
        Integer val = map.getOrDefault(key, 0) + delta;
        map.put(key, val);

        return val;
    }

}
// @lc code=end

class Main {

    public static void main(String[] args) {
        cases().forEach(c -> {
            int res = new Solution().totalFruit(c.nums);
            ResUtils.print(res, c.expected);
        });
    }

    private static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

        cases.add(new Case(new int[]{1, 2, 1}, 3));
        cases.add(new Case(new int[]{0, 1, 2, 2}, 3));
        cases.add(new Case(new int[]{1, 2, 3, 2, 2}, 4));
        cases.add(new Case(new int[]{1}, 1));
        cases.add(new Case(new int[]{1, 1}, 2));
        cases.add(new Case(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}, 5));
        cases.add(new Case(new int[]{1, 0}, 2));
        cases.add(new Case(new int[]{3, 3, 3, 1, 4}, 4));

        return cases;
    }

}

class Case {
    int[] nums;
    int expected;

    public Case(int[] nums, int expected) {
        this.nums = nums;
        this.expected = expected;
    }

}

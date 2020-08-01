/**
* LeetCode 169.多数元素
* 为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
*
* 以假设数组是非空的，并且给定的数组总是存在多数元素。
*/

/*
  Boyer-Moore算法（多数投票算法）
*/

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            count += (candidate == num) ? 1 : -1;

        }

        return candidate;
    }
}

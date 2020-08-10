/**
* 3.无重复字符的最长子串
*
* 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
*
*		示例 1:
*
*		输入: "abcabcbb"
*		输出: 3 
*		解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
*		示例 2:
*
*		输入: "bbbbb"
*		输出: 1
*		解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
*		示例 3:
*
*		输入: "pwwkew"
*		输出: 3
*		解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
* 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。。
*/


//解题思路：

//指定左右双指针i，r。并维护一个HashSet，根据元素不可重复的特性，当右指针指向的元素不在set中，则将其加入到集合中，
//若出现重复元素，则把集合中的删除，枚举出每次从左指针到右指针的长度，找处最大值即为无重复子串的最大长度。

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hashset = new HashSet<>();
        int n = s.length();
        int r = -1; //右指针
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                hashset.remove(s.charAt(i-1));
            }

            while (r + 1 < n && !hashset.contains(s.charAt(r+1))) {
                hashset.add(s.charAt(r+1));
                r++;
            }
            ans = Math.max(ans, r - i + 1);
        }

        return ans;
    }
}

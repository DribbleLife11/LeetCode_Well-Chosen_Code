//核心思路：翻转一半的数字，跟另一半作比较。

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reversedNumber = 0;
        while (x > reversedNumber) {
            reversedNumber = reversedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == reversedNumber || x == reversedNumber / 10;
        
    }
}

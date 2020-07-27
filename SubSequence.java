//双指针解法：
public class SubSequence {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0,j = 0;
        while (i < n&& j <m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == n;
    }
}

//此题还可用动态规划：

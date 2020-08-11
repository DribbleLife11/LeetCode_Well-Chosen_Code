public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            num++;
            //n与n-1按位与消除低位1
            n = n & (n - 1);
        }
        return num;
    }
}

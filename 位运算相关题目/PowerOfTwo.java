/**
* 如果是2的幂那么二进制位中只有一个1
* 1.x按位与x-1会消除低位1，如果消除后位0则为2的幂
* 2.x按位与-x（-x=~x+1）
*   通过 x & (-x) 保留了最右边的 1，并将其他位设置为 0 若 x 为 2 的幂，则它的二进制表示中只包含一个 1，则有 x & (-x) = x。
*
*   若 x 不是 2 的幂，则在二进制表示中存在其他 1，因此 x & (-x) != x。
*/
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
       
        return (x & (x-1)) == 0;
        //return (x & (-x)) == x; 
  }
}

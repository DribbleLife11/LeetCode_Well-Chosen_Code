/**
* 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
*
* 给出两个整数 x 和 y，计算它们之间的汉明距离。
*/

//力扣官方题解
public class HammingDistance {
    public int hammingDistance(int x, int y) {
    //一般会转换成位计数的问题，位计数有多种思路：

        //1、内置计数功能
        //Java中的bitCount()方法。
        return Integer.bitCount(x^y);

        //2、移位
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
          if (xor % 2 == 1)
          distance += 1;
          xor = xor >> 1;
        }
        return distance;
    
        //3、布莱恩·克尼根算法
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            xor = xor & (xor - 1);
        }
        return distance;
    }
}

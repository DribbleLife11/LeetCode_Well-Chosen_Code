/**
* 力扣338.比特位计数
* 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
* 
* 示例：
*   输入：2
*   输出：[0,1,1]
*/


public class CountBits {
    //1.暴力解法！
    //时间复杂度O(n*m)
    //空间复杂度O(n)
    public int[] countBits(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            //把区间的每一个数转化为二进制字符串
            String binaryString = Integer.toBinaryString(i);
            int count = 0;
            
            //统计1的数量
            for (int j = 0; j < binaryString.length(); j++) {
                if (binaryString.charAt(j) == '1') {
                    count++;
                }
            }
            list.add(count);
        }
        //将ArrayList转化为int数组
        int[] res = new int[list.size()];
        res = list.stream().mapToInt(Integer::valueOf).toArray();

        return res;
    }
}

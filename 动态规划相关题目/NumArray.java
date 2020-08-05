/** 
*
* 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
* 
* 示例：
*   给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
*   sumRange(0, 2) -> 1
*   sumRange(2, 5) -> -1
*   sumRange(0, 5) -> -3
*/

//1、暴力解法
class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        for (int m = i; m <= j; m++) {
            sum += nums[m];
        }
        return sum;
    }
}

//2、缓存
//   将所有区间的和存入到一个一维数组sum中，这样求i，j区间的和就变成了sum[j+1]-sum[i]  
class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i , int j) {
        return sum[j + 1] - sum[i];
    }
}

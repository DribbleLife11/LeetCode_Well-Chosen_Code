class Solution {
    //解法一：斐波那契通向式 
    //时间复杂度O(logn)
    //空间复杂度O(1)
    public int climbStairs(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt_5) / 2, n+1) - Math.pow((1 - sqrt_5) /2, n+1);
        return (int) (fibn / sqrt_5);
    }
    
    //解法二：动态规划
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public int climbStairs(int n) {
      int[] dp = new int[n+1];
      dp[0] = 1;
      dp[1] = 1;
      for (int i = 2; i < n; i++) {
        dp[i] = dp[i-1] + dp[i+1];
      }
      
      return dp[n];
      
      //滚动数组
      //时间复杂度：O(n)
      //空间复杂度：O(1)
      int p , q, r;
      for (int i = 1 ; i <= n; i ++) {
         p = q;
         q = r;
         r = p + q;
      }
      return r;
    }
    
    //解法三：矩阵快速幂
    
}

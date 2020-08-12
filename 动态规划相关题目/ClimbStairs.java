class Solution {
    public int climbStairs(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt_5) / 2, n+1) - Math.pow((1 - sqrt_5) /2, n+1);
        return (int) (fibn / sqrt_5);
    }
}

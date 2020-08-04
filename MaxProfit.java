/**
* 买股票的最佳实际Ⅱ
*
* 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
*
* 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
*
* 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
*
* 这道题“贪心”的地方在于，对于“今天的股价-昨天的股价”有三种情况：（1）正数（2）0（3）负数
*
* 那么这道题的贪心算法的决策是：只加正数
*/
class solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {		//贪心
                maxprofit += diff;
            }
        }

        return maxprofit;
    }
}

//不同的写法（简化了一点）：

class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxprofit += Math.max(prices[i] - prices[i-1], 0);
        }
        return maxprofit;
    }
}

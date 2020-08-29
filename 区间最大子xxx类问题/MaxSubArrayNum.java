/**
* 最大子序和
* 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
*
* 示例:
*
* 输入: [-2,1,-3,4,-1,2,1,-5,4]
* 输出: 6
* 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
*/



public class MaxSubArraySum {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int pre = 0;
        int len = nums.length;
        
        //方法一：动态规划
        //状态方程：f(i) = max(f(i-1) + ai), ai),即以第i个数结尾的最大和是以第i-1个数结尾的最大和加上当前数与当前数中较大的。
        for (int i = 0; i < len; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxSum = Math.max(maxSum, pre);
        }

        return maxSum;
    }
    
    
    
}

//方法二：分治法
//可以用于解决任何[l,r]子区间的问题。当把每个区间的答案组合成一颗树后，可以在O(logn)的时间复杂度下找到任意区间的答案。
public class Solution {
    public class Status {
        public int lSum, rSum, mSum, iSum;
        public Status(int lSum_, int rSum_, int mSum_, int iSum_) {
            lSum = lSum_; rSum = rSum_; mSum = mSum_; iSum = iSum_;
        }
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.Max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.Max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.Max(Math.Max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) return new Status(a[l], a[l], a[l], a[l]);
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public int MaxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.Length - 1).mSum;
    }
}

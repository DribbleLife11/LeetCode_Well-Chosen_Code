class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] states = new int[nums.length];
        states[0] = nums[0];
        states[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            states[i] = Math.max(states[i-1],states[i-2] + nums[i]);
        }
        return states[nums.length - 1];
        
    }
}

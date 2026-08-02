class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int num:nums) total+=num;

        int[]dp = new int[2*total+1];
        dp[total]=1;
        for(int num: nums)
        {
            int[] next = new int[2*total+1];
            for(int s=0;s<=2*total;s++)
            {
                if(dp[s]>0)
                {
                    next[s + num] += dp[s];
                    next[s - num] += dp[s];
                }
            }
            dp=next; 
        }
        if (target < -total || target > total) return 0;
        return dp[total + target];
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length*(nums.length+1)/2;
        for(int i=0;i<nums.length;i++){
            res-=nums[i];
        }
        return res;
    }
}

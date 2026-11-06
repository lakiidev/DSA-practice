class Solution {
    public int subsetXORSum(int[] nums) {
        int bitwiseOr = 0;

        for(int num:nums)
        {
            bitwiseOr |= num;
        }

        return bitwiseOr * (1 << (nums.length - 1));
    }
}
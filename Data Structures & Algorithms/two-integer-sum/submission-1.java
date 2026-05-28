class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visited = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int missing = target-nums[i];
            if(visited.containsKey(missing))
            {
               return new int[]{visited.get(missing), i};
            }
            visited.put(nums[i],i);
        }
        return new int[2];
    }
}

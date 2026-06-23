class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums,int target,int index,int sum,List<Integer> path, List<List<Integer>> result)
    {
        if(sum==target)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        if(sum>target || index==nums.length)
        {
            return;
        }

        path.add(nums[index]);
        backtrack(nums,target,index,sum+nums[index],path,result);
        path.remove(path.size()-1);
        backtrack(nums,target,index+1,sum,path,result);
    }
}

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,0,new ArrayList<>(),result);
        return result;
    }

    private void backtrack(int[] nums, int target, int index,int sum,List<Integer> path,List<List<Integer>> result)
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

        for(int i=index;i<nums.length;i++)
        {
            if (i > index && nums[i] == nums[i - 1]) continue;
            if(sum+nums[i]>target) break;
            path.add(nums[i]);
            backtrack(nums, target, i + 1, sum + nums[i], path, result);
            path.remove(path.size() - 1);
        }
    }
}

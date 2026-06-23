class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums,int index,List<Integer> path, List<List<Integer>> result)
    {
        if(index==nums.length)
        {
            result.add(new ArrayList <>(path));
            return;
        }

        path.add(nums[index]);
        backtrack(nums, index + 1, path, result);
        path.remove(path.size() - 1);

        backtrack(nums, index + 1, path, result);
    }
}

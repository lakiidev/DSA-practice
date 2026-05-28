class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for(int n : nums)
        {
            if(!visited .add(n)) return true;
        }
        return false;
    }
}
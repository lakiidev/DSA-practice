class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums)
        {
            set.add(i);
        }
        int longest=0;
        for (int n:set)
        {
            if(set.contains(n-1)) continue;
            int len = 1;
            while(set.contains(n+len)) len++;
            longest=Math.max(longest, len);
        }
        return longest;
    }
}

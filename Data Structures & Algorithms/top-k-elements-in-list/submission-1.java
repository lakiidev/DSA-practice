class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums)
        {
            count.put(n,count.getOrDefault(n,0)+1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int n: count.keySet())
        {
            int freq = count.get(n);
            if(buckets[freq]==null)
            {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(n);
        }

        int[] result = new int[k];
        int idx = 0;
        for(int freq=nums.length; freq>=0 && idx<k; freq--)
        {
            if (buckets[freq] == null) continue;
            for(int n: buckets[freq])
            {
                 result[idx++] = n;
                 if(idx==k) return result;
            }
        }
        return result;
    }
}

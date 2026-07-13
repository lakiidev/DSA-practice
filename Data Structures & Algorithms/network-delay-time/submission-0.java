class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> adj = new HashMap<>();
        for(int i=1;i<=n;i++) adj.put(i,new ArrayList<>());
        for(int[] time:times)
        {
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{k, 0}); 

        while(!minHeap.isEmpty())
        {
            int curr[] = minHeap.poll();
            int node = curr[0];
            int distance = curr[1];
            if(distance>dist[node]) continue;
            for(int[] neighbor:adj.get(node))
            {
                int next = neighbor[0];
                int weight = neighbor[1];
                if(dist[node]+weight<dist[next])
                {
                    dist[next] = dist[node]+weight;
                    minHeap.offer(new int[]{next,dist[next]});
                }
            }
        }

        int maxDist=0;
        for (int i=1;i<=n;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)
            {
                return -1;
            }
            maxDist = Math.max(maxDist,dist[i]);
        }

        return maxDist;

    }
}

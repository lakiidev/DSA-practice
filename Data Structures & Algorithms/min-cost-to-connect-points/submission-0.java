class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;

        List<int[]> edges= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int cost = Math.abs(points[i][0] - points[j][0]) + 
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{cost,i,j});
            }
            
        }

        edges.sort((a,b)->a[0]-b[0]);
        int [] parent = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        int totalCost=0;
        int edgesUsed=0;
        for(int[]edge:edges)
        {
            int cost=edge[0];
            int i=edge[1];
            int j=edge[2];

            int rootI=find(parent,i);
            int rootJ=find(parent,j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;  
                totalCost += cost;
                edgesUsed++;
                if (edgesUsed == n - 1) break;  
            }

        }
        return totalCost;
    }
    private int find(int[] parent, int x)
    {
        if(parent[x]!=x)
        {
            parent[x]=find(parent,parent[x]);
        }
        return parent[x];
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        for(int i=0;i<n;i++) parent[i]=i;
        for(int[] edge:edges)
        {
            int rootA = find(parent,edge[0]);
            int rootB = find(parent,edge[1]);
            if (rootA == rootB) return edge;
            parent[rootA]=parent[rootB];
        }

        return new int[]{};
    }
    
    private int find(int[] parent,int x)
    {
        if(parent[x]!=x)
        {
            parent[x] = find(parent,parent[x]);

        }
        return parent[x];
    }
}

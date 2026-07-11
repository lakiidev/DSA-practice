class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int components = n;
        for(int i=0;i<n;i++) parent[i]=i;

        for(int[] edge:edges)
        {
            int rootA = find(parent,edge[0]);
            int rootB= find(parent,edge[1]);
            if(rootA!=rootB)
            {
                parent[rootA]=parent[rootB];
                components--;
            }
        }
        return components;
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

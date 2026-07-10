class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean visited[] = new boolean[n];
        if(hasCycle(0,-1,adj,visited)) return false;

        for(boolean isVisited: visited) if(!isVisited) return false;

        return true;
    }

    private boolean hasCycle(int node, int parent, List<List<Integer>> adj,boolean[] visited)
    {
        visited[node]=true;
        for(int neighbor: adj.get(node))
        {
            if(!visited[neighbor])
            {
                if(hasCycle(neighbor,node,adj,visited)) return true;
            }
            else if(neighbor!=parent)
            {
                return true;
            }
        }
        return false;
    }
}

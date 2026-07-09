class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        int state[] = new int[numCourses];

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(i, adj, state, result)) {
                return new int[]{}; 
            }
        }

        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }


    private boolean hasCycle(int node, List<List<Integer>> adj, int[] state, List<Integer> result)
    {
        state[node]=1;
        for(int neighbor: adj.get(node))
        {
            if (state[neighbor] == 1) return true; 
            if (state[neighbor] == 0) {
                if (hasCycle(neighbor, adj, state, result)) return true;
            }
        }

        state[node] = 2;
        result.add(node);
        return false;
    }
}

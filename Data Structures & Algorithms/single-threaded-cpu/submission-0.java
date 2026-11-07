class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> tasks[a][0] - tasks[b][0]);

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
    
        int[] result = new int[n];
        long time=0;
        int i=0;
        int k=0;
        while(k<n)
        {
            if(heap.isEmpty() && time<tasks[order[i]][0])
            {
                time = tasks[order[i]][0];
            }
            while(i < n && tasks[order[i]][0]<=time)
                {
                                        heap.offer(new int[]{tasks[order[i]][1], order[i]});
                    i++;
                }
                int[] next = heap.poll();
                time+=next[0];
                result[k++]=next[1];
        }
        return result;
    }
}
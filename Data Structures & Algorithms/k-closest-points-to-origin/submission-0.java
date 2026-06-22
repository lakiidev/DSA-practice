class Solution {
    public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for(int[] point:points)
        {
            int x=point[0];
            int y=point[1];
            int distanceSquared = x*x+y*y;
            maxHeap.offer(new int[]{x,y,distanceSquared});
            if(maxHeap.size()>k)
            {
                maxHeap.poll();
            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = maxHeap.poll();
            result[i][0] = point[0];
            result[i][1] = point[1];
        }
        return result;
    }
}

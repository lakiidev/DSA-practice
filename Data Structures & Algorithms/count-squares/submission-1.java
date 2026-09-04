class CountSquares {
    Map<String, Integer> pointCount = new HashMap<>();
    List<int[]> points = new ArrayList<>();
    public CountSquares() {
         
    }
    
    public void add(int[] point) {
        String key = point[0]+","+point[1];
        pointCount.merge(key, 1, Integer::sum);
        points.add(point);

    }
    
    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int result=0;
        for (int[] p : points) {
            int x = p[0];
            int y = p[1];
        
            if (Math.abs(py - y) != Math.abs(px - x) || x == px || y == py) continue;
            result += pointCount.getOrDefault(px + "," + y, 0)
                    * pointCount.getOrDefault(x + "," + py, 0);
        }
        return result;
    }
}

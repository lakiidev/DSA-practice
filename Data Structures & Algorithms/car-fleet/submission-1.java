class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<position.length;i++)
        {
            map.put(position[i], speed[i]);
        }
        Stack<Double> stack = new Stack<>();
        int fleet = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            double time = (double)(target-entry.getKey())/entry.getValue();
            if(!stack.isEmpty() && time<=stack.peek()) continue;
            stack.push(time);
        }
        return stack.size();
    }
}

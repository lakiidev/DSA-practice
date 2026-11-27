class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        
        if (visited.contains("0000")) return -1;
        if (target.equals("0000")) return 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        visited.add("0000");
        
        int turns = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            turns++;

            for(int i=0;i<size;i++)
            {
                String curr = queue.poll();
                
                for(String next: neighbors(curr)){
                    if(next.equals(target)) return turns;
                    if(visited.add(next)) queue.offer(next);
                }
            }
        }
        return -1;
    }

    private List<String> neighbors(String code) {
        List<String> result = new ArrayList<>();

        char[] chars = code.toCharArray();

        for(int i=0; i<4;i++)
        {
            char orig = chars[i];
            chars[i] = (char) ((orig - '0' + 1) % 10 + '0'); 
            result.add(new String(chars));

            chars[i]= (char) ((orig - '0' + 9) % 10 + '0'); 
            result.add(new String(chars));

            chars[i] =orig;
        }
        return result;
    }

}
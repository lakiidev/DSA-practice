class MyQueue {

    private Deque<Integer> in = new ArrayDeque<>();
        private Deque<Integer> out = new ArrayDeque<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        shift();
        return out.pop();
    }
    
    public int peek() {
        shift();
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void shift()
    {
        if(out.isEmpty())
        {
            while(!in.isEmpty()) out.push(in.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
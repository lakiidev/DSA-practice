class MyHashSet {
    private static final int SIZE=1000;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for(int i=0;i<SIZE;i++) buckets[i] = new LinkedList<>();
    }
    
    private int hash(int key)
    {
        return key%SIZE;
    }

    public void add(int key) {
        int h =hash(key);
        if(!buckets[h].contains(key)) buckets[h].add(key);
    }
    
    public void remove(int key) {
        buckets[hash(key)].remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return buckets[hash(key)].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
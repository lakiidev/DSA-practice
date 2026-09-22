class MyHashMap {
    private static final int SIZE = 1000;
    private LinkedList<int[]>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i=0; i < SIZE;i++) buckets[i] = new LinkedList<>();
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int h = hash(key);
        for (int[] pair : buckets[h]) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
        buckets[h].add(new int[]{key,value});
    }

    public int get(int key) {
        for(int[] pair: buckets[hash(key)])
        {
            if(pair[0]==key) return pair[1];
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        buckets[h].removeIf(pair -> pair[0]==key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
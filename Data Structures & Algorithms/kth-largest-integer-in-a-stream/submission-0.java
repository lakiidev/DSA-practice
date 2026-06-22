class KthLargest {
    private int[] heap;
    private int size;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.heap = new int[k];
        this.size = 0;
        for(int num:nums)
        {
            add(num);
        }
    }
    
    public int add(int val) {
        if(size<k)
        {
            heap[size]=val;
            heapifyUp(size);
            size++;
        }
        else if(val>heap[0])
        {
            heap[0]=val;
            heapifyDown(0);
        }
        return heap[0];
    }

    private void heapifyUp(int i)
    {
        while(i>0)
        {
            int parent = (i-1)/2;
            if(heap[i]>=heap[parent]) break;
            swap(i,parent);
            i = parent;
        }
    }

    private void heapifyDown(int i)
    {
        while(true)
        {
            int left = 2*i+1;
            int right = 2*i+2;
            int smallest = i;
            if(left<size && heap[left]<heap[smallest])
            {
                smallest = left;
            }
            if(right<size && heap[right]<heap[smallest])
            {
                smallest = right;
            }
            if(smallest==i) break;
            swap(i,smallest);
            i=smallest;
        }
    }

    private void swap(int i, int j)
    {
        heap[i] = heap[i]^heap[j];
        heap[j] = heap[i]^heap[j];
        heap[i] = heap[i]^heap[j];
    }
}

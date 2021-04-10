class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    public MedianFinder() {
        pq1=new PriorityQueue<>(Collections.reverseOrder());
        pq2=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
       int maxSize=pq1.size();
       int minSize=pq2.size();
       
       pq1.add(num);
       pq2.add(pq1.poll());
       if(pq2.size()>pq1.size())
           pq1.add(pq2.poll());
       
    }
    
    public double findMedian() {
        int size1=pq1.size();
        int size2=pq2.size();
        if(size1==size2)
            return (double)(pq1.peek()+pq2.peek())/2.0;
        
        return (double)pq1.peek();
       
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
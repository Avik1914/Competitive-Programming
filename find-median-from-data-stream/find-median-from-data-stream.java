class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    public MedianFinder() {
        pq1=new PriorityQueue<>(Collections.reverseOrder());
        pq2=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        pq2.add(num);
        if(pq2.size()-pq1.size()>0)
            pq1.add(pq2.poll());
        else{
            if(!pq1.isEmpty() && pq1.peek()>pq2.peek()){
                int val1=pq1.poll();
                int val2=pq2.poll();
                pq2.add(val1);
                pq1.add(val2);
            }
        }
    }
    
    public double findMedian() {
        int size1=pq1.size();
        int size2=pq2.size();
        if(size1==size2)
            return (double)(pq1.peek()+pq2.peek())/2.0;
        else 
            return (double)pq1.peek();
       
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
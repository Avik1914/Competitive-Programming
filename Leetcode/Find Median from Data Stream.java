/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
*/

class MedianFinder {
    PriorityQueue<Integer> pqMax;
    PriorityQueue<Integer> pqMin;
    /** initialize your data structure here. */
    public MedianFinder() {
        pqMax=new PriorityQueue<>((a,b)->b-a);
        pqMin=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        int maxSize=pqMax.size();
        int minSize=pqMin.size();
        
        if(maxSize>minSize)
            pqMin.add(num);
        else
            pqMax.add(num);
    
        
        if((maxSize>0 || minSize>0) && pqMax.peek()>pqMin.peek()){
                    int temp=pqMin.poll();
                    pqMin.add(pqMax.poll());
                    pqMax.add(temp);
        }
    }
    
    public double findMedian() {
         int maxSize=pqMax.size();
         int minSize=pqMin.size();
         
         if(maxSize>minSize)
             return (double)pqMax.peek();
         else if(minSize>maxSize)
             return (double)pqMin.peek();
         else
            return ((double)pqMax.peek()+(double)pqMin.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

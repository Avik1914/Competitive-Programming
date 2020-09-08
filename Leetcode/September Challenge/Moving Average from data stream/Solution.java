/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/
class MovingAverage {
    int itr;
    Queue<Integer> queue;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        itr=size;
        queue=new LinkedList();
        sum=0;
    }
    
    public double next(int val) {
        if(queue.size()>=itr)
            sum-=queue.poll();
        sum+=val;
        
        queue.add(val);
        return (double)sum/(double)queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

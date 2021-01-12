class FreqStack {
    Map<Integer,Integer> counter;
    PriorityQueue<int[]> pq;
    int ind;
    public FreqStack() {
        counter=new HashMap();
        ind=0;
        pq=new PriorityQueue<>((a,b)->b[1]==a[1]?b[2]-a[2]:b[1]-a[1]);
    }
    
    public void push(int x) {
        counter.put(x,counter.getOrDefault(x,0)+1);
        pq.add(new int[]{x,counter.get(x),ind});
        ind++;
    }
    
    public int pop() {
        int x=pq.poll()[0];
        counter.put(x,counter.get(x)-1);
        return x;
    }
}
​
/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */

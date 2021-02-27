class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map=new HashMap();
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        Queue<int[]> queue=new LinkedList();
        
        for(char c:tasks)
            map.put(c,map.getOrDefault(c,0)+1);
        
        for(char c:map.keySet())
            pq.add(c);
        int res=0;
        int pres=0;
        
        while(!pq.isEmpty()){
            char c=pq.poll();
            map.put(c,map.get(c)-1);
            res++;
            if(map.get(c)>0)
                queue.add(new int[]{c,pres+n});
            if(!queue.isEmpty() && queue.peek()[1]==pres)
                pq.add((char)queue.poll()[0]);
            if(!queue.isEmpty() && pq.isEmpty()){
                res+=queue.peek()[1]-pres;
                pres=queue.peek()[1];
                pq.add((char)queue.poll()[0]);
            }
            pres+=1;   
        }
        return res;
    }
}
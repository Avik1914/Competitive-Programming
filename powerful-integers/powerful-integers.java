class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        Queue<Integer> queue=new LinkedList<>();
        Set<Integer> res=new HashSet<>();
        int val=1;
        while(val<bound){
            queue.add(val);
            if(x==1)
                break;
            val=x*val;
        }
        
        while(!queue.isEmpty()){
            int poll=queue.poll();
            val=1;
            while(poll+val<=bound){
                res.add(poll+val);
                if(y==1)
                    break;
                val=y*val;
                
            }
        }
        
        return new ArrayList<>(res);
    }
}
class Solution {
    public int minJumps(int[] arr) {
        int len=arr.length;
        Map<Integer,List<Integer>> map=new HashMap();
        for(int i=0;i<len;i++){
            List<Integer> li=map.getOrDefault(arr[i],new ArrayList());
            li.add(i);
            map.put(arr[i],li);
        }
        Queue<Integer> queue=new LinkedList();
        queue.add(0);
        boolean[] visit=new boolean[len];
        visit[0]=true;
        int res=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int val=queue.poll();
                if(val==len-1)
                    return res;
                if(val+1<len && !visit[val+1]){
                    queue.add(val+1);
                    visit[val+1]=true;
                }
                if(val-1>=0 && !visit[val-1]){
                    queue.add(val-1);
                    visit[val-1]=true;
                }
                if(map.containsKey(arr[val])){
                    for(int i:map.get(arr[val])){
                        if(!visit[i]){
                            queue.add(i);
                            visit[i]=true;
                        }
                    }
                    map.remove(arr[val]);
                }
            }
            res++;
        }
        return -1;
    }
}

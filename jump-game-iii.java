class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue=new LinkedList();
        int len=arr.length;
        
        queue.add(start);
        boolean[] visit=new boolean[len];
        visit[start]=true;
        int a,b;
        while(!queue.isEmpty()){
            int val=queue.poll();
            if(arr[val]==0)
                return true;
            a=val+arr[val];
            b=val-arr[val];
            if(a<len && !visit[a]){
                queue.add(a);
                visit[a]=true;
            }
            if(b>=0 && !visit[b]){
                queue.add(b);
                visit[b]=true;
            }
        }
        return false;
    }
}

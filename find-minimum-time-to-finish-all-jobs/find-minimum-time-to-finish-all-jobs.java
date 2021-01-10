class Solution {
    int min;
    public int minimumTimeRequired(int[] jobs, int k) {
        int len=jobs.length;
        min=Integer.MAX_VALUE;
       
        dfs(jobs,new int[k],k,0,Integer.MIN_VALUE);
        return min;
    }
    
    public void dfs(int[] jobs,int[] assign,int k,int start,int max){
        if(start>=jobs.length){
            min=Math.min(max,min);
            return;
        }
        Set<Integer> set=new HashSet();
        for(int i=0;i<k;i++){
            if(assign[i]+jobs[start]>=min || set.contains(assign[i]))
                continue;
            set.add(assign[i]);
            assign[i]+=jobs[start];
            dfs(jobs,assign,k,start+1,Math.max(assign[i],max));
            assign[i]-=jobs[start];
        }
    }
}

class Solution {
    List<List<Integer>>  res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res=new ArrayList();
        dfs(candidates,target,0,new ArrayList());
        return res;
    }
    
    public void dfs(int[] c,int target,int start,List<Integer> perRes){
        if(target==0){
            res.add(new ArrayList(perRes));
            return;
        }
        if(target<0)
            return;
        for(int i=start;i<c.length;i++){
            if(i>start && c[i-1]==c[i])
                continue;
            perRes.add(c[i]);
            dfs(c,target-c[i],i,perRes);
            perRes.remove(perRes.size()-1);
        }
        
    }
}
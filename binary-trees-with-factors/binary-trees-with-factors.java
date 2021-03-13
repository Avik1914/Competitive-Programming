class Solution {
    Map<Integer,Long> dp;
    public int numFactoredBinaryTrees(int[] arr) {
        long res=0;
        dp=new HashMap();
        Set<Integer> set=new HashSet();
        for(int a:arr)
            set.add(a);
        for(int a:arr){
            res+=dfs(arr,a,set);
            res%=1000000007;
        }
        return (int)res;
    }
    
    public long dfs(int[] arr,int root,Set<Integer> set){
        long res=1l;
        if(dp.get(root)!=null)
            return dp.get(root);
        for(int n:arr){
            if(root%n==0 && set.contains(root/n)){
                res+=dfs(arr,n,set)*dfs(arr,root/n,set);
            }
        }
        dp.put(root,res);
        return res;
    }
}
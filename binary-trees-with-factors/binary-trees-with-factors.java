class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer,Long> dp=new HashMap();
        long ans=0l;
        int len=arr.length;
        
        Arrays.sort(arr);
        
        for(int i=0;i<len;i++){
            dp.put(arr[i],1l);
            long cnt=1l;
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0)
                    cnt+=dp.get(arr[j])*dp.getOrDefault(arr[i]/arr[j],0l);
            }  
            dp.put(arr[i],cnt);
            ans+=cnt;
        }
        return (int)(ans%1000000007);
    }
}
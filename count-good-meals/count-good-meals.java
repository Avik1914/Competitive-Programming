class Solution {
    public int countPairs(int[] deliciousness) {
        int val=1;
        int[] arr=new int[30];
        
        for(int i=0;i<30;i++){
            arr[i]=val;
            val=val*2;
        }
        int len=deliciousness.length;
        Map<Integer,Integer> map=new HashMap();
        
        for(int i=0;i<len;i++)
            map.put(deliciousness[i],map.getOrDefault(deliciousness[i],0)+1);    
        long res=0;
        for(int j=0;j<30;j++){
            for(int i=0;i<len;i++){
​
                   if(map.containsKey(arr[j]-deliciousness[i])){
                        val=map.get(arr[j]-deliciousness[i]);
                        if(arr[j]-deliciousness[i]==deliciousness[i])
                            val--;
                       res+=val;   
                       
                    }   
            }
        }
        res=res/2;
        res%=1000000007;
        return (int)res;
    }
}

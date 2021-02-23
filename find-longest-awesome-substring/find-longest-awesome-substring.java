class Solution {
    public int longestAwesome(String s) {
        char[] arr=s.toCharArray();
        int len=s.length();
        Map<Integer,Integer> map=new HashMap();
        int mask=0;
        int res=0;
        
        for(int i=0;i<len;i++){
            mask^=(1<<(arr[i]-'0'));
            
            int val=Integer.bitCount(mask);
            if(val<2)
                res=Math.max(res,i+1);
            else{
                if(map.containsKey(mask))
                    res=Math.max(res,i-map.get(mask));
                for(int j=0;j<10;j++){
                    if(map.containsKey((mask^(1<<j))))
                        res=Math.max(res,i-map.get((mask^(1<<j))));
                }
            }
            
            if(!map.containsKey(mask))
                map.put(mask,i);
           // System.out.println(i+","+res);
        }
        
        return res;
    }
}
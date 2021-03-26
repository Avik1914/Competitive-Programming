class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> dp=new ArrayList();
        dp.add(0);
        int res=0;
        int len=arr.size();
        
        for(int i=0;i<len;i++){
            char[] cArr=arr.get(i).toCharArray();
            int val=0;
            boolean flag=true;
            for(char c:cArr){
                if((val & (1<<(c-'a')))!=0){
                    flag=false;
                    break;
                }
                val|=(1<<(c-'a'));
            }
            if(!flag)
                continue;
            int size=dp.size();
            for(int j=0;j<size;j++){
                if((val & dp.get(j))==0){
                    int p=(val|dp.get(j));
                    dp.add(p);
                    res=Math.max(res,Integer.bitCount(p));
                }
            }
            
            
        }
        return res;
    }
    
}
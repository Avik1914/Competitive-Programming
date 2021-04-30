class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> list=new ArrayList<>();
        
       int res=0;
        list.add(0);
        
        for(String s:arr){
            int dp=0;
            boolean flag=true;
            for(char c:s.toCharArray()){
                int val=1<<(c-'a');
                if((dp & val)!=0){
                    flag=false;
                    break;
                }
                dp|=val;
            }
            if(!flag)
                continue;
            int size=list.size();
            for(int i=0;i<size;i++){
                if((list.get(i) & dp)==0){
                    int val=(list.get(i) | dp);
                    list.add(val);
                    res=Math.max(res,Integer.bitCount(val));
                }
            }
        }
        
        return res;
    }
}
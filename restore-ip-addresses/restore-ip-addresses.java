class Solution {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res=new ArrayList<>();
        dfs(s.toCharArray(),0,"",0);
        return res;
    }
    
    public void dfs(char[] s,int start,String sb,int count){
        if(s.length==start || count>4){
            if(count==4)
                res.add(sb.substring(0,sb.length()-1));
            return;
        }
        if(s[start]=='0'){
             dfs(s,start+1,sb+"0.",count+1);
            return;
        }
        int val=0;
        
        for(int i=start;i<s.length;i++){
            val=val*10+(s[i]-'0');
            if(val>255)
                return;
            dfs(s,i+1,sb+""+val+".",count+1);
        }
    }
    
}
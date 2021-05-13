class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> res=new ArrayList<>();
        char[] arr=s.toCharArray();
        
        for(int i=2;i<s.length()-1;i++){
            
            for(String k:dfs(s.substring(1,i))){
                for(String g:dfs(s.substring(i,s.length()-1))){
                    res.add("("+k+", "+g+")");
                }
            }    
        }
        
        return res;
    }
    
    
    public List<String> dfs(String s){
        //System.out.println(s);
        int l=s.length();
       char[] cs=s.toCharArray();
       List<String> result = new LinkedList<>();
        if (cs[0] == '0' && cs[l - 1] == '0') {
            if (l == 1) {
                result.add("0");
            }
            return result;
        }
        if (cs[0] == '0') { 
            result.add("0." + s.substring(1));
            return result;
        }
        if (cs[l - 1] == '0') { 
            result.add(s);
            return result;
        }
        result.add(s); 
        for (int i = 1; i < l; i++) {
            result.add(s.substring(0, i) + '.' + s.substring(i));
        }
        return result;
    }
    
    
}
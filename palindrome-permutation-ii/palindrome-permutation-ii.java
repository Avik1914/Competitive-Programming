class Solution {
    List<String> res;
    public List<String> generatePalindromes(String s) {
        Map<Character,Integer> map=new HashMap();
        char[] arr=s.toCharArray();
        res=new ArrayList();
        
        int o=0;
        for(int i=0;i<s.length();i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i])==1)
                o++;
            else if(map.get(arr[i])%2==0)
                o--;
            else
                o++;
        }
        if(o>1)
            return res;
        dfs(map,0,s.length()-1,new char[s.length()]);
        return res;
        
    }
    
    public void dfs(Map<Character,Integer> map,int lo,int hi,char[] perRes){
        if(hi-lo<=0){
            if(hi-lo==0){
                for(char c:map.keySet()){
                    if(map.get(c)==1){
                        perRes[lo]=c;
                        break;
                    }
                }
            }
            res.add(new String(perRes));
            return;
        }
        for(char c:map.keySet()){
            
            if(map.get(c)<=1)
                continue;
            map.put(c,map.get(c)-2);
            perRes[lo]=c;
            perRes[hi]=c;
            dfs(map,lo+1,hi-1,perRes);
            map.put(c,map.get(c)+2);
        }
    }
}

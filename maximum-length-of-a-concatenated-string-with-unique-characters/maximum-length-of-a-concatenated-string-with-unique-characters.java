class Solution {
    int res=0;
    public int maxLength(List<String> arr) {
        dfs(arr,"",0);
        return res;
    }
    
    public void dfs(List<String> arr,String str,int start){
        if(start>=arr.size()){
            if(checkUnique(str))
                res=Math.max(res,str.length());
            return;
        }
        dfs(arr,str+arr.get(start),start+1);
        dfs(arr,str,start+1);
    }
    
    
    public boolean checkUnique(String str){
        int[] lkp=new int[26];
        
        for(char c:str.toCharArray()){
            if(++lkp[c-'a']>1)
                return false;
        }
        return true;
    }
}
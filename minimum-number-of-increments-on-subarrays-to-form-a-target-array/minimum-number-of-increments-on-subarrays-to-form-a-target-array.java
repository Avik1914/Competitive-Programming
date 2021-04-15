class Solution {
    public int minNumberOperations(int[] target) {
        int len=target.length;
        int res=target[0];
        int used=target[0];
        
        for(int i=1;i<len;i++){
            if(used>=target[i])
                used=target[i];
            else{
                res+=target[i]-used;
                used=target[i];
            }
        }
        
        return res;
    }
}
class Solution {
    public int minPartitions(String n) {
        char[] arr=n.toCharArray();
        int res=0;
        
        for(char c:arr)
            res=Math.max(c-'0',res);
        return res;
    }
}

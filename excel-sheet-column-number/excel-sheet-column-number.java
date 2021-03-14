class Solution {
    public int titleToNumber(String columnTitle) {
        int power=0;
        
        int len=columnTitle.length();
        int res=0;
        for(int i=len-1;i>=0;i--){
            res+=Math.pow(26,power)*(columnTitle.charAt(i)-'A'+1);
            power++;
        }
        return res;
    }
}
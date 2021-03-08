class Solution {
    public String longestPalindrome(String s) {
        int start=-1;
        int end= -1;
        
        char[] arr=s.toCharArray();
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        
        for(int i=0;i<len;i++){
            int row=0;
            int col=i;
            
            while(col<len){
                if(col-row<2)
                    dp[row][col]=arr[row]==arr[col]?true:false;
                else{
                    if(arr[row]==arr[col])
                        dp[row][col]=dp[row+1][col-1];
                }
                if(dp[row][col] && (start==-1 || end-start<col-row)){
                    start=row;
                    end=col;
                }
                col++;
                row++;
            }
            
        }
        
        
        return start==-1?"":s.substring(start,end+1);
    }
}
class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
        int len=s.length();
        if(len==1)
            return 1;
        
        char[] arr=s.toCharArray();
        int t=Integer.parseInt(s.substring(0,2));
        if(t>26 && s.charAt(1)=='0')
            return 0;
        int[] dp=new int[len+1];
        dp[0]=1;
        dp[1]=Integer.parseInt(s.substring(0,2))<27 && s.charAt(1)!='0'?2:1;
        
        for(int i=2;i<len;i++){
            int val=Integer.parseInt(s.substring(i-1,i+1));
            
            if(s.charAt(i)=='0'){
                if(val>26 || s.charAt(i-1)=='0')
                    return 0;
                dp[i]=dp[i-2];
            }else{
                if(val>26 || s.charAt(i-1)=='0')
                    dp[i]=dp[i-1];
                else
                    dp[i]=dp[i-2]+dp[i-1];
            }
        }
        
        return dp[len-1];
    }
}
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        int len=s.length();
        int[] dp=new int[len];
        Arrays.fill(dp,1);
        char[] arr=s.toCharArray();
        int res=0;
        
        for(int i=0;i<len;i++){
            if(arr[i]=='(')
                stack.push(i);
            else{
                if(!stack.isEmpty()){
                    int ind=stack.pop();
                    if(ind-1>=0 && dp[ind-1]>1)
                        dp[i]+=dp[ind-1];
                    if(i-1>=0 && dp[i-1]>1)
                        dp[i]+=dp[i-1];
                    dp[i]+=dp[ind];
                    res=Math.max(res,dp[i]);
                }
                
            }
            //System.out.println(i+","+dp[i]);
        }
        
        return res;
    }
}
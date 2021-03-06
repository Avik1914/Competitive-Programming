class Solution {
    Boolean[][][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        dp=new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        
        return dfs(s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),s1.length()-1,s2.length()-1,s3.length()-1);
    }
    
    public boolean dfs(char[] arr1,char[] arr2,char[] arr3,int len1,int len2,int len3){
        if(len3<0)
            return len1<0 && len2<0;
        if(dp[len1+1][len2+1][len3+1]!=null)
            return dp[len1+1][len2+1][len3+1];
        dp[len1+1][len2+1][len3+1]=false;
        
        if(len1>=0 && arr3[len3]==arr1[len1]){
             if(dfs(arr1,arr2,arr3,len1-1,len2,len3-1)){
                 dp[len1+1][len2+1][len3+1]=true;
                 return true;
             }
        }
        if(len2>=0 && arr3[len3]==arr2[len2])
             dp[len1+1][len2+1][len3+1]=dfs(arr1,arr2,arr3,len1,len2-1,len3-1);
       
        return dp[len1+1][len2+1][len3+1];
            
    }
}
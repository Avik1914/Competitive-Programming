class Solution {
    public int numDistinct(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        int[][] dp=new int[len2+1][len1+1];
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();
        int res=0;
        Arrays.fill(dp[0],1);
        
        for(int i=1;i<=len2;i++){
            for(int j=1;j<=len1;j++){
                if(arr2[i-1]==arr1[j-1])
                    dp[i][j]+=dp[i-1][j-1];
                dp[i][j]+=dp[i][j-1];
            }
        }
        
        return dp[len2][len1];
        
    }
    
    public int dfs(char[] s1,char[] s2,int i,int j){
        if(j<0){
            return 1;
        }
        if(i<0 || j<0)
            return -1;
        int a=-1,c=-1;
        if(s1[i]==s2[j]){
            a=dfs(s1,s2,i-1,j-1);
        }
        c=dfs(s1,s2,i-1,j);
        
        a=a==-1?0:a;
        c=c==-1?0:c;
        
        return a+c;
    }
}
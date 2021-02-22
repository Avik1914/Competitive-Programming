class Solution {
    public int longestPalindrome(String word1, String word2) {
        
        String s=word1+""+word2;
        int len1=word1.length();
        
        char[] arr=s.toCharArray();
        int len=arr.length;
        int[][] dp=new int[len][len];
        boolean[][] visit=new boolean[len][len];
        int res=0;
        for(int i=0;i<len;i++){
            int lo=0;
            int hi=i;
            while(hi<len){
                if(lo==hi)
                    dp[lo][hi]=1;
                else if(lo+1==hi && arr[lo]==arr[hi]){
                    if(lo<len1 && hi>=len1)
                        visit[lo][hi]=true;
                    dp[lo][hi]=2;
                }
                else if(arr[lo]==arr[hi]){
                    if(lo<len1 && hi>=len1)
                        visit[lo][hi]=true;
                    dp[lo][hi]=2+dp[lo+1][hi-1];
                }
                else
                    dp[lo][hi]=Math.max(dp[lo][hi-1],dp[lo+1][hi]);
                
                if(visit[lo][hi]){
                    res=Math.max(dp[lo][hi],res);
                    if(res==5)
                        System.out.println(lo+","+hi);
                }
                lo++;
                hi++;
            }
        }
        return res;
    }
}
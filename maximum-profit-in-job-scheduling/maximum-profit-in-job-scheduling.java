class Solution {
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len=startTime.length;
        int[] dp=new int[len];
        int[][] arr=new int[len][3];
        
        for(int i=0;i<len;i++){
            arr[i][0]=startTime[i];
            arr[i][1]=endTime[i];
            arr[i][2]=profit[i];
        }
        Arrays.sort(arr,(a,b)->a[0]==b[0]?b[2]-a[2]:a[0]-b[0]);
        int ans=0;
        for(int i=len-1;i>=0;i--){
            dp[i]=Math.max(ans,arr[i][2]);
            int lo=i;
            int hi=len-1;
            while(lo<hi){
                int mid=(lo+hi)/2;
                if(arr[mid][0]<arr[i][1])
                    lo=mid+1;
                else
                    hi=mid;
            }
            if(arr[lo][0]>=arr[i][1])
                dp[i]=Math.max(ans,dp[lo]+arr[i][2]);
            ans=Math.max(ans,dp[i]);
            
        }
        return ans;
    }
    
    /*public int dfs(int[][] arr,int start){
        if(start>=arr.length)
            return 0;
        int max=0;
        if(dp[start]!=null)
            return dp[start];
        for(int i=start;i<arr.length;i++){
            int lo=i;
            int hi=arr.length-1;
            while(lo<hi){
                int mid=(lo+hi)/2;
                if(arr[mid][0]<arr[i][1])
                    lo=mid+1;
                else

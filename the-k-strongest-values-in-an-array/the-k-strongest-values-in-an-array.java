class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int len=arr.length;
        int med=arr[(len-1)/2];
        
        for(int i=0;i<len;i++)
            arr[i]-=med;
        int lo=0;
        int hi=len-1;
        int res[]=new int[k];
        int itr=0;
        
        while(k-->0 && lo<=hi){
            int a=Math.abs(arr[lo]);
            int b=Math.abs(arr[hi]);
            if(a>b)
                res[itr]=arr[lo++]+med;
            else
                res[itr]=arr[hi--]+med;
            itr++;
        }
        return res;
    }
}
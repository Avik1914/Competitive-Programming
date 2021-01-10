class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res=new int[n];
        for(int[] b:bookings){
            res[b[0]-1]+=b[2];
            if(b[1]<n)
                res[b[1]]-=b[2];
        }
        
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=res[i];
            res[i]=sum;
        }
        return res;
    }
}

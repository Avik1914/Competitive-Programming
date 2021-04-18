class Solution {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        
        int prev=-1;
        int res=0;
        
        for(int i=0;i<A.length;i++){
            if(prev>=A[i]){
                res+=prev-A[i]+1;
                prev++;
            }else
                prev=A[i];
        }
        
        return res;
    }
}
class Solution {
    public int getMaximumConsecutive(int[] coins) {
        int prev=0;
        int sum=0;
        Arrays.sort(coins);
        for(int c:coins){
            if(c>sum+1)
                return sum+1;
            sum+=c;
        }
        
        return sum+1;
    }
}
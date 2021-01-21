class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int res=0;
        
        for(int i=0;i<boxTypes.length;i++){
            int val=Math.min(truckSize,boxTypes[i][0]);
            res+=boxTypes[i][1]*val;
            truckSize-=val;
            if(truckSize==0)
                break;
        }
        
        return res;
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> li=new ArrayList();
        int[] prev=intervals[0];
        int len=intervals.length;
        
        
        for(int i=1;i<len;i++){
            if(intervals[i][0]<=prev[1]){
                prev[1]=Math.max(intervals[i][1],prev[1]);
            }else{
                li.add(prev);
                prev=intervals[i];
            }
        }
        li.add(prev);
        
        int[][] res=new int[li.size()][2];
        
        for(int i=0;i<res.length;i++)
            res[i]=li.get(i);
        
        return res;
    }
}
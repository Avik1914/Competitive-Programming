class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int lo=0;
        int hi=points.length-1;
        while(lo<hi){
            int val=quickSelect(points,lo,hi);
            if(val==k)
                break;
            if(val<k)
                lo=val+1;
            else
                hi=val-1;
        }
        int[][] res=new int[k][2];
        for(int i=0;i<k;i++)
            res[i]=points[i];
        return res;
    }
    
    
    public int quickSelect(int[][] points,int lo,int hi){
        int i=lo-1;
      
        int dist=points[hi][0]*points[hi][0]+points[hi][1]*points[hi][1];
        
        for(int k=lo;k<hi;k++){
            int presDist=(points[k][0]*points[k][0])+(points[k][1]*points[k][1]);
            if(presDist<dist){
                swap(points,i+1,k);
                i++;
            }
        }
        swap(points,i+1,hi);
        return i+1;
    }
    
    public void swap(int[][] points,int i,int j){
        int[] temp=points[i];
        points[i]=points[j];
        points[j]=temp;
    }
}
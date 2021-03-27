class Solution {
    public int trap(int[] height) {
        int len=height.length;
        int[] left=new int[len];
        int[] right=new int[len];
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<len;i++){
            max=Math.max(max,height[i]);    
            left[i]=max;
        }
        max=Integer.MIN_VALUE;
        for(int i=len-1;i>=0;i--){
            max=Math.max(max,height[i]);    
            right[i]=max;
        }
        int res=0;
        for(int i=1;i<len-1;i++)
            res+=Math.min(left[i],right[i])-height[i];
        return res;
    }
}
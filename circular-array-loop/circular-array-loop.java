class Solution {
    
    public boolean circularArrayLoop(int[] nums) {
        int len=nums.length;
        int[] color=new int[len];
        
        
        for(int i=0;i<len;i++){
            if(color[i]==0 && dfs(nums,i,color)){
                //System.out.println(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int[] nums,int start,int[] color){
        if(color[start]==2)
            return false;
        int next=(((start+nums[start])%nums.length)+nums.length)%nums.length;
        if(nums[next]*nums[start]<0 || next==start)
            return false;
        if(color[next]==1)
            return true;
        color[start]=1;
        boolean res=dfs(nums,next,color);
        color[start]=2;
        return res;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int len=nums.length;
        
        int lo=0;
        int hi=len-1;
        int min=Integer.MAX_VALUE;
        int ind=-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(min>Math.abs(x-nums[mid])){
                min=Math.abs(x-nums[mid]);
                ind=mid;
            }
            if(nums[mid]<x)
                lo=mid+1;
            else
                hi=mid-1;
        }
        
        int r=ind,l=ind;
        
        while((r<len || l>=0) && k-->=0){
            if(r==len)
                l--;
            else if(l<0)
                r++;
            else if(Math.abs(nums[r]-x)<Math.abs(nums[l]-x))
                r++;
            else
                l--;
        }
        List<Integer> res=new ArrayList();
        for(int i=l+1;i<r;i++)
            res.add(nums[i]);
        
        return res;
    }
}
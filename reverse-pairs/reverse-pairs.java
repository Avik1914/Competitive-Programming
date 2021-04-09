class Solution {
    int res=0;
    public int reversePairs(int[] nums) {
        int len=nums.length;
        mergeSort(nums,0,len-1);
        return res;
    }
    
    
    public void mergeSort(int[] nums,int lo,int hi){
        if(lo>=hi)
            return;
        int mid=lo+(hi-lo)/2;
        mergeSort(nums,lo,mid);
        mergeSort(nums,mid+1,hi);
        
        merge(nums,lo,mid,hi);
    }
    
    public void merge(int[] nums,int lo,int mid,int hi){
        
        int p=lo,q=mid+1;
        
        while(p<=mid && q<=hi){
            if((long)nums[p]<=(long)2*(long)nums[q])
                p++;
            else{
                res+=mid-p+1;
                q++;
            }
                
        }
        
        
        int itr1=lo;
        int itr2=mid+1;
        List<Integer> li=new ArrayList();
        
        while(itr1<=mid && itr2<=hi){
            if(nums[itr1]<=nums[itr2])
                li.add(nums[itr1++]);
            else
                li.add(nums[itr2++]);
        }
        while(itr1<=mid)
            li.add(nums[itr1++]);
        while(itr2<=hi)
            li.add(nums[itr2++]);
        
        for(int i=0;i<li.size();i++)
            nums[i+lo]=li.get(i);
    }
}
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList();
        permute(nums,0);
        return res;
    }
    
    public void permute(int[] nums,int start){
        if(start==nums.length){
            List<Integer> li=new ArrayList<>();
            for(int n:nums)
                li.add(n);
            res.add(li);
            return;
        }
        for(int i=start;i<nums.length;i++){
            swap(nums,i,start);
            permute(nums,start+1);
            swap(nums,i,start);
        }
    }
    
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
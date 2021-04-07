class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        List<List<Integer>> res=new ArrayList();
        Arrays.sort(nums);
        
        for(int i=0;i<len;){
            int lo=i+1;
            int hi=len-1;
            while(lo<hi){
                int val=nums[i]+nums[lo]+nums[hi];
                if(val==0){
                    List<Integer> perRes=new ArrayList();
                    perRes.add(nums[i]);
                    perRes.add(nums[lo]);
                    perRes.add(nums[hi]);
                    res.add(perRes);
                }
                if(val>0){
                    int temp=nums[hi];
                    while(hi>lo && nums[hi]==temp)
                        hi--;
                }else{
                    int temp=nums[lo];
                    while(hi>lo && nums[lo]==temp)
                        lo++;
                }
               
            }
             int temp=nums[i];
             while(i<len && nums[i]==temp)
                i++;
        }
        return res;
    }
}
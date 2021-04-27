class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> set=new HashMap<>();
        int mul=0;
        set.put(0,-1);
        for(int i=0;i<nums.length;i++){
            mul=mul+nums[i];
            mul=mul%k;
            
            if(set.containsKey(mul) && i-set.get(mul)>1){
                return true;
            }
            set.putIfAbsent(mul,i);
            
        }
        return false;
    }
}
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet=new TreeSet<>();
        
        int start=0;
        
        for(int i=0;i<nums.length;i++){
            Integer ceil=treeSet.ceiling(nums[i]);
            Integer floor=treeSet.floor(nums[i]);
            if(floor!=null && (long)nums[i]-(long)floor<=t)
                return true;
            if(ceil!=null && (long)ceil-(long)nums[i]<=t)
                return true;
            treeSet.add(nums[i]);
            if(i>=k)
                treeSet.remove(nums[i-k]);
        }
        
        return false;
    }
}
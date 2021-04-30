class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums)
            set.add(n);
        Set<Integer> seen=new HashSet<>();
        int res=0;
        for(int i:set){
            int val=i;
            int cnt=0;
            while(set.contains(val) && !seen.contains(val)){
                cnt++;
                seen.add(val);
                val++;
            }
            val=i-1;
            while(set.contains(val) && !seen.contains(val)){
                cnt++;
                seen.add(val);
                val--;
            }
            res=Math.max(cnt,res);
        }
        return res;
    }
}
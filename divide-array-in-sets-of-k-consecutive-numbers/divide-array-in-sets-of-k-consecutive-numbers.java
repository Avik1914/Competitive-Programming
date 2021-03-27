class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer,Integer> map=new TreeMap();
        for(int n:nums)
            map.put(n,map.getOrDefault(n,0)+1);
        
        for(int i:map.keySet()){
            if(map.get(i)==0)
                continue;
            int size=map.get(i);
            for(int j=1;j<k;j++){
                if(map.getOrDefault(i+j,0)<size)
                    return false;
                map.put(i+j,map.get(i+j)-size);
            }
        }
        return true;
    }
}
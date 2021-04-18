class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        int len=hand.length;
        
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        for(int h:hand)
            treeMap.put(h,treeMap.getOrDefault(h,0)+1);
        
        
        for(int h:treeMap.keySet()){
            int size=treeMap.get(h);
            if(size==0)
                continue;
            for(int i=1;i<W;i++){
                if(!treeMap.containsKey(h+i) || treeMap.get(h+i)<size)
                    return false;
                treeMap.put(h+i,treeMap.get(h+i)-size);
            }
        }
        
        return true;
    }
}
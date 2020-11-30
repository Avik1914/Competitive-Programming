class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Set<Integer>> map=new HashMap();
        
        for(int[] r:reservedSeats){
          Set<Integer> set=map.getOrDefault(r[0],new HashSet());
          set.add(r[1]);
          map.put(r[0],set);
        }
        
        int res=0;
        boolean flag=false;
        for(int i:map.keySet()){
            flag=false;
            if(!map.get(i).contains(2) 
                    && !map.get(i).contains(3)
                        && !map.get(i).contains(4)
                            && !map.get(i).contains(5)){
                res++;
                flag=true;
            }
            if(!map.get(i).contains(6) 
                    && !map.get(i).contains(7)
                        && !map.get(i).contains(8)
                            && !map.get(i).contains(9)){
                res++;
                flag=true;
            }
            if(!flag && !map.get(i).contains(4) 
                    && !map.get(i).contains(5)
                        && !map.get(i).contains(6)
                            && !map.get(i).contains(7))
                res++;
            
            
            
        }
        return res+(n-map.size())*2;
    }
}

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] arrA=A.split(" ");
        String[] arrB=B.split(" ");
        
        Map<String,Integer> map1=new HashMap();
        Map<String,Integer> map2=new HashMap();
        Set<String> set=new HashSet();
        
        for(String a:arrA){
            map1.put(a,map1.getOrDefault(a,0)+1);
            set.add(a);
        }
        for(String b:arrB){
            map2.put(b,map2.getOrDefault(b,0)+1);
            set.add(b);
        }
        List<String> li=new ArrayList();
        for(String k:set){
            if(map1.getOrDefault(k,0)==1 && map2.getOrDefault(k,0)==0)
                li.add(k);
            else if(map2.getOrDefault(k,0)==1 && map1.getOrDefault(k,0)==0)
                li.add(k);
        }
        
        int size=li.size();
        String[] res=new String[size];
        for(int i=0;i<size;i++)
            res[i]=li.get(i);
        
        return res;
    }
}

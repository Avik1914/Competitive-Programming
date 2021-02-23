class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer,Integer> map=new HashMap();
        map.put(0,-1);
        Set<Character> set=new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        int len=s.length();
        int res=0;
        int mask=0;
        
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(set.contains(c))
                mask^=(1<<(c-'a'));
            if(map.containsKey(mask))
                res=Math.max(i-map.get(mask),res);
            else
                map.put(mask,i);
        }
        
        return res;
    }
}
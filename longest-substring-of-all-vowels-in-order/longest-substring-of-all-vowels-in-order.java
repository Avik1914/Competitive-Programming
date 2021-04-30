class Solution {
    public int longestBeautifulSubstring(String word) {
        int len=word.length();
        Set<Character> set=new HashSet<>();
        Map<Character,Integer> lkp=new HashMap<>();
        lkp.put('a',0);
        lkp.put('e',1);
        lkp.put('i',2);
        lkp.put('o',3);
        lkp.put('u',4);
        
        int last=-1;
        int res=0;
        char[] arr=word.toCharArray();
        int start=0;
        
        for(int i=0;i<len;i++){
            if(last==lkp.get(arr[i]) || last+1==lkp.get(arr[i])){
                set.add(arr[i]);
                if(set.size()==5)
                    res=Math.max(res,i-start+1);
                last=lkp.get(arr[i]);
            }else{
                set.clear();
                if(arr[i]=='a'){
                    last=0;
                    start=i;
                    set.add(arr[i]);
                    
                }
                else{
                    last=-1;
                    start=i+1;
                }
                
            }
        }
        
        return res;
        
    }
}
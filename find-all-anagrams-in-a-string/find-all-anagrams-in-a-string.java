class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] lkp=new int[26];
        
        for(char c:p.toCharArray())
            lkp[c-'a']++;
        int len=s.length();
        int cnt=p.length();
        int start=0;
        List<Integer> res=new ArrayList<>();
        
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(lkp[c-'a']-->0)cnt--;
            if(i-start>=p.length())cnt=lkp[s.charAt(start++)-'a']++>=0?cnt+1:cnt;
            if(cnt==0)res.add(i-p.length()+1);
        }
        
        return res;
    }
}
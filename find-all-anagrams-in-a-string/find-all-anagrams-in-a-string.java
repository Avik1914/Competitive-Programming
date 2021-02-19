class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] lkp=new int[26];
        for(char c:p.toCharArray())
            lkp[c-'a']++;
        
        int right=0,left=0,cnt=0;
        List<Integer> res=new ArrayList();
        while(right<s.length()){
            char c=s.charAt(right++);
            if(lkp[c-'a']-->0)
                cnt++;
            if(cnt==p.length())
                res.add(left);
            if(right-left==p.length()){
                if(lkp[s.charAt(left++)-'a']++>=0)
                    cnt--;
            }
        }
        
        return res;
    }
}
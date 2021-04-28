class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] lkp=new int[26];
        
        for(char c:s1.toCharArray())
            lkp[c-'a']++;
        int len=s1.length();
        int start=0;
        
        for(int i=0;i<s2.length();i++){
            char c=s2.charAt(i);
            if(lkp[c-'a']-->0)len--;
            
            if(i-start>=s1.length())len=lkp[s2.charAt(start++)-'a']++>=0?len+1:len;  
            if(len==0)
                return true;
        }
        
        return false;
    }
}
class Solution {
    public int countQuadruples(String firstString, String secondString) {
        int[] lkpFirst=new int[26];
        int[] lkpSecond=new int[26];
        Arrays.fill(lkpFirst,-1);
        Arrays.fill(lkpSecond,-1);
        int len1=firstString.length();
        int len2=secondString.length();
        
        for(int i=0;i<len1;i++){
            char c=firstString.charAt(i);
            if(lkpFirst[c-'a']==-1)
                lkpFirst[c-'a']=i;
        }
        int min=len1+1;
        for(int i=0;i<len2;i++){
            char c=secondString.charAt(i);
            lkpSecond[c-'a']=i;
            if(lkpFirst[c-'a']!=-1)
                min=Math.min(min,lkpFirst[c-'a']-i);
        }
        int res=0;
        for(int i=0;i<26;i++){
            if(lkpFirst[i]!=-1 && lkpSecond[i]!=-1 && lkpFirst[i]-lkpSecond[i]==min)
                res++;
        }
        
        return res;
    }
}
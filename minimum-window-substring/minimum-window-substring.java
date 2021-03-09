class Solution {
    public String minWindow(String s, String t) {
        int[] lkp=new int[128];
        for(char c:t.toCharArray())
            lkp[c]++;
        int lenS=s.length();
        int lenT=t.length();
        int start=0;
        int itr=0;
        int[] runLkp=new int[128];
        int res=lenS+1;
        int startInd=-1,endInd=-1;
        for(int i=0;i<lenS;i++){
            char c=s.charAt(i);
            if(runLkp[c]<lkp[c])
                itr++;
            runLkp[c]++;
            while(start<lenS && runLkp[s.charAt(start)]>lkp[s.charAt(start)]){
                runLkp[s.charAt(start)]--;
                start++;
            }

            if(itr==lenT){
                if(res>i-start+1){
                    startInd=start;
                    endInd=i+1;
                    res=i-start+1;
                }
            }
        }
        
        
        return startInd==-1?"":s.substring(startInd,endInd);
        
    }
}
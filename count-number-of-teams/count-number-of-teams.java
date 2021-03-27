class Solution {
    public int numTeams(int[] rating) {
        int len=rating.length;
        int res=0;
        for(int i=1;i<len-1;i++){
            int lo=0;
            int g1=0,g2=0,l1=0,l2=0;
            while(lo<i){
                if(rating[lo]<rating[i])
                    l1++;
                else if(rating[lo]>rating[i])
                    g1++;
                lo++;
            }
            
            lo=i+1;
            while(lo<len){
                if(rating[lo]<rating[i])
                    l2++;
                else if(rating[lo]>rating[i])
                    g2++;
                lo++;
            }
            res+=l1*g2+g1*l2;
           
        }
        return res;
    }
}
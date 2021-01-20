class Solution {
    public int numWays(String s) {
        char[] arr=s.toCharArray();
        long len=arr.length-1;
        int cnt=0;
        int MOD=1000000007;
        for(char c:arr){
            if(c=='1')
                cnt++;
        }
        long res=1;
        if(cnt==0){
            res=(len*(len-1))/2l;
            res%=MOD;
            return (int)res;
        }
        if(cnt%3!=0)
            return 0;
        cnt=cnt/3;
        
        int no=0;
        int mul=0;
        
        for(char c:arr){
            if(c=='1')
                no++;
            if(no>cnt){
                res*=mul; 
                res%=MOD;
                no=1;
                mul=0;
            }
            if(no==cnt)
                mul++;        
        }
        return (int)res;

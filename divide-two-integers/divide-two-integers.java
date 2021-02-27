class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign1=(dividend<0 || divisor<0) && !(dividend<0 && divisor<0);
        long res=0;
        long divid=Math.abs((long)dividend);
        long divis=Math.abs((long)divisor);
        
        while(divid>=divis){
            long mul=divis;
            long val=0;
            
            long itr=1;

            while(val+mul<=divid){
                val+=mul;
                mul+=mul;
                res+=itr;
                itr=itr<<1;
            }
            divid-=val;
        }
        
        if(sign1)
            res=-res;
        
        if(res>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(res<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)res;
    }
}
class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1.0;
        if(n==Integer.MIN_VALUE){
            x=x*x;
            n=n/2;
        }
        if(n<0){
            x=1.0/x;
            n=Math.abs(n);
        }
        return n%2==1?x*myPow(x*x,n/2):myPow(x*x,n/2);
    }
}
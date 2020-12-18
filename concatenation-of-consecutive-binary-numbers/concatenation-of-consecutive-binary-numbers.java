class Solution {
    public int concatenatedBinary(int n) {
        long mod=1000000007;
        long cnt=1l;
        long res=1l;
        
        for(int i=2;i<=n;i++){
             int val=Integer.toBinaryString(i).length();
             res=(long)((res*(Math.pow(2,val)%mod)+(long)i)%mod);
        }
        return (int)res;
    }
}

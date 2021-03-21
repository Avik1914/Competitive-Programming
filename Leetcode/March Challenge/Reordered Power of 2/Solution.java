/*
Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this in a way such that the resulting number is a power of 2.

 

Example 1:

Input: 1
Output: true
Example 2:

Input: 10
Output: false
Example 3:

Input: 16
Output: true
Example 4:

Input: 24
Output: false
Example 5:

Input: 46
Output: true
 

Note:

1 <= N <= 10^9
*/class Solution {
    public boolean reorderedPowerOf2(int N) {
        int[] dig=new int[10];
        while(N>0){
            dig[N%10]++;
            N=N/10;
        }
        for(int i=0;i<32;i++){
            N=1<<i;
            int[] digLoc=new int[10];
            while(N>0){
                digLoc[N%10]++;
                N=N/10;
            }
            boolean flag=true;
            for(int j=0;j<10;j++){
                if(digLoc[j]!=dig[j]){
                    //System.out.println(i+","+j);
                    flag=false;
                    break;
                }
            }
            
            if(flag)
                return true;
        }
        return false;
    }
}


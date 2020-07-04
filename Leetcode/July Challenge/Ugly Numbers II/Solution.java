/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
*/

class Solution {
    public int nthUglyNumber(int n) {
     int a=0,b=0,c=0;
     int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int val1=dp[a]*2;
            int val2=dp[b]*3;
            int val3=dp[c]*5;
            
            if(val1<=val2 && val1<=val3){
                dp[i]=val1;
                a++;
                if(val1==val2)
                    b++;
                if(val1==val3)
                    c++;
            }else if(val2<=val1 && val2<=val3){
                dp[i]=val2;
                b++;
                if(val1==val2)
                    a++;
                if(val2==val3)
                    c++;
            }else{
                dp[i]=val3;
                c++;
                if(val1==val3)
                    a++;
                if(val2==val3)
                    b++;
            }
        }
        
        return dp[n-1];
        
    }
}

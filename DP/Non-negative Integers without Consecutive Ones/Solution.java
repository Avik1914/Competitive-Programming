/*
Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.

Example 1:

Input: 5
Output: 5
Explanation: 
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule. 
Note: 1 <= n <= 109
*/

class Solution {
    public int findIntegers(int num) {
        int res=0;
        char[] arr=Integer.toBinaryString(num).toCharArray();
        int len=arr.length;
        int result =len; 
        
        int[] fib=new int[result+2];
        fib[0]=2;
        fib[1]=3;
        for(int i=2;i<=result;i++)
            fib[i]=fib[i-2]+fib[i-1];
        
        res=fib[result];
        
        char prev='0';
        for(int i=0;i<len;i++){
            if(arr[i]=='1' && prev=='1')
                break;
            prev=arr[i];
            if(arr[i]=='1' || arr[i-1]=='1')
                continue;
            
            if(len-i-3<0)
                res--;
            else
                res-=fib[len-i-3];
        }
        return res;
    }
}

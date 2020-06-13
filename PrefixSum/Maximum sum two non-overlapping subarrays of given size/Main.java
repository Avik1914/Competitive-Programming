/*
Given an array, we need to find two subarrays with a specific length K such that sum of these subarrays is maximum among all possible choices of subarrays.
Examples:

Input : arr[] = [2, 5, 1, 2, 7, 3, 0]
        K = 2
Output : 2 5
         7 3
We can choose two arrays of maximum sum
as [2, 5] and [7, 3], the sum of these two 
subarrays is maximum among all possible 
choices of subarrays of length 2.

Input : arr[] = {10, 1, 3, 15, 30, 40, 4, 50, 2, 1}
        K = 3
Output : 3 15 30 
         40 4 50 
*/

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
       int[] arr={10, 1, 3, 15, 30, 40, 4, 50, 2, 1};
       int k=3;
       int sum=0;
       int start=0;
       int[] dp=new int[arr.length];
       int max=Integer.MIN_VALUE;
       int res=Integer.MIN_VALUE; 
       int oiginial=0;
        for(int i=0;i<arr.length;i++){
                sum+=arr[i];
                if(i-start+1==k){
                    max=Math.max(max,sum);
                    oiginial=sum;
                    sum=sum-arr[start++];
                }
            dp[i]=max;
            if(i>=k && dp[i-k]!=Integer.MIN_VALUE)
                res=Math.max(res,dp[i-k]+oiginial);
        }
        System.out.println(res);
    }
}

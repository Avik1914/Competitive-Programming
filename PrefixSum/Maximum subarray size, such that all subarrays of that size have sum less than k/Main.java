/*
Given an array of n positive integers and a positive integer k, the task is to find the maximum subarray size such that all subarrays of that size have sum of elements less than or equals to k.

Examples :

Input :  arr[] = {1, 2, 3, 4} and k = 8.
Output : 2
Sum of subarrays of size 1: 1, 2, 3, 4.
Sum of subarrays of size 2: 3, 5, 7.
Sum of subarrays of size 3: 6, 9.
Sum of subarrays of size 4: 10.
So, maximum subarray size such that all subarrays
of that size have the sum of elements less than 8 is 2.

Input :  arr[] = {1, 2, 10, 4} and k = 8.
Output : -1
There is an array element with value greater than k,
so subarray sum cannot be less than k.

Input :  arr[] = {1, 2, 10, 4} and K = 14
Output : 2
*/


// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] arr={1, 2, 10, 4};
        int k=14;
       
        int[] prefixSum=new int[arr.length+1];
        
        for(int i=0;i<arr.length;i++)
            prefixSum[i+1]=prefixSum[i]+arr[i];
        int lo=1;
        int hi=arr.length;
        int mid=0;
        int res=-1;
        while(lo<=hi){
            mid=lo+((hi-lo)/2);
            int max=Integer.MIN_VALUE;
            for(int i=mid;i<=arr.length;i++)
                max=Math.max(max,prefixSum[i]-prefixSum[i-mid]);
            if(max>k)
                hi=mid-1;
            else
                lo=mid+1;
            if(max<=k)
                res=mid;
            //System.out.println(max);
        }
        
        System.out.println(res);
    }
}

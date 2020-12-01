/*
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is greater than or equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation:
- When the length is 4, averages are [0.5, 12.75, 10.5] and the maximum average is 12.75
- When the length is 5, averages are [10.4, 10.8] and the maximum average is 10.8
- When the length is 6, averages are [9.16667] and the maximum average is 9.16667
The maximum average is when we choose a subarray of length 4 (i.e., the sub array [12, -5, -6, 50]) which has the max average 12.75, so we return 12.75
Note that we do not consider the subarrays of length < 4.
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
 

Constraints:

n == nums.length
1 <= k <= n <= 104
-104 <= nums[i] <= 104
*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double lo=-10000;
        double hi=10000;
        double res=0.0;
        while(hi-lo>=1e-5){
            double mid=(hi+lo)/2.0;
            if(check(nums,k,mid)){
                lo=mid;
                res=mid;
            }
            else
                hi=mid;
        }
        return res;
    }
    
    public boolean check(int[] nums,int k,double mid){
        int len=nums.length;
        int start=0;
        double sum=0.0;
        double prevSum=0.0;
        double prevMin=0.0;
        for(int i=0;i<len;i++){
            sum+=nums[i]-mid;
            if(i+1>=k){
                if(sum-prevMin>=0)
                    return true;
                prevSum+=nums[start]-mid;
                prevMin=Math.min(prevSum,Math.min(nums[start],prevMin));
                start++;
            }
        }
        return false;
    }
}

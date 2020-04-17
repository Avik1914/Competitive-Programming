/*
907. Sum of Subarray Minimums
Medium

929

61

Add to List

Share
Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

Since the answer may be large, return the answer modulo 10^9 + 7.

 

Example 1:

Input: [3,1,2,4]
Output: 17
Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 

Note:

1 <= A.length <= 30000
1 <= A[i] <= 30000
*/


class Solution {
    public int sumSubarrayMins(int[] nums) {
        int len=nums.length;
        Stack<Integer> stack=new Stack();
        int res=0;
        
        for(int i=0;i<len;i++){
            
                while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                    int val=stack.pop();
                    int k=stack.isEmpty()?val+1:val-stack.peek();
                    res+=(i-val)*k*nums[val];
                    res=res % 1000000007;
                }
                stack.push(i);
           // System.out.println(res);
        }
        while(!stack.isEmpty()){
                    int val=stack.pop();
                    int k=stack.isEmpty()?val+1:val-stack.peek();
                    res+=(len-val)*k*nums[val];
                    res=res % 1000000007;
            //System.out.println(nums[val]+","+((len-val)*k));
        }
       return res; 
    }
}

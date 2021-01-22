/*
Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.

An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.

We define that a subsequence a is more competitive than a subsequence b (of the same length) if in the first position where a and b differ, subsequence a has a number less than the corresponding number in b. For example, [1,3,4] is more competitive than [1,3,5] because the first position they differ is at the final number, and 4 is less than 5.

 

Example 1:

Input: nums = [3,5,2,6], k = 2
Output: [2,6]
Explanation: Among the set of every possible subsequence: {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]}, [2,6] is the most competitive.
Example 2:

Input: nums = [2,4,3,3,5,4,9,6], k = 4
Output: [2,3,3,4]
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109
1 <= k <= nums.length
*/

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack=new Stack();
       
        int len=nums.length;
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && nums[i]<stack.peek() && stack.size()+len-i-1>=k)
                stack.pop();
            if(stack.size()<k)
                stack.push(nums[i]);
        }
        int[] res=new int[k];
        for(int i=k-1;i>=0;i--)
            res[i]=stack.pop();
        
        return res;
    }
}

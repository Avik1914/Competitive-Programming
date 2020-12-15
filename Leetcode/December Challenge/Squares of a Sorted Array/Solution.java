/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int ptr1=-1;
        int ptr2=-1;
        int len=nums.length;
        
        for(int i=0;i<len;i++){
            if(nums[i]>=0){
                ptr2=i;
                break;
            }
            else
                ptr1=i;
        }
        
        int[] res=new int[len];
        for(int i=0;i<len;i++){
            if(ptr1==-1)
                res[i]=nums[i]*nums[i];
            else{
                if(ptr2<len && ptr2>=0 && Math.abs(nums[ptr1])>Math.abs(nums[ptr2]))
                    res[i]=nums[ptr2]*nums[ptr2++];
                else
                    res[i]=nums[ptr1]*nums[ptr1--];
            }
            
        }
        return res;
    }
}

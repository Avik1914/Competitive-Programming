/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/

class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        res=new ArrayList();
    
        //Arrays.sort(nums);  
        dfs(nums,0);
        return res;
    } 
    
    public void dfs(int[] nums,int start){
        if(nums.length==start)
            res.add(Arrays.stream(nums)     
                                    .boxed()          
                                    .collect(Collectors.toList()));
        Set<Integer> used=new HashSet();
        for(int i=start;i<nums.length;i++){
            if(used.contains(nums[i]))
                continue;
            used.add(nums[i]);
            swap(nums,i,start);
            dfs(nums,start+1);
            swap(nums,i,start);
        }
    }
    
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}

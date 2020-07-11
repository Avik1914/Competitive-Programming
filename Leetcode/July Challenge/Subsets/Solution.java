/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        dfs(nums,0,new ArrayList(),res);
        return res;
    }
    
    public void dfs(int[] nums,int start,List<Integer> perRes,List<List<Integer>> res){
        if(start>=nums.length){
            res.add(new ArrayList(perRes));
            return;
        }
        perRes.add(nums[start]);
        dfs(nums,start+1,perRes,res);
        perRes.remove(perRes.size()-1);
        dfs(nums,start+1,perRes,res);
    }
}

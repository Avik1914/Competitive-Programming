class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res=new ArrayList();
        dfs(nums,0,new LinkedList());
        return res;
    }
    
    public void dfs(int[] nums,int start,LinkedList<Integer> perList){
        if(start>=nums.length){
            res.add(new ArrayList(perList));
            return;
        }
        perList.add(nums[start]);
        dfs(nums,start+1,perList);
        perList.removeLast();
        dfs(nums,start+1,perList);
    }
}
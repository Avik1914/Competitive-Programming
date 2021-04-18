class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res=new ArrayList();
        Arrays.sort(nums);
        dfs(nums,0,new LinkedList<>());
        return res;
    }
    
     public void dfs(int[] nums,int start,LinkedList<Integer> perList){
       
            res.add(new ArrayList(perList));
            
        
        
        for(int i=start;i<nums.length;i++){
            if(i==start || nums[i]!=nums[i-1]){
                perList.add(nums[i]);
                dfs(nums,i+1,perList);
                perList.removeLast();
            }
        }        
    }
}
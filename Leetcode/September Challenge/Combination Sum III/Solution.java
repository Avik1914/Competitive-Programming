/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
*/

class Solution {
    List<List<Integer>> f;
    public List<List<Integer>> combinationSum3(int k, int n) {
        f=new ArrayList();
        dfs(k,n,new ArrayList(),1);
        return f;
    }
    
    public void dfs(int k,int n,List<Integer> res,int start){
        if(k==0 && n==0){
            f.add(new ArrayList(res));
            return;
        }
        if(k<=0 || n<=0 || start*k>n)
            return;
            
        for(int i=start;i<10;i++){
            res.add(i);
            dfs(k-1,n-i,res,i+1);
            res.remove(new Integer(i));
        }
        
        
    }
}

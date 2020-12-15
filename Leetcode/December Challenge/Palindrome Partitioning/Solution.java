/*Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.*/

class Solution {
    boolean[][] lkp;
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        int len=s.length();
        lkp=new boolean[len][len];
        res=new ArrayList();
        char[] arr=s.toCharArray();
        countSubstrings(arr);
        backtrack(arr,0,new ArrayList());
        return res;
    }
    
    public void backtrack(char[] arr,int start,List<String> li){
        if(start>=arr.length){
            res.add(new ArrayList(li));
            return;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=start;i<arr.length;i++){
            sb.append(arr[i]);
            if(lkp[start][i]){
                li.add(sb.toString());
                backtrack(arr,i+1,li);
                li.remove(li.size()-1);
            }
        }
    }
    
     public int countSubstrings(char[] arr) {
        int cnt=0;
        
        for(int i=0;i<arr.length;i++){
            cnt+=growPals(arr,i,i);
            cnt+=growPals(arr,i,i+1);
        }
        return cnt;
    }
    
    public int growPals(char[] arr,int lo,int hi){
        int res=0;
        while(lo>=0 && hi<arr.length && arr[lo]==arr[hi]){
            lkp[lo][hi]=true;
            lo--;
            hi++;
            res++;
        }
        return res;
    }
}

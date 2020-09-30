/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet(wordDict);
        Map<String,Boolean> map=new HashMap();
        return dfs(s,set,map);
    }
    
    public boolean dfs(String s,Set<String> set,Map<String,Boolean> map){
        if(s.equals(""))
            return true;
        if(map.containsKey(s))
            return map.get(s);
        for(int i=0;i<s.length();i++){
            if(set.contains(s.substring(0,i+1)) && dfs(s.substring(i+1),set,map)){
                map.put(s,true);
                return true;
            }
        }
        map.put(s,false);
        return false;
    }
}

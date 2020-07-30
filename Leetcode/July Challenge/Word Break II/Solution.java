/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
*/
class Solution {
    Map<Integer,List<String>> dp;
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> lkp=new HashSet();
        lkp.addAll(wordDict);
        dp=new HashMap();
        List<String> res=dfs(s.toCharArray(),0,lkp);
        return res==null?new ArrayList():res;
        
    }
    
    public List<String> dfs(char[] s,int start,Set<String> lkp){
        List<String> ret=null;
        if(start==s.length){
            return new ArrayList();
        }
        if(dp.containsKey(start))
            return dp.get(start);
        StringBuilder newSB=new StringBuilder();
        for(int i=start;i<s.length;i++){
            newSB.append(s[i]);
            if(lkp.contains(newSB.toString())){
                List<String> li=dfs(s,i+1,lkp);
                if(li!=null){
                    if(ret==null)
                        ret=new ArrayList();
                    if(li.isEmpty())
                        ret.add(newSB.toString());
                    else{
                        for(String g:li)
                            ret.add(new String(newSB.toString()+" "+g).trim());
                    }
                }
            }
        }
        dp.put(start,ret);
        return ret;
    }
}

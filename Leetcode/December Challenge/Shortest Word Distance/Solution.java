/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int a=-1;
        int b=-1;
        int itr=0;
        int res=words.length;
        for(String w:words){
            if(w.equals(word1))
                a=itr;
            else if(w.equals(word2))
                b=itr;
            itr++;
            if(a!=-1 && b!=-1)
                res=Math.min(Math.abs(b-a),res);
        }
        return res;
    }
}

/*
Given two words beginWord and endWord, and a dictionary wordList, return the length of the shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Return 0 if there is no such transformation sequence.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 

Constraints:

1 <= beginWord.length <= 100
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the strings in wordList are unique.
*/


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue=new LinkedList();
        Set<String> wl=new HashSet(wordList);
        Set<String> visit=new HashSet();
        visit.add(beginWord);
        queue.add(beginWord);
        int res=1;

        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                String s=queue.poll();
                if(s.equals(endWord))
                    return res;
                char[] arr=s.toCharArray();
                for(int i=0;i<arr.length;i++){
                    char ori=arr[i];
                    for(char c='a';c<='z';c++){
                        arr[i]=c;
                        String str=new String(arr);
                        if(wl.contains(str) && !visit.contains(str)){
                            queue.add(str);
                            visit.add(str);
                        }
                    }
                    arr[i]=ori;
                }
            }
            res++;
        }
        
        return 0;
    }
}

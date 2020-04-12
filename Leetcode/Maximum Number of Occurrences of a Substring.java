/*
Given a string s, return the maximum number of ocurrences of any substring under the following rules:

The number of unique characters in the substring must be less than or equal to maxLetters.
The substring size must be between minSize and maxSize inclusive.
 

Example 1:

Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
Output: 2
Explanation: Substring "aab" has 2 ocurrences in the original string.
It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
Example 2:

Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
Output: 2
Explanation: Substring "aaa" occur 2 times in the string. It can overlap.
Example 3:

Input: s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
Output: 3
Example 4:

Input: s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
Output: 0
 

Constraints:

1 <= s.length <= 10^5
1 <= maxLetters <= 26
1 <= minSize <= maxSize <= min(26, s.length)
s only contains lowercase English letters.
*/

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int len=s.length();
        int start=0;
        Map<String,Integer> map=new HashMap();
        
        int[] lkp=new int[26];
            int count=0;
        int max=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(lkp[c-'a']==0)
                count++;
            lkp[c-'a']++;
            while(count>maxLetters){
                char d=s.charAt(start++);
                if(--lkp[d-'a']==0)
                    count--;
                sb.deleteCharAt(0);
            }
            sb.append(c);
            if(i-start+1==minSize){
                String temp=sb.toString();
                map.put(temp,map.getOrDefault(temp,0)+1);
                max=Math.max(map.get(temp),max);
                sb.deleteCharAt(0);
                char d=s.charAt(start++);
                if(--lkp[d-'a']==0)
                    count--;
            }
        }
        return max;
    }
}

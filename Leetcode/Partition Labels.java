/*
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
*/

/*1st Approach*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lkp=new int[26];
        int itr=0;
        for(char c:S.toCharArray())
            lkp[c-'a']++;
        int cnt=0;
        int tik=0;
        List<Integer> res=new ArrayList();
        for(char c:S.toCharArray()){
            tik++;
            itr=itr|1<<(c-'a');
            if(--lkp[c-'a']==0)
                cnt++;
            if(Integer.bitCount(itr)==cnt){
                res.add(tik);
                tik=0;
                itr=0;
                cnt=0;
            }
        }
        return res;
    }
}

/*2ND approach*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lkp=new int[26];
        int itr=0;
        for(int i=0;i<S.length();i++)
            lkp[S.charAt(i)-'a']=i;
        
        List<Integer> res=new ArrayList();
        int max=0;
        int prev=0;
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            max=Math.max(max,lkp[c-'a']);
            if(max==i){
                res.add(i-prev+1);
                prev=i+1;
            }
        }
        return res;
    }
}

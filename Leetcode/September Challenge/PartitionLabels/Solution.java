/*
A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.
*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        char[] arr=S.toCharArray();
        int[] lkp=new int[26];
        for(int i=0;i<arr.length;i++)
            lkp[arr[i]-'a']=i;
        
        List<Integer> li=new ArrayList();
        int bit=0;
        int cnt=0;
        int prev=0;
        for(int i=0;i<arr.length;i++){
            if(lkp[arr[i]-'a']==i)
                cnt++;
            bit|=1<<(arr[i]-'a');
            if(Integer.bitCount(bit)==cnt){
                li.add(i+1-prev);
                prev=i+1;
            }
        }
        return li;
    }
}

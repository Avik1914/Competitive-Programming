/*
All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 

Constraints:

0 <= s.length <= 105
s[i] is 'A', 'C', 'G', or 'T'.
*/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res=new ArrayList();
        StringBuilder sb=new StringBuilder();
        Map<String,Integer> set=new HashMap();
       
        int len=s.length();
        if(len<=10)
            return res;
        for(int i=0;i<10;i++)
            sb.append(s.charAt(i));
        set.put(sb.toString(),1);
        for(int i=10;i<len;i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            String str=sb.toString();
            int val=set.getOrDefault(str,0);
            if(val==1)
                res.add(str);
            
            set.put(str,val+1);
            
        }
        return res;
    }
}

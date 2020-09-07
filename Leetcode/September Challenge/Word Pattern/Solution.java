/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
*/

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr=str.split(" ");
        Map<Character,String> map1=new HashMap();
        Map<String,Character> map2=new HashMap();
        int len1=pattern.length();
        int len2=arr.length;
        if(len1!=len2)
            return false;
        
        for(int i=0;i<len1;i++){
            char c=pattern.charAt(i);
            if(!map1.containsKey(c) && !map2.containsKey(arr[i])){
                map1.put(c,arr[i]);
                map2.put(arr[i],c);
            }else if(map1.containsKey(c) && map2.containsKey(arr[i])){
                if(!map1.get(c).equals(arr[i]) || map2.get(arr[i])!=c)
                    return false;
            }else
                   return false;
        }
        return true;
    }
}

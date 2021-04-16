/*
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 10^5
2 <= k <= 10^4
s only contains lower case English letters.
*/

class Solution {
    public String removeDuplicates(String s, int k) {
        char[] arr=s.toCharArray();
        Stack<int[]> stack=new Stack<>();
        
        for(int i=0;i<arr.length;i++){
            int val=arr[i];
            if(!stack.isEmpty() && stack.peek()[0]==val)
                stack.peek()[1]++;
            else
                stack.push(new int[]{val,1});
            if(stack.peek()[1]==k)
                stack.pop();
        }
        StringBuilder sb=new StringBuilder();
        
        while(!stack.isEmpty()){
            int[] val=stack.pop();
            for(int i=0;i<val[1];i++)
                sb.insert(0,(char)val[0]);
        }
        
        return sb.toString();
    }
}

/*
Given an array of integers A, return the largest integer that only occurs once.

If no integer occurs once, return -1.

 

Example 1:

Input: [5,7,3,9,4,9,8,3,1]
Output: 8
Explanation: 
The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it's the answer.
Example 2:

Input: [9,9,8,8]
Output: -1
Explanation: 
There is no number that occurs only once.
 

Note:

1 <= A.length <= 2000
0 <= A[i] <= 1000
*/

class Solution {
    public int largestUniqueNumber(int[] A) {
        int len=A.length;
        Map<Integer,Integer> map=new HashMap();
        
        for(int i=0;i<len;i++)
            map.put(A[i],map.getOrDefault(A[i],0)+1);
        int max=-1;
        for(int a:map.keySet()){
            if(map.get(a)==1)
                max=Math.max(a,max);
        }
        return max;
    }
}

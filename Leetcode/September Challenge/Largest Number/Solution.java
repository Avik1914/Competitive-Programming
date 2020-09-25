/*
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
*/

class Comp implements Comparator<Integer>{
    public int compare(Integer a,Integer b){
       String s1=b+""+a;
       String s2=a+""+b;
       long val1=Long.parseLong(s1);
       long val2=Long.parseLong(s2);
       if(val1>val2)
           return 1;
        return -1;
        
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comp());
        for(int n:nums)
            pq.add(n);
        StringBuilder sb=new StringBuilder();
        boolean first=true;
        boolean isZero=false;
        while(!pq.isEmpty()){
            int val=pq.poll();
            if(val==0 && first){
                isZero=true;
                continue;
            }
            sb.append(val);
            first=false;
        }
        return sb.length()==0 && isZero?"0":sb.toString();
    }
}

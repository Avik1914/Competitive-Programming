/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap();
        List<Integer> li=new ArrayList();
        int len=(nums.length/3);
        for(int n:nums)
            map.put(n,map.getOrDefault(n,0)+1);
        for(int i:map.keySet()){
            if(map.get(i)>len)
                li.add(i);
        }
        return li;
    }
}

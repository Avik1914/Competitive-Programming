/*
Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.

 

Example 1:

Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]
Example 2:

Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]
 

Note:

1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9
*/

class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int len=B.length;
        
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        
        for(int a:A)
            treeMap.put(a,treeMap.getOrDefault(a,0)+1);
        
        
        
        int[] res=new int[len];
        
        for(int i=0;i<len;i++){
            Integer val=treeMap.higherKey(B[i]);
            if(val==null)
                val=treeMap.firstKey();
            res[i]=val;
            if(treeMap.get(val)==1)
                treeMap.remove(val);
            else
                treeMap.put(val,treeMap.get(val)-1);
         }
        return res;
    }
}

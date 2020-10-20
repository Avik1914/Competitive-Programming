/*
In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

 

Example 1:


Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
 

Constraints:

2 <= A.length == B.length <= 2 * 104
1 <= A[i], B[i] <= 6
*/


class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int len=A.length;
        int a1=A[0];
        int a2=B[0];
        int aSwap1=0;
        int bSwap1=0;
        int aSwap2=0;
        int bSwap2=0;
        
        for(int i=0;i<len;i++){
            if(aSwap1!=-1 && A[i]!=a1){
                if(B[i]==a1)
                    aSwap1++;
                else
                    aSwap1=-1;
            }
            
            if(bSwap1!=-1 && B[i]!=a1){
                if(A[i]==a1)
                    bSwap1++;
                else
                    bSwap1=-1;
            }
        }
        //System.out.println(aSwap1+","+bSwap1);
        for(int i=0;i<len;i++){
            if(aSwap2!=-1 && A[i]!=a2){
                if(B[i]==a2)
                    aSwap2++;
                else
                    aSwap2=-1;
            }
            
            if(bSwap2!=-1 && B[i]!=a2){
                if(A[i]==a2)
                    bSwap2++;
                else
                    bSwap2=-1;
            }
        }
        
        int max=Integer.MAX_VALUE;
        if(aSwap1!=-1)
            max=Math.min(max,aSwap1);
        if(aSwap2!=-1)
            max=Math.min(max,aSwap2);
        if(bSwap1!=-1)
            max=Math.min(max,bSwap1);
        if(bSwap2!=-1)
            max=Math.min(max,bSwap2);
        return max==Integer.MAX_VALUE?-1:max;
    }
}

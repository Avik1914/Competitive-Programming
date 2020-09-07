/*
Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

(Note also that a translation does not include any kind of rotation.)

What is the largest possible overlap?

Example 1:

Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1 unit.
Notes: 

1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1
*/

class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int r=A.length;
        int max=0;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<r;j++){
                max=Math.max(max,check(A,B,i,j));
                max=Math.max(max,check(B,A,i,j));
            }
        }
        return max;
    }
    
    public int check(int[][] A,int[][] B,int r,int c){
        int noOfOnes=0;
        int br=0;
        int bc=0;
        int res=0;
        for(int i=r;i<A.length;i++){
            bc=0;
            for(int j=c;j<A.length;j++){
                if(B[br][bc++]==1 && A[i][j]==1)
                    res++;
            }
            br++;
        }
        return res;
    }
}

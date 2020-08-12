/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] dp=new int[rowIndex+1];
        int[] res=new int[rowIndex+1];
        List<Integer> fin=new ArrayList();
        dp[0]=1;
        res[0]=1;
        for(int i=1;i<=rowIndex;i++){
            for(int j=0;j<=i;j++){
                if(j==0)
                    res[0]=dp[0];
                else if(j==i)
                    res[j]=dp[j-1];
                else
                    res[j]=dp[j-1]+dp[j];
            }
            for(int k=0;k<=rowIndex;k++)
                dp[k]=res[k];
        }
        for(int k=0;k<=rowIndex;k++)
                fin.add(res[k]);
        return fin;
    }
}

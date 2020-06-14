/*
Find the maximum sum of lengths of non-overlapping subarrays (contiguous elements) with k as the maximum element.
Examples:

 
Input : arr[] = {2, 1, 4, 9, 2, 3, 8, 3, 4} 
        k = 4
Output : 5
{2, 1, 4} => Length = 3
{3, 4} => Length = 2
So, 3 + 2 = 5 is the answer

Input : arr[] = {1, 2, 3, 2, 3, 4, 1} 
        k = 4
Output : 7
{1, 2, 3, 2, 3, 4, 1} => Length = 7

Input : arr = {4, 5, 7, 1, 2, 9, 8, 4, 3, 1}
        k = 4
Ans = 4
{4} => Length = 1
{4, 3, 1} => Length = 3
So, 1 + 3 = 4 is the answer
*/

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] arr={4, 5, 7, 1, 2, 9, 8, 4, 3, 1};
        int k=4;
        int len=arr.length;
        int[] dp=new int[len+1];
        int max=Integer.MIN_VALUE;
        int count=0;
        int res=Integer.MIN_VALUE;
        boolean found=false;
        
        for(int i=0;i<len;i++){
            max=Math.max(arr[i],max);
            if(max<=k){
                count++;
                found=max==k;
            }
            else{
                count=0;
                found=false;
                max=Integer.MIN_VALUE;
            }
            if(found){
                dp[i+1]=Math.max(dp[i],count);
                res=Math.max(res,count+dp[i+1-count]);
            }
            else
                dp[i+1]=dp[i];
           //System.out.println(i+","+dp[i+1]);
        }
        
        System.out.println(res);
       
    }
}

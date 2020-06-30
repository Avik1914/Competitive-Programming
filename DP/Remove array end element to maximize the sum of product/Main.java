/*
Given an array of N positive integers. We are allowed to remove element from either of the two ends i.e from the left side or right side of the array. Each time we remove an element, score is increased by value of element * (number of element already removed + 1). The task is to find the maximum score that can be obtained by removing all the element.

Examples:

Input : arr[] = { 1, 3, 1, 5, 2 }.
Output : 43
Remove 1 from left side (score = 1*1 = 1)
then remove 2, score = 1 + 2*2 = 5
then remove 3, score = 5 + 3*3 = 14
then remove 1, score = 14 + 1*4 = 18
then remove 5, score = 18 + 5*5 = 43.

Input :  arr[] = { 1, 2 }
Output : 5.
*/

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr={1,2,5,8,9,6,2,1,4,5,2,3};
        int len=arr.length;
        int[][] dp=new int[len][len];
        for(int i=0;i<len;i++){
            int u=0;
            int v=i;
            while(v<len){
                int val=(len-v+u);
                if(u==v)
                    dp[u][v]=arr[u]*val;
                else{
                    dp[u][v]=Math.max(arr[u]*val+dp[u+1][v],arr[v]*val+dp[u][v-1]);
                }
                u++;
                v++;
            }
        }
        System.out.println(dfs(arr,0,arr.length-1));
        System.out.println(dp[0][len-1]);
    }
    
    public static int dfs(int[] arr,int lo,int hi){
        if(lo>hi)
            return 0;
        int val=(arr.length-hi+lo);
        return Math.max(arr[lo]*val+dfs(arr,lo+1,hi),arr[hi]*val+dfs(arr,lo,hi-1));
    }
    
}

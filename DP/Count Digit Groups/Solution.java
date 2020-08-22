/*
We are given a string consisting of digits, we may group these digits into sub-groups (but maintaining their original order). The task is to count the number of groupings such that for every sub-group except the last one, the sum of digits in a sub-group is less than or equal to the sum of the digits in the sub-group immediately on its right.

For example, a valid grouping of digits of number 1119 is (1-11-9). Sum of digits in first subgroup is 1, next subgroup is 2, and last subgroup is 9. Sum of every subgroup is less than or equal to its immediate right.

Examples :

Input : "1119"
Output: 7
Sub-groups: [1-119], [1-1-19], [1-11-9], [1-1-1-9],
            [11-19] and [111-9].
Note : Here we have included [1119] in the group and
       the sum of digits is 12 and this group has no 
       immediate right.

Input : "1234"
Output: 6
Sub-groups : [1234], [1-234], [12-34], [1-2-3-4],
             [12-3-4] and [1-2-34]
*/


// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        
        int len=str.length();
        Integer[][] dp=new Integer[len][(9*len)+1];
        char[] arr=str.toCharArray();
        
        System.out.println(dfs(arr,0,0,dp));
        
    }
    
    public static int dfs(char[] arr,int start,int prev,Integer[][] dp){
        if(start>=arr.length)
            return 1;
        if(dp[start][prev]!=null)
            return dp[start][prev];
        int run=0;
        int res=0;
        for(int i=start;i<arr.length;i++){
            run+=arr[i]-'0';
            if(run>=prev)
                res+=dfs(arr,i+1,run,dp);
        }
        dp[start][prev]=res;
        return res;
    }
}

/*
MBLAST - BLAST
#dynamic-programming

Đọc đề đẹp hơn ở: 
https://codeforces.com/group/FLVn1Sc504/contest/274710/problem/N 
https://codeforces.com/group/FLVn1Sc504/contest/274505/problem/K 
English	Vietnamese
There are given two strings, A and B. An expansion of some string X is a string created by adding or inserting any number (zero, one or more) of blanks anywhere in the string, or in the begining or the end of the string. Eg., if the string X is ‘abcbcd’, then the strings 'abcb-cd', '-a-bcbcd-' and 'abcb-cd-' are expansions of the string X (blanks are denoted by the character ‘-‘).

If A1 is an expansion of the string A, and B1 is and expansion of the string B, and if A1 and B1 are of the same length, then we define the distance of the strings A1 and B1 as the sum of the distances of the characters on the same positions in these strings. We define the distance of two characters as the absolute difference of their ASCII codes, except the distance of the blank and another character, which is given (and equal for all characters).

You are to write a program which finds the expansions A1 and B1 of strings A and B, that have the smallest difference.

Input

The first line of the input file consists of the string A, and the second line of string B. They are consisted only of lower case characters of the english alphabet (a-z), and the number of characters in any of the strings is less than or equal to 2000.

The third line consists of an integer K, 1 ≤ K ≤ 100, the distance of the blank and the other characters.

Output

The first only line of the input file should consist of the smallest distance as defined in the text of the task.

Sample

Input:
cmc
snmn
2

output:
10
Input:
koiv
ua
1

output:
5
input: 
mj
jao
4

output:
12
*/

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();
        int d=sc.nextInt();
        
        int m=a.length();
        int n=b.length();
        
        int[][] dp=new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0)
                    dp[i][j]=0;
                else if(i==0)
                    dp[i][j]=d+dp[i][j-1];
                else if(j==0)
                    dp[i][j]=d+dp[i-1][j];
                else{
                    dp[i][j]=d+Math.min(dp[i-1][j],dp[i][j-1]);
                    dp[i][j]=Math.min(dp[i][j],
                                Math.abs(a.charAt(i-1)-b.charAt(j-1))+dp[i-1][j-1]);
                }
            }
        }
        
        System.out.println(dp[m][n]);
    }
}


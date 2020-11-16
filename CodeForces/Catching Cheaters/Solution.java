/*
You are given two strings 𝐴 and 𝐵 representing essays of two students who are suspected cheaters. For any two strings 𝐶, 𝐷 we define their similarity score 𝑆(𝐶,𝐷) as 4⋅𝐿𝐶𝑆(𝐶,𝐷)−|𝐶|−|𝐷|, where 𝐿𝐶𝑆(𝐶,𝐷) denotes the length of the Longest Common Subsequence of strings 𝐶 and 𝐷.

You believe that only some part of the essays could have been copied, therefore you're interested in their substrings.

Calculate the maximal similarity score over all pairs of substrings. More formally, output maximal 𝑆(𝐶,𝐷) over all pairs (𝐶,𝐷), where 𝐶 is some substring of 𝐴, and 𝐷 is some substring of 𝐵.

If 𝑋 is a string, |𝑋| denotes its length.

A string 𝑎 is a substring of a string 𝑏 if 𝑎 can be obtained from 𝑏 by deletion of several (possibly, zero or all) characters from the beginning and several (possibly, zero or all) characters from the end.

A string 𝑎 is a subsequence of a string 𝑏 if 𝑎 can be obtained from 𝑏 by deletion of several (possibly, zero or all) characters.

Pay attention to the difference between the substring and subsequence, as they both appear in the problem statement.

You may wish to read the Wikipedia page about the Longest Common Subsequence problem.

Input
The first line contains two positive integers 𝑛 and 𝑚 (1≤𝑛,𝑚≤5000) — lengths of the two strings 𝐴 and 𝐵.

The second line contains a string consisting of 𝑛 lowercase Latin letters — string 𝐴.

The third line contains a string consisting of 𝑚 lowercase Latin letters — string 𝐵.

Output
Output maximal 𝑆(𝐶,𝐷) over all pairs (𝐶,𝐷), where 𝐶 is some substring of 𝐴, and 𝐷 is some substring of 𝐵.

Examples
inputCopy
4 5
abba
babab
outputCopy
5
inputCopy
8 10
bbbbabab
bbbabaaaaa
outputCopy
12
inputCopy
7 7
uiibwws
qhtkxcn
outputCopy
0
Note
For the first case:

abb from the first string and abab from the second string have LCS equal to abb.

The result is 𝑆(𝑎𝑏𝑏,𝑎𝑏𝑎𝑏)=(4⋅|𝑎𝑏𝑏|) - |𝑎𝑏𝑏| - |𝑎𝑏𝑎𝑏| = 4⋅3−3−4=5.
*/




import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        
        String c=sc.next();
        String d=sc.next();
        
        int[][] dp=new int[n+1][m+1];
        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(c.charAt(i-1)==d.charAt(j-1))
                    dp[i][j]=2+dp[i-1][j-1];
                dp[i][j]=Math.max(dp[i][j],(Math.max(dp[i-1][j],dp[i][j-1])-1));
                ans=Math.max(ans,dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}

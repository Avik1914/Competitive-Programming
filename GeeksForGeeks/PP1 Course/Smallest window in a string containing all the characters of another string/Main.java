/*
Given two strings. Find the smallest window in the first string consisting of all the characters of the second string.

Input:
First line of the input contains an integer T, denoting the number of test cases. Then T test case follows. Each test contains 2 lines having a string S (the first string) and next line contains a string P (the second string).

Output:
Print the smallest window of the string containing all the characters of the text. If such window doesn`t exist or this task can not be done then print -1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function smallestWindow() which takes two string S and P as inputs and returns the smallest window in string S having all the characters of the string P. In case there are multiple such windows of same length, return the one with the least starting index. Return "-1" in case there's no such window present. 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)

Constraints: 
1 <= T <= 100
1 <= |S|, |P| <= 1000

Example:
Input:
2
timetopractice
toc
zoomlazapzo
oza

Output:
toprac
apzo

Explanation:
Testcase 1: toprac is the smallest subset in which toc can be found.
Testcase 2: To find oza in the zoomlazapzo the smallest subset is apzo.
*/

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new solve().smallestWindow(s, t));
		    test--;
		}
	}
}// } Driver Code Ends


class solve
{
    // return the smallest window in S with all the characters of P
    // if no such window exists, return "-1" 
    public static String smallestWindow(String S, String P){
        // Your code here
        char[] sArr=S.toCharArray();
        char[] pArr=new char[256];
        
        
        
        int len1=S.length();
        int len2=P.length();
        
        if(len1<len2)
            return "-1";
        
        for(int i=0;i<len2;i++)
            pArr[P.charAt(i)]++;
            
        int start=0;
        char[] lkp=new char[256];
        int itr=0;
        int s1=0;
        int s2=Integer.MAX_VALUE;
        for(int i=0;i<len1;i++){
            if(lkp[sArr[i]]<pArr[sArr[i]]){
                itr++;
            }
            lkp[sArr[i]]++;
            while(start<=i && lkp[sArr[start]]>pArr[sArr[start]]){
                lkp[sArr[start]]--;
                start++;
            }
            if(itr==len2){
                if(i-start+1<s2-s1){
                    s1=start;
                    s2=i+1;
                    
                }
                //System.out.println(start+","+(i+1));
                lkp[sArr[start++]]--;
                itr--;
            }
        }
        if(s2==Integer.MAX_VALUE)
        return "-1";
        return S.substring(s1,s2);
    }
}

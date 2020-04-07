/*
When Varsha was travelling home, she saw a mysterious villa. Varsha is curious about this strange villa and wants to explore it. When she reached the entry gate, the guard gave her a problem to solve and said that he would allow her to enter the villa only if she solved it.

The guard gave Varsha two integers X
 and K
. Varsha needs to determine whether there is an integer A
 such that it has exactly X
 positive integer divisors and exactly K
 of them are prime numbers.

Varsha found this problem really hard to solve. Can you help her?

Input
The first line of the input contains a single integer T
 denoting the number of test cases. The description of T
 test cases follows.
The first and only line of each test case contains two space-separated integers X
 and K
.
Output
For each test case, print a single line containing one integer: 1
 if a valid integer A
exists or 0
 if it does not exist.

Constraints
1≤T≤103
1≤X,K≤109
Subtasks
Subtask #1 (15 points):

T≤100
K≤2
Subtask #2 (85 points): original constraints

Example Input
1
4 2
Example Output
1
Explanation
Example case 1: A=6
 has X=4
 factors: 1
, 2
, 3
 and 6
. It also has exactly K=2
 prime factors: 2
 and 3.
 */
 
 /* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0){
		    long x=sc.nextInt();
		    long k=sc.nextInt();
		    
		    long val=(long)Math.pow(2,k);
		    
		    if(val>x)
    		    System.out.println(0);
	        else if(val==x)	    
	             System.out.println(1);
	        else{
	            if(k==1)
	                System.out.println(1);
	            else{
	                if(check(x,k))
	                    System.out.println(1);
	                else
	                    System.out.println(0);
	            }
	        }
		}
	}
	
	public static boolean check(long x,long k){
	    int res=0;
	    
	    while(x%2==0){
	        x=x/2;
	        res++;
	    }
	    
	    for(int i=3;i<Math.sqrt(x);i+=2){
	         while(x%i==0){
	             x=x/i;
	             res++;
	         }
	    }
	    if(x>2)
	        res++;
	    return res>=k;
	   }
}


 

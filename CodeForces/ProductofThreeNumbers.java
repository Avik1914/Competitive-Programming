/*
C. Product of Three Numbers
time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
You are given one integer number n. Find three distinct integers a,b,c such that 2≤a,b,c and a⋅b⋅c=n or say that it is impossible to do it.

If there are several answers, you can print any.

You have to answer t independent test cases.

Input
The first line of the input contains one integer t (1≤t≤100) — the number of test cases.

The next n lines describe test cases. The i-th test case is given on a new line as one integer n (2≤n≤109).

Output
For each test case, print the answer on it. Print "NO" if it is impossible to represent n as a⋅b⋅c for some distinct integers a,b,c such that 2≤a,b,c.

Otherwise, print "YES" and any possible such representation.

Example
inputCopy
5
64
32
97
2
12345
outputCopy
YES
2 4 8 
NO
NO
NO
YES
3 5 823 
*/

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0){
            int val=sc.nextInt();
            boolean flag=false;
            for(int i=2;i*i<=val;i++){
                if(val%i==0){
                    int a=val/i;
                    List<Integer> temp=check(a,i);
                    if(temp!=null){
                        System.out.println("Yes");
                        System.out.println(i+" "+temp.get(0)+" "+temp.get(1));
                        flag=true;
                        break;
                    }
                }
            }
            if(!flag)
                System.out.println("No");
        }
    }
    public static List<Integer> check(int val,int not){
        List<Integer> temp=null;
        for(int i=2;i*i<=val;i++){
                if(val%i==0){
                    int a=val/i;
                    if(i!=a && a!=not && i!=not){
                        temp=new ArrayList();
                        temp.add(i);
                        temp.add(a);
                        return temp;
                    }
                }
        }
        return temp;
    }
}

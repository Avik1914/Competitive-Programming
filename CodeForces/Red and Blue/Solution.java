/*
B. Red and Blue
time limit per test2 seconds
memory limit per test512 megabytes
inputstandard input
outputstandard output
Monocarp had a sequence 𝑎 consisting of 𝑛+𝑚 integers 𝑎1,𝑎2,…,𝑎𝑛+𝑚. He painted the elements into two colors, red and blue; 𝑛 elements were painted red, all other 𝑚 elements were painted blue.

After painting the elements, he has written two sequences 𝑟1,𝑟2,…,𝑟𝑛 and 𝑏1,𝑏2,…,𝑏𝑚. The sequence 𝑟 consisted of all red elements of 𝑎 in the order they appeared in 𝑎; similarly, the sequence 𝑏 consisted of all blue elements of 𝑎 in the order they appeared in 𝑎 as well.

Unfortunately, the original sequence was lost, and Monocarp only has the sequences 𝑟 and 𝑏. He wants to restore the original sequence. In case there are multiple ways to restore it, he wants to choose a way to restore that maximizes the value of

𝑓(𝑎)=max(0,𝑎1,(𝑎1+𝑎2),(𝑎1+𝑎2+𝑎3),…,(𝑎1+𝑎2+𝑎3+⋯+𝑎𝑛+𝑚))
Help Monocarp to calculate the maximum possible value of 𝑓(𝑎).

Input
The first line contains one integer 𝑡 (1≤𝑡≤1000) — the number of test cases. Then the test cases follow. Each test case consists of four lines.

The first line of each test case contains one integer 𝑛 (1≤𝑛≤100).

The second line contains 𝑛 integers 𝑟1,𝑟2,…,𝑟𝑛 (−100≤𝑟𝑖≤100).

The third line contains one integer 𝑚 (1≤𝑚≤100).

The fourth line contains 𝑚 integers 𝑏1,𝑏2,…,𝑏𝑚 (−100≤𝑏𝑖≤100).

Output
For each test case, print one integer — the maximum possible value of 𝑓(𝑎).

Example
inputCopy
4
4
6 -5 7 -3
3
2 3 -4
2
1 1
4
10 -3 2 2
5
-1 -2 -3 -4 -5
5
-1 -2 -3 -4 -5
1
0
1
0
outputCopy
13
13
0
0
Note
In the explanations for the sample test cases, red elements are marked as bold.

In the first test case, one of the possible sequences 𝑎 is [6,2,−5,3,7,−3,−4].

In the second test case, one of the possible sequences 𝑎 is [10,1,−3,1,2,2].

In the third test case, one of the possible sequences 𝑎 is [−1,−1,−2,−3,−2,−4,−5,−3,−4,−5].

In the fourth test case, one of the possible sequences 𝑎 is [0,0].
*/

import java.util.*;
public class Main {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int t=sc.nextInt();
        
       while(t-->0){
           int r=sc.nextInt();
           int minSoFar=0;
           int sumSoFar=0;
           int resA=0;
           for(int i=0;i<r;i++){
               int val=sc.nextInt();
               sumSoFar+=val;
               resA=Math.max(sumSoFar-minSoFar,resA);
           }
           minSoFar=0;
           sumSoFar=0;
           int resB=0;
           int b=sc.nextInt();
           for(int i=0;i<b;i++){
               int val=sc.nextInt();
               sumSoFar+=val;
               resB=Math.max(sumSoFar-minSoFar,resB);
           }
           System.out.println(resA+resB);
       }
    }
}


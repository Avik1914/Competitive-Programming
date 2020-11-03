/*
The Delivery Dilemma
time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
Petya is preparing for his birthday. He decided that there would be 𝑛 different dishes on the dinner table, numbered from 1 to 𝑛. Since Petya doesn't like to cook, he wants to order these dishes in restaurants.

Unfortunately, all dishes are prepared in different restaurants and therefore Petya needs to pick up his orders from 𝑛 different places. To speed up this process, he wants to order courier delivery at some restaurants. Thus, for each dish, there are two options for Petya how he can get it:

the dish will be delivered by a courier from the restaurant 𝑖, in this case the courier will arrive in 𝑎𝑖 minutes,
Petya goes to the restaurant 𝑖 on his own and picks up the dish, he will spend 𝑏𝑖 minutes on this.
Each restaurant has its own couriers and they start delivering the order at the moment Petya leaves the house. In other words, all couriers work in parallel. Petya must visit all restaurants in which he has not chosen delivery, he does this consistently.

For example, if Petya wants to order 𝑛=4 dishes and 𝑎=[3,7,4,5], and 𝑏=[2,1,2,4], then he can order delivery from the first and the fourth restaurant, and go to the second and third on your own. Then the courier of the first restaurant will bring the order in 3 minutes, the courier of the fourth restaurant will bring the order in 5 minutes, and Petya will pick up the remaining dishes in 1+2=3 minutes. Thus, in 5 minutes all the dishes will be at Petya's house.

Find the minimum time after which all the dishes can be at Petya's home.

Input
The first line contains one positive integer 𝑡 (1≤𝑡≤2⋅105) — the number of test cases. Then 𝑡 test cases follow.

Each test case begins with a line containing one integer 𝑛 (1≤𝑛≤2⋅105) — the number of dishes that Petya wants to order.

The second line of each test case contains 𝑛 integers 𝑎1…𝑎𝑛 (1≤𝑎𝑖≤109) — the time of courier delivery of the dish with the number 𝑖.

The third line of each test case contains 𝑛 integers 𝑏1…𝑏𝑛 (1≤𝑏𝑖≤109) — the time during which Petya will pick up the dish with the number 𝑖.

The sum of 𝑛 over all test cases does not exceed 2⋅105.

Output
For each test case output one integer — the minimum time after which all dishes can be at Petya's home.

Example
inputCopy
4
4
3 7 4 5
2 1 2 4
4
1 2 3 4
3 3 3 3
2
1 2
10 10
2
10 10
1 2
outputCopy
5
3
2
3
*/

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
          int n=sc.nextInt();
          int[][] lkp=new int[n][2];
          for(int i=0;i<n;i++)
            lkp[i][0]=sc.nextInt();
          
          for(int i=0;i<n;i++)
            lkp[i][1]=sc.nextInt();
            
            Arrays.sort(lkp,(a,b)->a[0]-b[0]);
            int sum=lkp[n-1][1];
            int res=lkp[n-1][0];
            for(int i=n-2;i>=0;i--){
               
                if(sum<=lkp[i][0])
                    res=lkp[i][0];
                else
                    break;
                 sum+=lkp[i][1];
            }
            if(sum<res)
                res=sum;
            System.out.println(res);
        }
    }
}

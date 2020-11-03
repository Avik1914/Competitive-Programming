/*
 Saving the City
time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
Bertown is a city with 𝑛 buildings in a straight line.

The city's security service discovered that some buildings were mined. A map was compiled, which is a string of length 𝑛, where the 𝑖-th character is "1" if there is a mine under the building number 𝑖 and "0" otherwise.

Bertown's best sapper knows how to activate mines so that the buildings above them are not damaged. When a mine under the building numbered 𝑥 is activated, it explodes and activates two adjacent mines under the buildings numbered 𝑥−1 and 𝑥+1 (if there were no mines under the building, then nothing happens). Thus, it is enough to activate any one mine on a continuous segment of mines to activate all the mines of this segment. For manual activation of one mine, the sapper takes 𝑎 coins. He can repeat this operation as many times as you want.

Also, a sapper can place a mine under a building if it wasn't there. For such an operation, he takes 𝑏 coins. He can also repeat this operation as many times as you want.

The sapper can carry out operations in any order.

You want to blow up all the mines in the city to make it safe. Find the minimum number of coins that the sapper will have to pay so that after his actions there are no mines left in the city.

Input
The first line contains one positive integer 𝑡 (1≤𝑡≤105) — the number of test cases. Then 𝑡 test cases follow.

Each test case begins with a line containing two integers 𝑎 and 𝑏 (1≤𝑎,𝑏≤1000) — the cost of activating and placing one mine, respectively.

The next line contains a map of mines in the city — a string consisting of zeros and ones.

The sum of the string lengths for all test cases does not exceed 105.

Output
For each test case, output one integer — the minimum number of coins that the sapper will have to pay.

Example
inputCopy
2
1 1
01000010
5 1
01101110
outputCopy
2
6
Note
In the second test case, if we place a mine under the fourth building and then activate it, then all mines on the field are activated. The cost of such operations is six, 𝑏=1 coin for placing a mine and 𝑎=5 coins for activating.
*/


import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long a=sc.nextLong();
            long b=sc.nextLong();
            boolean activated=false;
            char[] arr=sc.next().toCharArray();
            long res=0;
            long sum=0;
            long prev=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]=='1' && !activated){
                    res+=a;
                    activated=true;
                }else if(arr[i]=='0' && activated){
                    sum+=b;
                    if(sum>a){
                        activated=false;
                        sum=0;
                    }
                }else if(arr[i]=='1' && activated){
                    res+=sum;
                    sum=0;
                }
                
            }
            System.out.println(res);
        }
    }
}

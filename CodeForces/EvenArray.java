/*
B. Even Array
time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
You are given an array 𝑎[0…𝑛−1] of length 𝑛 which consists of non-negative integers. Note that array indices start from zero.

An array is called good if the parity of each index matches the parity of the element at that index. More formally, an array is good if for all 𝑖 (0≤𝑖≤𝑛−1) the equality 𝑖mod2=𝑎[𝑖]mod2 holds, where 𝑥mod2 is the remainder of dividing 𝑥 by 2.

For example, the arrays [0,5,2,1] and [0,17,0,3] are good, and the array [2,4,6,7] is bad, because for 𝑖=1, the parities of 𝑖 and 𝑎[𝑖] are different: 𝑖mod2=1mod2=1, but 𝑎[𝑖]mod2=4mod2=0.

In one move, you can take any two elements of the array and swap them (these elements are not necessarily adjacent).

Find the minimum number of moves in which you can make the array 𝑎 good, or say that this is not possible.

Input
The first line contains a single integer 𝑡 (1≤𝑡≤1000) — the number of test cases in the test. Then 𝑡 test cases follow.

Each test case starts with a line containing an integer 𝑛 (1≤𝑛≤40) — the length of the array 𝑎.

The next line contains 𝑛 integers 𝑎0,𝑎1,…,𝑎𝑛−1 (0≤𝑎𝑖≤1000) — the initial array.

Output
For each test case, output a single integer — the minimum number of moves to make the given array 𝑎 good, or -1 if this is not possible.

Example
inputCopy
4
4
3 2 7 6
3
3 2 6
1
7
7
4 9 2 1 18 3 0
outputCopy
2
1
-1
0
Note
In the first test case, in the first move, you can swap the elements with indices 0 and 1, and in the second move, you can swap the elements with indices 2 and 3.

In the second test case, in the first move, you need to swap the elements with indices 0 and 1.

In the third test case, you cannot make the array good.
*/

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            
            int odd=0;
            int even=0;
            
            for(int i=0;i<n;i++){
                int a1=arr[i]%2;
                int a2=i%2;
                if(a1!=a2){
                    if(a1==1)
                        odd++;
                    else
                        even++;
                }
                    
            }
            if(odd==even)
                System.out.println(odd);
            else
                System.out.println(-1);
        }
    }
}

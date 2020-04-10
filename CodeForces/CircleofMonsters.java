/*
You are playing another computer game, and now you have to slay n monsters. These monsters are standing in a circle, numbered clockwise from 1 to n. Initially, the i-th monster has ai health.

You may shoot the monsters to kill them. Each shot requires exactly one bullet and decreases the health of the targeted monster by 1 (deals 1 damage to it). Furthermore, when the health of some monster i becomes 0 or less than 0, it dies and explodes, dealing bi damage to the next monster (monster i+1, if i<n, or monster 1, if i=n). If the next monster is already dead, then nothing happens. If the explosion kills the next monster, it explodes too, damaging the monster after it and possibly triggering another explosion, and so on.

You have to calculate the minimum number of bullets you have to fire to kill all n monsters in the circle.

Input
The first line contains one integer T (1≤T≤150000) — the number of test cases.

Then the test cases follow, each test case begins with a line containing one integer n (2≤n≤300000) — the number of monsters. Then n lines follow, each containing two integers ai and bi (1≤ai,bi≤1012) — the parameters of the i-th monster in the circle.

It is guaranteed that the total number of monsters in all test cases does not exceed 300000.

Output
For each test case, print one integer — the minimum number of bullets you have to fire to kill all of the monsters.

Example
inputCopy
1
3
7 15
2 14
5 3
outputCopy
6
*/


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t=sc.nextInt();
        
        
        while(t-->0){
            int n=sc.nextInt();
            long[] a=new long[n];
            long[] b=new long[n];
            
            for(int i=0;i<n;i++){
                a[i]=sc.nextLong();
                b[i]=sc.nextLong();
            }
            long sum=0;
            
            for(int i=0;i<n;i++){
                if(i==0)
                    sum+=Math.max(0,a[i]-b[n-1]);
                else
                    sum+=Math.max(0,a[i]-b[i-1]);
            }
            long val=0;
            long res=Long.MAX_VALUE;
            for(int i=0;i<n;i++){
                 if(i==0)
                     val=Math.max(0,a[i]-b[n-1]);
                 else
                     val=Math.max(0,a[i]-b[i-1]);
                res=Math.min(res,a[i]+sum-val);
            }
            out.println(res);
        }
        out.flush();
    }
    
    static class FastReader{BufferedReader br;StringTokenizer st;public FastReader()
	{br=new BufferedReader(new InputStreamReader(System.in));}
	String next() throws IOException{while(st==null||!st.hasMoreElements())
	st=new StringTokenizer(br.readLine());return st.nextToken();}
	int nextInt() throws NumberFormatException, IOException{return Integer.parseInt(next());}
	long nextLong() throws NumberFormatException, IOException{return Long.parseLong(next());}
	String nextLine(){String str="";try{str=br.readLine();}
	catch(IOException e){e.printStackTrace();}return str;}}

}

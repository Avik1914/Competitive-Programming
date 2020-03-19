/*Maximum White Subtree
You are given a tree consisting of n vertices. A tree is a connected undirected graph with n−1 edges. Each vertex v of this tree has a color assigned to it (av=1 if the vertex v is white and 0 if the vertex v is black).

You have to solve the following problem for each vertex v: what is the maximum difference between the number of white and the number of black vertices you can obtain if you choose some subtree of the given tree that contains the vertex v? The subtree of the tree is the connected subgraph of the given tree. More formally, if you choose the subtree that contains cntw white vertices and cntb black vertices, you have to maximize cntw−cntb.

Input
The first line of the input contains one integer n (2≤n≤2⋅105) — the number of vertices in the tree.

The second line of the input contains n integers a1,a2,…,an (0≤ai≤1), where ai is the color of the i-th vertex.

Each of the next n−1 lines describes an edge of the tree. Edge i is denoted by two integers ui and vi, the labels of vertices it connects (1≤ui,vi≤n,ui≠vi).

It is guaranteed that the given edges form a tree.

Output
Print n integers res1,res2,…,resn, where resi is the maximum possible difference between the number of white and black vertices in some subtree that contains the vertex i.


Input:-
9
0 1 1 1 0 0 0 0 1
1 2
1 3
3 4
3 5
2 6
4 7
6 8
5 9

Output:-
2 2 2 2 2 1 1 0 2


This is a problem where DP is used along with DFS traversal.
*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class F1324 {
	static int n;
	static ArrayList<Integer>[] adjList;
	static int[] score;
	static int[] color;
	static boolean[] vis;

	public static int dfs(int u) {
		score[u]=color[u];
		vis[u] = true;
		for (int i : adjList[u]) {
			if (!vis[i]) 
				score[u]+=Math.max(0,dfs(i));
		}
		return score[u];
	}
	
	public static int dfs(int u,int p) {
		if(p>-1){
			if(score[u]>=0)
				score[u]+=Math.max(0,score[p]-score[u]);
			else
				score[u]+=Math.max(0,score[p]);
		}
		for(int i:adjList[u]){
			if(p!=i)
				dfs(i,u);
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
	
		
		n = sc.nextInt();
		color = new int[n];
		
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			color[i] = x == 1 ? 1 : -1;
		}
		
		adjList = new ArrayList[n];
		
		for(int i = 0; i < n; i++)
			adjList[i] = new ArrayList<Integer>();
		
		
		for(int i = 0; i < n - 1; i++) {
			int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		score = new int[n];
		vis = new boolean[n];
		dfs(0);
		dfs(0,-1);
		for(int i = 0; i < n; i++)
			System.out.print(score[i]+" ");
	}
}

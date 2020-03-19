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

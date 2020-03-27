import java.util.ArrayList;


public class Graph {
	 private int vertices;  
	  
     // adjacency list 
	 public ArrayList<Integer>[] adjList; 
	 public int[][] tc; //Transitive closure matrix
	 Graph(int v){
		 vertices=v;
		 adjList=new ArrayList[v];
		 tc=new int[v][v];
		 for(int i=0;i<v;i++){
			 adjList[i]=new ArrayList();
		 }
	 }
	 
	 public void addEdgesUndirected(int u,int v){
		 adjList[u].add(v);
		 adjList[v].add(u);
	 }
	 
	 public void addEdgesDirected(int u,int v){
		 adjList[u].add(v);
	 }
}

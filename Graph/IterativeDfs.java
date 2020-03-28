import java.util.Stack;


public class IterativeDfs {

	public static void main(String[] args) {
		Graph g = new Graph(5); 
        
        g.addEdgesDirected(0, 2); 
        g.addEdgesDirected(0, 3); 
        g.addEdgesDirected(1, 0); 
        g.addEdgesDirected(2, 1); 
        g.addEdgesDirected(3, 4);
        g.addEdgesDirected(4, 0);
        
        boolean[] visited=new boolean[g.vertices];
        for(int i=0;i<g.vertices;i++){
        	if(!visited[i])
        		iterativeDfs(g,0,visited);
        }
	}
	
	public static void iterativeDfs(Graph g,int v,boolean[] visited){
		Stack<Integer> stack=new Stack();
		
		
		visited[v]=true;
		stack.add(v);
		while(!stack.isEmpty()){
			int node=stack.pop();
			System.out.print(node+" ");
			for(int i:g.adjList[node]){
				if(!visited[i]){
					visited[i]=true;
					stack.push(i);
				}
			}
		}
		
		
		
	}

}

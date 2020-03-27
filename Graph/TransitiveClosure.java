
public class TransitiveClosure {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g=new Graph(4);
		
		g.addEdgesDirected(0, 1); 
        g.addEdgesDirected(0, 2); 
        g.addEdgesDirected(1, 2); 
        g.addEdgesDirected(2, 0); 
        g.addEdgesDirected(2, 3); 
        g.addEdgesDirected(3, 3); 
        System.out.println("Transitive closure " + 
                "matrix is"); 
        
        for(int i=0;i<4;i++)
        	dfs(g,i,i);
        
        for(int i=0;i<4;i++){
        	for(int j=0;j<4;j++){
        		System.out.print(g.tc[i][j]+" ");
        	}
        	System.out.println();
        }
	}
	
	public static void dfs(Graph g,int u,int v){
		if(g.tc[u][v]==1)
			return;
		g.tc[u][v]=1;
		for(int i:g.adjList[v]){
			dfs(g,u,i);
		}
	}

}

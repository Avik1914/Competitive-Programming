/* Count all possible paths between two vertices

Count the total number of ways or paths that exist between two vertices in a directed graph. 
These paths doesn’t contain a cycle, the simple enough reason is that a cylce contain infinite 
number of paths and hence they create problem.

*/

import java.util.ArrayList;
import java.util.List;


public class CountNoOfWays {

	public static void main(String[] args) {
		Graph g = new Graph(6); 
        
        g.addEdgesDirected(1, 2); 
        g.addEdgesDirected(1, 5); 
        g.addEdgesDirected(1, 3); 
        g.addEdgesDirected(2, 4); 
        g.addEdgesDirected(2, 5);
        g.addEdgesDirected(3, 5);
        g.addEdgesDirected(4, 3);
        List<List<Integer>> res=new ArrayList();
        backTrack(g,1,5,res,new ArrayList());
        
        for(List<Integer> l:res)
        	System.out.println(l.toString());

	}
	
	public static void backTrack(Graph g,int u,int v,List<List<Integer>> res,List<Integer> perRes){
		if(u==v){
			perRes.add(v);
			res.add(new ArrayList(perRes));
			perRes.remove(new Integer(v));
			return;
		}
		perRes.add(u);
		for(int i:g.adjList[u]){
			backTrack(g,i,v,res,perRes);
		}
		perRes.remove(new Integer(u));
	}

}

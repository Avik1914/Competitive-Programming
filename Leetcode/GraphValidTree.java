/*
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
*/

class Solution {
    Map<Integer,List<Integer>> map;
    int count=0;
    public boolean validTree(int n, int[][] edges) {
        int len=edges.length;
        if(len>n-1)
            return false;
        map=new HashMap();
        
        for(int i=0;i<n;i++)
            map.put(i,new ArrayList());
        
        for(int[] e:edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        return dfs(0,new boolean[n],new boolean[n],-1) && count==n;
    }
    
    public boolean dfs(int start,boolean[] visit,boolean[] recStack,int parent){
        if(recStack[start])
            return false;
        if(visit[start])
            return true;
        recStack[start]=true;
        visit[start]=true;
        count++;
        boolean flag=true;
        for(int s:map.get(start)){
            if(s!=parent){
                if(!dfs(s,visit,recStack,start)){
                    flag=false;
                    break;
                }
            }
        }
        recStack[start]=false;
        return flag;
    }
}

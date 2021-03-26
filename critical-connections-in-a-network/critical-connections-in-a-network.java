class Solution {
    Set<String> points;
    List<Integer>[] g;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        points=new HashSet();
        g=new ArrayList[n];
        for(int i=0;i<n;i++)
            g[i]=new ArrayList();
        
        
        for(List<Integer> li:connections){
            g[li.get(0)].add(li.get(1));
            g[li.get(1)].add(li.get(0));
            points.add(li.get(0)+","+li.get(1));
        }
        List<List<Integer>> res=new ArrayList();
        int[] rank=new int[n];
        Arrays.fill(rank,-1);
        dfs(0,-1,0,rank);
        for(String s:points){
            List<Integer> t=new ArrayList();
            String[] arr=s.split(",");
            t.add(Integer.parseInt(arr[0]));
            t.add(Integer.parseInt(arr[1]));
            res.add(t);
        }
        
        return res;
    }
    
    public int dfs(int v,int p,int pr,int[] rank){
        
        if(rank[v]!=-1){
            if(rank[v]<pr){
                 points.remove(v+","+p);
                 points.remove(p+","+v);
            }
            return rank[v];
        }
        rank[v]=pr;
        int min=pr;
        for(int i:g[v]){
            if(i!=p)
                min=Math.min(min,dfs(i,v,pr+1,rank));
        }
        if(min<pr){
            points.remove(v+","+p);
            points.remove(p+","+v);
        }
        return min;
    }
}
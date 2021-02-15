class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        Map<Integer,Set<Integer>> map=new HashMap();
        int[] degree=new int[n+1];
        for(int i=1;i<=n;i++)
            map.put(i,new HashSet());
        
        for(int[] e:edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }
        int len=edges.length;
        int res=Integer.MAX_VALUE;
        
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                for(int k=j+1;k<=n;k++){
                    if(map.get(i).contains(j) && map.get(j).contains(k) && map.get(k).contains(i))
                        res=Math.min(res,degree[i]+degree[j]+degree[k]-6);
                }
            }
        }
        
        return res==Integer.MAX_VALUE?-1:res;
    }
}
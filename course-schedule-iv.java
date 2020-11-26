class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer,List<Integer>> map=new HashMap();
        Map<Integer,Set<Integer>> cnt=new HashMap();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList());
            cnt.put(i,new HashSet());
            cnt.get(i).add(i);
        }
        int[] indegree=new int[n];
        for(int[] p:prerequisites){
            map.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }
        Queue<Integer> queue=new LinkedList();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        List<Boolean> res=new ArrayList();
        int cnt1=0;
        while(!queue.isEmpty()){
            
            int val=queue.poll();
            for(int i:map.get(val)){
                cnt.get(i).addAll(cnt.get(val));
                if(--indegree[i]==0)
                    queue.add(i);
            }
        }
        for(int[] p:queries){
            if(cnt.get(p[1]).contains(p[0]))
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }    
}

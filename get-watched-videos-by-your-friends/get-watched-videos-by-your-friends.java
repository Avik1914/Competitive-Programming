class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int len=friends.length;
        
        Queue<Integer> queue=new LinkedList();
        queue.add(id);
        boolean[] visit=new boolean[len];
        visit[id]=true;
        Map<String,Integer> map=new HashMap<>();
        while(level-->0){
            int size=queue.size();
            while(size-->0){
                int poll=queue.poll();
                //System.out.println(poll+","+level);
                for(int a:friends[poll]){
                    if(!visit[a]){
                        visit[a]=true;
                        queue.add(a);
                        if(level==0){
                            for(String s:watchedVideos.get(a))
                                map.put(s,map.getOrDefault(s,0)+1);  
                        }
                    }
                    
                }
            }
        }
        List<String> res=new ArrayList(map.keySet());
        Collections.sort(res,(a,b)->map.get(a)==map.get(b)?a.compareTo(b):map.get(a)-map.get(b));
        return res;
    }
}
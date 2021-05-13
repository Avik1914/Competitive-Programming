class Node{
    int[] color;
    int nodeNo;
    
    Node(int noNum){
        this.nodeNo=noNum;
        this.color=new int[26];
    }
}

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        
        Map<Integer,Integer> outdegree=new HashMap<>();
        
        for(int[] e:edges){
            outdegree.put(e[0],outdegree.getOrDefault(e[0],0)+1);
            List<Integer> temp=graph.getOrDefault(e[1],new ArrayList<>());
            temp.add(e[0]);
            graph.put(e[1],temp);
        }
        
        List<Node> list=new ArrayList<>();
        for(int i=0;i<colors.length();i++){
            Node n=new Node(i);
            list.add(n);
        }
         
        
        
        Set<Integer> visited=new HashSet<>();
        Queue<Node> queue=new LinkedList<>();
        int res=0;
        for(int i=0;i<colors.length();i++){
            if(!outdegree.containsKey(i)){
                list.get(i).color[colors.charAt(i)-'a']++;
                res=1;
                queue.add(list.get(i));
                visited.add(i);
            }
        }
        
        
        while(!queue.isEmpty()){
            Node n=queue.poll();
           // System.out.println(n.nodeNo);
            if(graph.containsKey(n.nodeNo)){
            for(int i:graph.get(n.nodeNo)){
                outdegree.put(i,outdegree.get(i)-1);
                for(int j=0;j<26;j++)
                    list.get(i).color[j]=Math.max(list.get(i).color[j],n.color[j]);
                 if(outdegree.get(i)==0 && !visited.contains(i)){
                        list.get(i).color[colors.charAt(i)-'a']++;
                        res=Math.max(res, list.get(i).color[colors.charAt(i)-'a']);
                        queue.add(list.get(i));
                        visited.add(i);
                 }
            }
            }
        }
        
        if(visited.size()!=colors.length())
            return -1;
        
        return res;
        
    }
}
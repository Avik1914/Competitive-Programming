class Solution {
    public String alienOrder(String[] words) {
       
        int len=words.length;
        Map<Character,List<Character>> map=new HashMap();
        int[] indegree=new int[26];
        Arrays.fill(indegree,-1);
        List<Character> temp;
        
         for(int i=0;i<len;i++){
             for(char c:words[i].toCharArray())
                 indegree[c-'a']=0;
         }
        boolean flag=true;
        
        for(int i=0;i<len-1;i++){
            flag=false;
            for(int j=0;j<Math.min(words[i].length(),words[i+1].length());j++){
                char a=words[i].charAt(j);
                char b=words[i+1].charAt(j);
                
                if(a!=b){
                    flag=true;
                    temp=map.getOrDefault(a,new ArrayList());
                    temp.add(b);
                    map.put(a,temp);
                    indegree[b-'a']++;
                    break;
                }
            }
            if(!flag && words[i].length()>words[i+1].length())
                return "";
        }
        Queue<Integer> queue=new LinkedList();
        for(int i=0;i<26;i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        
        StringBuilder sb=new StringBuilder();
        
        while(!queue.isEmpty()){
            int val=queue.poll();
            char c=(char)('a'+val);
            sb.append(c);
            if(map.get(c)!=null){
                for(char d:map.get(c)){
                    if(--indegree[d-'a']==0)
                        queue.add(d-'a');
                }
            }
        }
        for(int i=0;i<26;i++){
            if(indegree[i]>0)
                return "";
        }
        return sb.toString();
    }
}
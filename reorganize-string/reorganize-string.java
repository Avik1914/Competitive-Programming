class Solution {
    public String reorganizeString(String S) {
        int[] lkp=new int[26];
        
        for(char c:S.toCharArray())
            lkp[c-'a']++;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->lkp[b]-lkp[a]);
            
        for(int i=0;i<26;i++){
            if(lkp[i]>0)
                pq.add(i);
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            if(pq.size()>1){
                int a=pq.poll();
                int b=pq.poll();
                sb.append((char)(a+'a'));
                sb.append((char)(b+'a'));
                if(--lkp[a]>0)
                    pq.add(a);
                if(--lkp[b]>0)
                    pq.add(b);
            }else{
                if(lkp[pq.peek()]>1)
                    return "";
                int a=pq.poll();
                sb.append((char)(a+'a'));
            }
        }
        
        return sb.toString();
    }
}
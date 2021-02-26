class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m=languages.length;
        int len=friendships.length;
        Set<Integer>[] langSet=new HashSet[m+1];
        
        for(int i=0;i<m;i++){
            langSet[i+1]=new HashSet();
            for(int l:languages[i])
                langSet[i+1].add(l);
        }
        
        boolean[] okay=new boolean[len];
        int cnt=0;
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<len;j++){
                if(langSet[friendships[j][0]].contains(i) && 
                    langSet[friendships[j][1]].contains(i)){
                        if(!okay[j])
                            cnt++;
                        okay[j]=true;
                    }   
            }
        }
        if(cnt==len)
            return 0;
        cnt=0;
        int res=m;
        for(int i=1;i<=n;i++){
            Set<Integer> set=new HashSet();
            cnt=0;
            for(int j=0;j<len;j++){
                if(!okay[j]){
                     int a=friendships[j][0]; 
                     int b=friendships[j][1];
                     if(langSet[a].contains(i)){
                         if(!set.contains(b)){
                             set.add(b);
                             cnt++;
                         }
                     }else if(langSet[b].contains(i)){
                         if(!set.contains(a)){
                             set.add(a);
                             cnt++;
                         }
                     }else{
                         if(!set.contains(b)){
                             set.add(b);
                             cnt++;
                         }
                         if(!set.contains(a)){
                             set.add(a);
                             cnt++;
                         }
                     }
                }
            }
            res=Math.min(res,cnt);
        }
        return res;
    }
}
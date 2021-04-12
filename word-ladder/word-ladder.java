class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        Set<String> set=new HashSet<>(wordList);
        int levels=1;
        set.remove(beginWord);
        
        
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                String val=queue.poll();
                if(val.equals(endWord))
                    return levels;
                char[] arr=val.toCharArray();
                for(int i=0;i<arr.length;i++){
                    char temp=arr[i];
                    for(char c='a';c<='z';c++){
                        if(c!=temp)
                            arr[i]=c;
                        String str=new String(arr);
                        if(set.contains(str)){
                            queue.add(str);
                            set.remove(str);
                        }
                    }
                    arr[i]=temp;
                }
            }
            levels++;
        }
        
        return 0;
    
    }
    
    
    
}
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
      int len=words.length;
      List<String> res=new ArrayList();
        
        for(int i=0;i<len;i++){
            int cnt=0;
            int start=i;
            while(i<len && cnt+words[i].length()<=maxWidth){
                cnt+=words[i].length();
                cnt++;
                i++;
            }
            i--;
            cnt--;
            buildString(res,words,start,i,maxWidth,cnt);
        }
        return res;
        
    }
    
    public void buildString(List<String> res,String[] words,int s,int e,int m,int c){
        StringBuilder sb=new StringBuilder();
        int noOfSpaces=m-c;
        int noOfWords=e-s;
        
        for(int i=s;i<=e;i++){
            sb.append(words[i]);
            if(i!=e){
                sb.append(" ");
                if(e!=words.length-1){
                    int val=noOfSpaces/noOfWords;
                    if(noOfSpaces%noOfWords!=0)
                        val++;
                    for(int j=0;j<val;j++)
                        sb.append(" ");
                    noOfSpaces-=val;
                    noOfWords--;
                }
            }
            
        }
        for(int j=0;j<noOfSpaces;j++)
            sb.append(" ");
        res.add(sb.toString());
    }
}
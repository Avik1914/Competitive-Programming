class Solution {
    List<String> li;
    public List<String> fullJustify(String[] words, int maxWidth) {
        li=new ArrayList();
        
        int len=words.length;
        int pres=-1;
        int start=0;
        for(int i=0;i<len;i++){
            if(pres+words[i].length()<maxWidth)
                pres+=words[i].length()+1;
            else{
                populateList(words,start,i-1,maxWidth,pres);   
                pres=words[i].length();
                start=i;
            }
        }
        StringBuilder sb=new StringBuilder();
        int extra=maxWidth-pres;
        
        for(int i=start;i<len;i++){
            if(i!=len-1)
                sb.append(words[i]+" ");
            else
                sb.append(words[i]);
        }
        while(extra-->0)
            sb.append(" ");
        li.add(sb.toString());
        
        return li;
    }
    
    public void populateList(String[] words,int start,int end,int mw,int cnt){
        int extra=mw-cnt;
        int val=end-start;
        StringBuilder sb=new StringBuilder();
        
        for(int i=start;i<=end;i++){
            sb.append(words[i]);
            if(i!=end)
                sb.append(" ");
            if(val>0){
                if(extra%val==0){
                    int itr=extra/val;
                    while(itr-->0)
                        sb.append(" ");
                    extra-=(extra/val);
                }else{
                    int itr=(extra/val)+1;
                    while(itr-->0)
                        sb.append(" ");
                    extra-=((extra/val)+1);
                }
                val--;
            }
        }
        while(extra-->0)
            sb.append(" ");
        li.add(sb.toString());
    }
}
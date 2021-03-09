class Solution {
    public int compress(char[] chars) {
        StringBuilder sb=new StringBuilder();
        int len=chars.length;
        
        for(int i=0;i<len;){
            char pres=chars[i];
            int cnt=0;
            while(i<len && chars[i]==pres){
                cnt++;
                i++;
            }
            
            sb.append(pres);
            if(cnt>1)
                sb.append(cnt);
        }
        for(int i=0;i<sb.length();i++)
            chars[i]=sb.charAt(i);
        
        return sb.length();
    }
}
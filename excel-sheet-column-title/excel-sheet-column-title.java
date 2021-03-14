class Solution {
    public String convertToTitle(int colNumber) {
        
        StringBuilder sb=new StringBuilder();
        while(colNumber>0){
            
            if(colNumber<=26){
                sb.insert(0,(char)('A'+colNumber-1));
                break;
            }
            else{
            int val=colNumber%26==0?26:colNumber%26;
            sb.insert(0,(char)('A'+val-1));
            }
            if(colNumber%26==0)
                colNumber--;
            colNumber/=26; 
        }
        return sb.toString();
    }
}
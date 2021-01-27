class Solution {
    public String maximumTime(String time) {
        String[] arr=time.split(":");
        char[] hh=arr[0].toCharArray();
        char[] mm=arr[1].toCharArray();
        
        if(hh[0]=='?'){
            if(hh[1]=='?'){
                hh[0]='2';
                hh[1]='3';
            }else
                hh[0]=hh[1]>'3'?'1':'2';    
        }else if(hh[1]=='?'){
            hh[1]=hh[0]=='2'?'3':'9';
        }
            
        if(mm[0]=='?'){
            if(mm[1]=='?'){
                mm[0]='5';
                mm[1]='9';
            }else
                mm[0]='5';    
            
        }else if(mm[1]=='?'){
            mm[1]='9';
        }
        
        return new String(hh)+":"+new String(mm);
    }
   
}

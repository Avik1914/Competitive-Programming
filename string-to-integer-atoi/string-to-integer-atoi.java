class Solution {
    public int myAtoi(String s) {
        int len=s.length();
        
        char[] arr=s.toCharArray();
        
        int itr=0;
        while(itr<len && arr[itr]==' ')
            itr++;
        if(itr==len)
            return 0;
        int sign=1;
        if(arr[itr]=='-' || arr[itr]=='+'){
            sign=arr[itr]=='-'?-1:1;
            itr++;
        }
        int val=0;
        
        while(itr<len && Character.isDigit(arr[itr])){
            if(val>Integer.MAX_VALUE/10 || (val==Integer.MAX_VALUE/10 && arr[itr]>'7')){
                if(sign==1)
                    return Integer.MAX_VALUE;
                return Integer.MIN_VALUE;
            }
           // System.out.println(val);
            val=val*10+arr[itr++]-'0';
        }
        return val*sign;
    }
}
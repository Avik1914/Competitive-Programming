class Solution {
    public String shortestPalindrome(String s) {
        
        
        String newForm=s+"#"+new StringBuilder(s).reverse().toString();
        int len=newForm.length();
        int[] lps=new int[len];
        
        char[] arr=newForm.toCharArray();
        
        int i=0;
        int j=1;
        
        while(j<len){
            if(arr[j]==arr[i]){
                lps[j]=i+1;
                i++;
                j++;
            }else{
                if(i!=0)
                    i=lps[i-1];
                else{
                    if(arr[i]!=arr[j])
                        j++;    
                }
            }
        }
        
        
        
        return new StringBuilder(s.substring(lps[len-1])).reverse().toString() + s;
    }
}
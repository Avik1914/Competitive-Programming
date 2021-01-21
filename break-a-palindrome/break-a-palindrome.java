class Solution {
    public String breakPalindrome(String palindrome) {
        char[] arr=palindrome.toCharArray();
        int lo=0;
        int len=arr.length;
        int hi=len-1;
        if(len==1)
            return "";
        while(lo<=hi){
            if(arr[lo]==arr[hi]){
                if(arr[lo]=='a' || lo==hi){
                    if(hi-lo<=1){
                        arr[len-1]='b';
                        break;
                    }
                     
                }else{
                    arr[lo]='a';
                    break;
                }
            }
            else{
                return "";
            }
            lo++;
            hi--;
        }
        return new String(arr);
    }
}

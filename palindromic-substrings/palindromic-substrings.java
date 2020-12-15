class Solution {
    public int countSubstrings(String s) {
        int cnt=0;
        char[] arr=s.toCharArray();
        for(int i=0;i<s.length();i++){
            cnt+=growPals(arr,i,i);
            cnt+=growPals(arr,i,i+1);
        }
        return cnt;
    }
    
    public int growPals(char[] arr,int lo,int hi){
        int res=0;
        while(lo>=0 && hi<arr.length && arr[lo]==arr[hi]){
            lo--;
            hi++;
            res++;
        }
        return res;
    }
}

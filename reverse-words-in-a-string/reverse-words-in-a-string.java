class Solution {
    public String reverseWords(String s) {
       char[] arr=s.toCharArray();
       reverse(arr,0,arr.length-1);
       reverseWords(arr);
       return cleanSpace(arr);
    }
    
    public String cleanSpace(char[] arr){
        int i=0,j=0;
        
        while(j<arr.length){
            while(j<arr.length && arr[j]==' ')
                j++;
            while(j<arr.length && arr[j]!=' ')arr[i++]=arr[j++];
            while (j < arr.length && arr[j] == ' ') j++;
            if(j<arr.length)arr[i++]=' ';
                
        }
        return new String(arr).substring(0,i);
    }
    
    public void reverse(char[] arr,int lo,int hi){
        while(lo<hi){
            char c=arr[lo];
            arr[lo]=arr[hi];
            arr[hi]=c;
            lo++;
            hi--;
        }
    }
    
    public void reverseWords(char[] arr){
        int i=0,j=0;
        while(j<arr.length){
            while(i<j || i<arr.length && arr[i]==' ') i++;
            while(j<i || j<arr.length && arr[j]!=' ') j++;
            reverse(arr,i,j-1);
        }
    }
}
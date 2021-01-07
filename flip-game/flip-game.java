class Solution {
    
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res=new ArrayList();
        char[] arr=s.toCharArray();
        int len=arr.length;
        
        for(int i=0;i<len-1;i++){
            if(arr[i]=='+' && arr[i+1]=='+'){
                arr[i]='-';
                arr[i+1]='-';
                res.add(new String(arr));
                arr[i]='+';
                arr[i+1]='+';
            }
        }
        
        return res;
    }
​
}

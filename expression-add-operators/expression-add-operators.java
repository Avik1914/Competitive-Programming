class Solution {
    List<String> res;
    long target;
    public List<String> addOperators(String num, int target) {
        char[] arr=num.toCharArray();
        this.target=target;
        res=new ArrayList();
        backtrack(arr,0,0,"",0);
        return res;
    }
    
     public void backtrack(char[] arr,int start,long val,String perRes,long prevVal){
        if(start>=arr.length){
            if(val==target)
                res.add(new String(perRes));
        }
       
        long temp=0;
        for(int i=start;i<arr.length;i++){
            
            temp=temp*10+arr[i]-'0';
            if(start==0){
                backtrack(arr,i+1,val+temp,perRes+temp,temp);    
            }else{
                backtrack(arr,i+1,val+temp,perRes+"+"+temp,temp);
                backtrack(arr,i+1,val-temp,perRes+"-"+temp,-temp);
                backtrack(arr,i+1,prevVal*temp+(val-prevVal),perRes+"*"+temp,temp*prevVal);
            }
            if(arr[start]=='0')
                break;
        }
     }
}

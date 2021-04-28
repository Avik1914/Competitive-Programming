class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        
        List<Integer> res=new ArrayList<>();
        
        for(int i=0;i<input.length();i++){
            char c=input.charAt(i);
            
            if(c=='+' || c=='-' || c=='*'){
                List<Integer> first=diffWaysToCompute(input.substring(0,i));
                List<Integer> second=diffWaysToCompute(input.substring(i+1));
                
                for(int x:first){
                    for(int y:second){
                        if(c=='-')
                            res.add(x-y);
                        else if(c=='+')
                            res.add(x+y);
                        else
                            res.add(x*y);
                    }
                }
            }
        }
        if(res.isEmpty())
            res.add(Integer.parseInt(input));
        return res;
    }
}
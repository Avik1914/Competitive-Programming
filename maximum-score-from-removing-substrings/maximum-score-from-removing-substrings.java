class Solution {
    public int maximumGain(String s, int x, int y) {
        StringBuilder sb=new StringBuilder();
        char[] arr=s.toCharArray();
        int len=arr.length;
        int res=0;
        int cnt=0;
        Stack<Integer> stack=new Stack();
        
        for(int i=0;i<len;i++){
            if(x>y){
                if(!stack.isEmpty() && arr[stack.peek()]=='a' && arr[i]=='b'){
                    stack.pop();
                    res+=x;
                }
                else
                    stack.push(i);
            }else{
                if(!stack.isEmpty() && arr[stack.peek()]=='b' && arr[i]=='a'){
                    stack.pop();
                    res+=y;
                }
                else
                    stack.push(i);
            }
        }
        List<Integer> li=new ArrayList(stack);
        stack.clear();
        
        for(int i:li){
            if(!stack.isEmpty() && arr[stack.peek()]=='a' && arr[i]=='b'){
                res+=x;
                stack.pop();
            }
            else if(!stack.isEmpty() && arr[stack.peek()]=='b' && arr[i]=='a'){
                res+=y;
                stack.pop();
            }else
                stack.push(i);
        }
        
        
        return res; 
        
    }
}

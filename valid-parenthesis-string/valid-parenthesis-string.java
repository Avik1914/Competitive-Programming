class Solution {
    public boolean checkValidString(String s) {
        char[] arr=s.toCharArray();
        Stack<Integer> stack1=new Stack();
        Stack<Integer> stack2=new Stack();
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='(')
                stack1.push(i);
            else if(arr[i]=='*')
                stack2.push(i);
            else{
                if(stack1.size()>0)
                    stack1.pop();
                else if(stack2.size()>0)
                    stack2.pop();
                else
                    return false;
            }
        }
        
        while(!stack1.isEmpty()){
            if(!stack2.isEmpty() && stack2.peek()>stack1.peek()){
                stack1.pop();
                stack2.pop();
            }else
                break;
                
        }
        
        return stack1.isEmpty();
    }
}

class Solution {
    public int scoreOfParentheses(String S) {
           Stack<String> stack=new Stack();
          
        for(char c:S.toCharArray()){
            if(c=='(')
                stack.push("(");
            else{
                if(stack.peek().equals("(")){
                    stack.pop();
                    stack.push("1");
                }else{
                    int val=0;
                    while(!stack.peek().equals("("))
                        val+=Integer.parseInt(stack.pop());
                    stack.pop();
                    stack.push(String.valueOf(2*val));
                }
            }
        }
        int res=0;
        while(!stack.isEmpty())
            res+=Integer.parseInt(stack.pop());
        return res;
    }
}
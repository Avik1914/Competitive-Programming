class Solution {
    public int calculate(String s) {
        char[] arr=s.toCharArray();
        Stack<Integer> operands=new Stack<>();
        Stack<Character> operators=new Stack<>();
        int val=-1;
        boolean flag=false;
        for(int i=0;i<arr.length;i++){
            char c=arr[i];
            if(c==' ')
                continue;
            if(c>='0' && c<='9'){
                flag=true;
                val=0;
                while(i<arr.length && Character.isDigit(arr[i]))
                    val=val*10+arr[i++]-'0';
                i--;
                operands.push(val);
            }else if(c==')' || c=='('){
                
                if(c=='('){
                    flag=false;
                    operators.push(c);
                }
                else{
                    flag=true;
                    while(operators.peek()!='('){
                        operands.push(calc(operators.pop(),
                                         operands.pop(),operands.pop()));
                    }
                    operators.pop();
                }
                
            }
            else{
                if(!flag)
                    operands.push(0);
                 while(!operators.isEmpty() 
                       && precedence(c,operators.peek())){
                     operands.push(calc(operators.pop(),
                                         operands.pop(),operands.pop()));
                 }
                operators.push(c);
                flag=false;
            }
        }
         while(!operators.isEmpty())
                operands.push(calc(operators.pop(),
                                operands.pop(),operands.pop()));
        return operands.pop();
        
    }
    
    public int calc(char c,int a,int b){
        if(c=='+')
            return a+b;
        else 
            return b-a;
    }
    
    public boolean precedence(
                           char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
            (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
}
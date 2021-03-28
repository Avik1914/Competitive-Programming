class Solution {
    public int calculate(String s) {
        char[] arr=s.toCharArray();
        Stack<Integer> operands=new Stack<>();
        Stack<Character> operators=new Stack<>();
        int val=-1;
        
        for(int i=0;i<arr.length;i++){
            char c=arr[i];
            if(c==' ')
                continue;
            if(c>='0' && c<='9'){
                val=0;
                while(i<arr.length && Character.isDigit(arr[i]))
                    val=val*10+arr[i++]-'0';
                i--;
                operands.push(val);
            }else{
                 while(!operators.isEmpty() 
                       && precedence(c)<=precedence(operators.peek())){
                     operands.push(calc(operators.pop(),
                                         operands.pop(),operands.pop()));
                 }
                operators.push(c);
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
        else if(c=='-')
            return b-a;
        else if(c=='/')
            return b/a;
        else
            return a*b;
    }
    
    public int precedence(char c){
        if(c=='+' || c=='-')
            return 1;
        return 2;
    }
}
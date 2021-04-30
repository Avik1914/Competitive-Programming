class Solution {
    public int calculate(String s) {
        Stack<Integer> operand=new Stack<>();
        Stack<Character> operator=new Stack<>();
        
        char[] arr=s.toCharArray();
        boolean flag=false;
        for(int i=0;i<arr.length;i++){
            char c=arr[i];
            if(c==' ')
                continue;
            else if(Character.isDigit(c)){
                flag=true;
                int val=0;
                while(i<arr.length && Character.isDigit(arr[i])){
                    val=val*10+arr[i]-'0';
                    i++;
                }
                i--;
                operand.add(val);
            }else if(arr[i]=='('){
                flag=false;
                operator.push(arr[i]);
            }else if(arr[i]==')'){
                while(operator.peek()!='(')
                    operand.push(calc(operand.pop(),operand.pop(),operator.pop()));
                operator.pop();
            }else{
                if(!flag)
                    operand.push(0);
                while(!operator.isEmpty() && precedence(operator.peek(),arr[i]))
                    operand.push(calc(operand.pop(),operand.pop(),operator.pop()));
                operator.push(arr[i]);
            }
        }
         while(!operator.isEmpty())
             operand.push(calc(operand.pop(),operand.pop(),operator.pop()));
             
        return operand.pop();
    } 
    
    
    
    public int calc(int a,int b,char c){
        if(c=='+')
            return b+a;
        else if(c=='-')
            return b-a;
        else if(c=='*')
            return b*a;
        else 
            return b/a;
    }
    
    public boolean precedence(char a,char b){
        if(a=='(' || a=='(' || b==')' || b=='(')
            return false;
        if((a=='+' || a=='-') && (b=='*' || b=='/'))
            return false;
        return true;
    }
}
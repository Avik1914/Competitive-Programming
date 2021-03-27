class Solution {
    public String fractionAddition(String expression) {
        List<Long> nums=new ArrayList();
        List<Long> deno=new ArrayList();
        
        int sign=1;
        
        long val=0;
        for(char c:expression.toCharArray()){
            if(c=='/'){
                nums.add(val*sign);
                val=0;
                sign=1;
            }else if(c=='+' || c=='-'){
                sign=c=='+'?1:-1;
                if(!nums.isEmpty())
                deno.add(val);
                val=0;
            }else
                val=val*10+c-'0';    
        }
        deno.add(val);
        if(nums.size()==1)
            return expression;
        long g=deno.get(0);
        long mul=g;
        for(int i=1;i<deno.size();i++){
            g=gcd(g,deno.get(i));
            mul*=deno.get(i);
        }
        
        long lcm=mul/g;
        long res=0;
        for(int i=0;i<nums.size();i++)
            res+=nums.get(i)*(lcm/deno.get(i));
        
        StringBuilder sb=new StringBuilder();
        if(res<0)
            sb.append("-");
        res=Math.abs(res);
        g=gcd(res,lcm);
        sb.append(res/g+"/"+lcm/g);
        return sb.toString();
    }
    
    public long gcd(long a,long b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}
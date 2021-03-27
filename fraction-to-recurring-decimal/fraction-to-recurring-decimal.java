class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0)
            return "0";
        StringBuilder sb=new StringBuilder();
        
        if((numerator<0 ^ denominator<0))
            sb.append("-");
        long num=(long) Math.abs(Long.valueOf(numerator));
        long den=(long)Math.abs(Long.valueOf(denominator));
        sb.append(num/den);
        if(num%den==0)
            return sb.toString();
        num=num%den;
        sb.append(".");
        Map<Long,Integer> map=new HashMap();
        int itr=sb.length();
        while(!map.containsKey(num) && num!=0){
            map.put(num,itr);
            num*=10l;
            sb.append(num/den);
            num=num%den;
            itr++;
        }
        if(num!=0){
             sb.insert(map.get(num),"(");
             sb.append(")");
        }
        return sb.toString();
    }
}
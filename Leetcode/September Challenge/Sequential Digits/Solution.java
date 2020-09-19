/*
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 

Constraints:

10 <= low <= high <= 10^9
*/

class Solution {
    List<Integer> res;
    int lo,hi;
    public List<Integer> sequentialDigits(int low, int high) {
        lo=low;hi=high;
        res=new ArrayList();
        for(char c='0';c<='9';c++)
            compute(new StringBuilder(),c);
        Collections.sort(res);
        return res;
    }
    
    public void compute(StringBuilder sb,char prev){
        if(!Character.isDigit(prev))
            return;
        if(sb.length()>0){
            int val=Integer.parseInt(sb.toString());
            if(val>=lo && val<=hi)
                res.add(val);
            if(prev=='9' || val>=hi)
                return;
        }
        
        //System.out.println(prev);
        sb.append(++prev);
        compute(sb,prev);
        sb.setLength(sb.length()-1);
    }
    
    
}

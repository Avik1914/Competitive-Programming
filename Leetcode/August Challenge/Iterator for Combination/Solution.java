/*
Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
 

Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 

Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.
*/


class CombinationIterator {
    int itr=0;
    List<String> lkp;
    Map<String,List<String>> dp;
    public CombinationIterator(String characters, int combinationLength) {
        itr=0;
        dp=new HashMap();
        lkp=dfs(characters.toCharArray(),combinationLength,0);
    }
    
    public List<String> dfs(char[] chr,int len,int start){
        
        String str=start+","+len;
        if(dp.get(str)!=null)
            return dp.get(str);
        List<String> res=new ArrayList();
        if(start>=chr.length)
            return res;
        if(len==1){
            for(int i=start;i<chr.length;i++)
                res.add(""+chr[i]);
            dp.put(start+","+len,res);
            return res;
        }
        for(String s:dfs(chr,len-1,start+1))
            res.add(chr[start]+""+s);
        for(String s:dfs(chr,len,start+1))
            res.add(""+s);
        dp.put(str,res);
        return res;
    }
    
    public String next() {
        return lkp.get(itr++);
    }
    
    public boolean hasNext() {
        return lkp.size()>itr;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

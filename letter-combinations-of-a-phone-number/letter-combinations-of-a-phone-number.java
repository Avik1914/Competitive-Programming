class Solution {
    String[] arr;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        arr=new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res=new ArrayList();
        if(digits.length()==0)
            return res;
        dfs(digits.toCharArray(),0,new StringBuilder());
        return res;
    }
    
    public void dfs(char[] dig,int start,StringBuilder sb){
        if(start>=dig.length){
            res.add(sb.toString());
            return;
        }
        int x=dig[start]-'0';
        for(char c:arr[x].toCharArray()){
            sb.append(c);
            dfs(dig,start+1,sb);
            sb.setLength(sb.length()-1);
        }
    }
}
class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList();
        dfs(0,0,new StringBuilder(),n);
        return res;
    }
    
    public void dfs(int l,int r,StringBuilder sb,int n){
        if(r==n && l==n){
            res.add(new String(sb.toString()));
            return;
        }
        if(l>r){
            sb.append(")");
            dfs(l,r+1,sb,n);
            sb.setLength(sb.length()-1);
        }
        if(l<n){
            sb.append("(");
            dfs(l+1,r,sb,n);
            sb.setLength(sb.length()-1);
        }
    }
}
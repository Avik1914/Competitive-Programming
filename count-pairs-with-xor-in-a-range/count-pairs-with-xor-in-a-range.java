class Trie{
    Trie left;
    Trie right;
    int cnt=0;
}
class Solution {
    public int countPairs(int[] nums, int low, int high) {
        Trie root=new Trie();
        int res=0;
        for(int n:nums){
            res+=smallCount(root,n,high+1)-smallCount(root,n,low);
            insert(n,root);
        }
        return res;
    }
    public int smallCount(Trie root,int n,int k){
        int res=0;
        for(int i=31;i>=0;i--){
            if(root==null)
                return res;
            int x=(n>>i) & 1;
            if((k & (1<<i))==0){
                if(x==1)
                    root=root.right;
                else
                    root=root.left;
            }else{
                
                if(x==1){
                    if(root.right!=null)
                        res+=root.right.cnt;
                    root=root.left;
                }
                else{
                    if(root.left!=null)
                        res+=root.left.cnt;
                    root=root.right;
                }
            }
        }
        return res;
    }
    public void insert(int n,Trie root){
        
        for(int i=31;i>=0;i--){
            if((n & (1<<i))==0){
                if(root.left==null){
                    root.left=new Trie();
                }
                
                root=root.left;
                root.cnt++;
            }else{
                if(root.right==null)
                    root.right=new Trie();
                root=root.right;
                root.cnt++;
            }
        }
    }
}
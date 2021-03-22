class Trie{
    Trie left;
    Trie right;
}
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);   
        
        int len=nums.length;
        int[][] qArr=new int[queries.length][3];
        
        for(int i=0;i<queries.length;i++){
            qArr[i][0]=queries[i][0];
            qArr[i][1]=queries[i][1];
            qArr[i][2]=i;
        }
        Arrays.sort(qArr,(a,b)->a[1]-b[1]);
        Trie root=new Trie();
        
        int itr=0;
        int[] res=new int[queries.length];
        for(int[] q:qArr){
            
            while(itr<len && nums[itr]<=q[1]){
                Trie temp=root;
                for(int i=31;i>=0;i--){
                    if((nums[itr] & (1<<i))==0){
                        if(temp.left==null)
                            temp.left=new Trie();
                        temp=temp.left;
                    }else{
                        if(temp.right==null)
                            temp.right=new Trie();
                        temp=temp.right;
                    }
                }
                itr++;
            }
            if(itr==0){
                res[q[2]]=-1;
                continue;
            }
            Trie temp=root;
            int xor=0;
            for(int i=31;i>=0;i--){
                if((q[0] & (1<<i))==0){
                    if(temp.right!=null){
                        temp=temp.right;
                        xor+=(1<<i);
                    }else
                        temp=temp.left;
                }else{
                    if(temp.left!=null){
                        temp=temp.left;
                        xor+=(1<<i);
                    }else
                        temp=temp.right;
                }
            }
            res[q[2]]=xor;
        }
        
        return res;
    }
}
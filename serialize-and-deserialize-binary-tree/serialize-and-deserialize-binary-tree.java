/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int itr=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       if(root==null)
           return "N";
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(itr<data.length() && data.charAt(itr)==',')
            itr++;
        if(itr>=data.length() || data.charAt(itr)=='N'){
            itr++;
            return null;
        }
       
        int val=0;
        int sign=1;
        if(data.charAt(itr)=='-'){
            sign=-1;
            itr++;
        }
        while(Character.isDigit(data.charAt(itr)))
            val=val*10+data.charAt(itr++)-'0';
        val*=sign;
        TreeNode root=new TreeNode(val);
        root.left=deserialize(data);
        root.right=deserialize(data);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
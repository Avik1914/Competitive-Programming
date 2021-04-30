/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> res=new ArrayList<>();
        dfs(root,res);
        return String.join(",",res);
    }
    
    public void dfs(Node root,List<String> res){
        if(root==null)
            return;
        res.add(""+root.val);
        res.add(""+root.children.size());
        for(Node child:root.children)
            dfs(child,res);
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.isEmpty())
            return null;
        Queue<String> queue=new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }
    
    public Node dfs(Queue<String> queue){
        if(queue.isEmpty())
            return null;
        Node n=new Node(Integer.parseInt(queue.poll()));
        int child=Integer.parseInt(queue.poll());
        n.children=new ArrayList<>();
        
        for(int i=0;i<child;i++){
            n.children.add(dfs(queue));
        }
        return n;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
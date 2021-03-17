class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack();
        int len=heights.length;
        int res=0;
        
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int val=stack.pop();
                int width=stack.isEmpty()?i:i-stack.peek()-1;
                res=Math.max(res,width*heights[val]);
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
                int val=stack.pop();
                int width=stack.isEmpty()?len:len-stack.peek()-1;
                res=Math.max(res,width*heights[val]);
        }
        
        return res;
    }
}
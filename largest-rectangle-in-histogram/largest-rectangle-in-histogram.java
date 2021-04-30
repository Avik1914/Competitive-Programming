class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int len=heights.length;
        int res=0;
        
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                int start=stack.pop();
                int width=stack.isEmpty()?i:i-stack.peek()-1;
                res=Math.max(res,width*heights[start]);
            }
            stack.push(i);
        }
        
         while(!stack.isEmpty()){
                int start=stack.pop();
                int width=stack.isEmpty()?len:len-stack.peek()-1;
                res=Math.max(res,width*heights[start]);
            }
        
        return res;
    }
}
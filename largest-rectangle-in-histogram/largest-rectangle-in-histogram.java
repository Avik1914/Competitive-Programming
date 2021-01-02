class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack();
        int len=heights.length;
        int val=0;
        
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                int popped=stack.pop();
                int start=stack.isEmpty()?0:stack.peek()+1;
                val=Math.max(val,heights[popped]*(i-start));
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
                int popped=stack.pop();
                int start=stack.isEmpty()?0:stack.peek()+1;
                val=Math.max(val,heights[popped]*(len-start));
        }
        return val;
    }
}

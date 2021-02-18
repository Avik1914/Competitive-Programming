class Solution {
    public int largestRectangleArea(int[] heights) {
        int len=heights.length;
        Stack<int[]> stack=new Stack();
        int res=0;
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                int[] val=stack.pop();
                int left=stack.isEmpty()?-1:stack.peek()[0];
                int right=i;
                res=Math.max(res,val[1]*(right-left-1));
            }
            stack.push(new int[]{i,heights[i]});
        }
        
        while(!stack.isEmpty()){
                int[] val=stack.pop();
                int left=stack.isEmpty()?-1:stack.peek()[0];
                int right=len;
                res=Math.max(res,val[1]*(right-left-1));
        }
        
        return res;
    }
}
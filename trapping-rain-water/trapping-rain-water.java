class Solution {
    public int trap(int[] height) {
        int len=height.length;
         
        Stack<Integer> stack=new Stack();
        int max=0;
        int res=0;
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && height[stack.peek()]<=height[i]){
                int val=height[stack.pop()];
                if(!stack.isEmpty())
                    res+=(Math.min(height[i],height[stack.peek()])-val)
                            * (i-stack.peek()-1);
            }
            stack.push(i);
        }
        
        return res;
    }
}
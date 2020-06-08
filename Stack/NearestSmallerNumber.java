/*
Find the nearest smaller numbers on left side in an array
Given an array of integers, find the nearest smaller number for every element such that the smaller element is on left side.
Examples:

Input:  arr[] = {1, 6, 4, 10, 2, 5}
Output:         {_, 1, 1,  4, 1, 2}
First element ('1') has no element on left side. For 6, 
there is only one smaller element on left side '1'. 
For 10, there are three smaller elements on left side (1,
6 and 4), nearest among the three elements is 4.

Input: arr[] = {1, 3, 0, 2, 5}
Output:        {_, 1, _, 0, 2}
Expected time complexity is O(n).
*/

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0){
            int n=sc.nextInt();
            int[] nums=new int[n];
            for(int i=0;i<n;i++)
                nums[i]=sc.nextInt();
            Stack<Integer> stack=new Stack();
            for(int i=0;i<n;i++){
                while(!stack.isEmpty() && nums[stack.peek()]>nums[i])
                    nums[stack.pop()]=nums[i];
                if(stack.isEmpty())
                    System.out.print("-1 ");
                else
                    System.out.print(nums[stack.peek()]+" ");
                stack.push(i);
            }
            
        
        }
    }
}

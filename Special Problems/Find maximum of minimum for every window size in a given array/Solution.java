/*
Problem Description
Given an integer array of size n, find the maximum of the minimum’s of every window size in the array. Note that window size varies from 1 to n.

Example:

Input: arr[] = {10, 20, 30, 50, 10, 70, 30}
Output: 70, 30, 20, 10, 10, 10, 10

The first element in the output indicates the maximum of minimums of all
windows of size 1.
Minimums of windows of size 1 are {10}, {20}, {30}, {50}, {10},
{70} and {30}. Maximum of these minimums is 70

The second element in the output indicates the maximum of minimums of all
windows of size 2.
Minimums of windows of size 2 are {10}, {20}, {30}, {10}, {10},
and {30}. Maximum of these minimums is 30




The third element in the output indicates the maximum of minimums of all
windows of size 3.
Minimums of windows of size 3 are {10}, {20}, {10}, {10} and {10}.
Maximum of these minimums is 20

Similarly, other elements of output are computed.
*/

/*
Description of the approach
This is stack related problem where we need to construct two preprocessing arrays with the left and right smaller elements details. As stack can easily solve the problem of finding the Next Smaller Element, So it can be rightly used in this problem.

So this will be a two step algorithm ,

1st Step :- In this step the preprocessing arrays will be created using a stack where the details of left and right smaller elements will be present.
2nd Step :- In this step the we can calculate the window for each element where it is the smallest number and then we can compare its value with the answer already           present in the output array(initialized with zero), if this value is larger than the answer then we shall replace this value for that window.
*/

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] arr={10,20,30,50,10,70,30};
        int[] ans=compute(arr,arr.length);
        
        for(int a:ans)
            System.out.print(a+" ");
        System.out.println();
    }
    
    public static int[] compute(int[] arr,int n){
        Stack<Integer> stack=new Stack();
        int[] left=new int[n];
        int[] right=new int[n];
        Arrays.fill(right,n);
        Arrays.fill(left,-1);
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i])
                right[stack.pop()]=i;
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i])
                left[stack.pop()]=i;
            stack.push(i);
        }
        
        for(int i=0;i<n;i++){
            //System.out.println(right[i]+","+left[i]);
            ans[right[i]-left[i]-2]=Math.max(ans[right[i]-left[i]-2],arr[i]);
        }
        int prev=0;
        for(int i=n-1;i>=0;i--){
            if(ans[i]==0)
                ans[i]=prev;
            prev=ans[i];
        }
        
        return ans;
    }
}

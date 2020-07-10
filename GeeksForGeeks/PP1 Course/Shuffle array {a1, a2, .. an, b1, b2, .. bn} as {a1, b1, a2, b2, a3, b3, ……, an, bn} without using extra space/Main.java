/*
Given an array of 2n elements in the following format { a1, a2, a3, a4, ….., an, b1, b2, b3, b4, …., bn }. The task is shuffle the array to {a1, b1, a2, b2, a3, b3, ……, an, bn } without using extra space.

Examples :

Input : arr[] = { 1, 2, 9, 15 }
Output : 1 9 2 15

Input :  arr[] = { 1, 2, 3, 4, 5, 6 }
Output : 1 4 2 5 3 6
*/

import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] arr=new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        int n=11;
        
        for(int i=1;i<n;i+=2){
            int next=i;
            int value=arr[next];
            do{               
                if(next<n){
                    int temp=arr[2*next];
                    arr[2*next]=value;
                    next=2*next;
                    value=temp;
                }else{
                    int val=((next%n)*2)+1;
                    int temp=arr[val];
                    arr[val]=value;
                    next=val;
                    value=temp;
                }
                //System.out.println(next);
            }while(next!=i);
        }
        for(int a:arr)
            System.out.print(a+" ");
        
    }
}

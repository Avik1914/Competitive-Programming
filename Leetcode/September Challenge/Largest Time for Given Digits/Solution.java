/*
Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

 

Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""
 

Note:

A.length == 4
0 <= A[i] <= 9
*/

class Solution {
    public String largestTimeFromDigits(int[] A) {
        int val=-1;
        int val1=-1;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i!=j && (A[i]*10+A[j])<24){
                    
                    for(int k=0;k<4;k++){
                        if(k!=i && k!=j){
                            
                            int hour=(A[i]*10+A[j]);
                            int min=(A[k]*10+A[6-i-j-k]);
                            
                            if(min<60){
                                if(val<hour){
                                    val=hour;
                                    val1=min;
                                }else if(val==hour)
                                    val1=Math.max(min,val1);
                            }
                        }
                    }
                }
            }
        }
        
        if(val==-1 || val1==-1)
            return "";
        StringBuilder sb=new StringBuilder();
        if(val==0)
            sb.append("00");
        else if(val>9)
            sb.append(""+val);
        else
            sb.append("0"+val);
        sb.append(":");
        if(val1==0)
            sb.append("00");
        else if(val1>9)
            sb.append(""+val1);
        else
            sb.append("0"+val1);
        return sb.toString();
    }
}

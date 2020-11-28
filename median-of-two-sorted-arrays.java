class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       if(nums1.length>nums2.length)
           return findMedianSortedArrays(nums2,nums1);
        
        int len1=nums1.length;
        int len2=nums2.length;
        boolean isEven=(len1+len2)%2==0;
        int lo=0;
        int hi=len1;
        int a=0,b=0,c=0,d=0;
        
        while(lo<=hi){
            int partitionX=(lo+hi)/2;
            int partitionY=((len1+len2+1)/2)-partitionX;
            a=partitionX==0?Integer.MIN_VALUE:nums1[partitionX-1];
            b=partitionX==len1?Integer.MAX_VALUE:nums1[partitionX];
            c=partitionY==0?Integer.MIN_VALUE:nums2[partitionY-1];
            d=partitionY==len2?Integer.MAX_VALUE:nums2[partitionY];
            
            if(a<=d && c<=b){
                //System.out.println(a+","+b);
                if(isEven)
                    return (double)(Math.max(a,c)+Math.min(b,d))/2;
                else
                    return (double)(Math.max(a,c));
            }else if(a>d)
                hi=partitionX-1;
            else
                lo=partitionX+1;
                
            
            
        }
        
        return -1.0;
    }
}

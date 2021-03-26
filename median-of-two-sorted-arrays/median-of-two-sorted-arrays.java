class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        if(len1>len2)
            return findMedianSortedArrays(nums2,nums1);
        
        boolean isEven=(len1+len2)%2==0;
        int val=(len1+len2+1)/2;
        int lo=0;
        int hi=len1;
        int a,b,c,d;
        
        while(lo<=hi){
            int partX=(lo+hi)/2;
            int partY=val-partX;
            a=partX==0?Integer.MIN_VALUE:nums1[partX-1];
            b=partX==len1?Integer.MAX_VALUE:nums1[partX];
            c=partY==0?Integer.MIN_VALUE:nums2[partY-1];
            d=partY==len2?Integer.MAX_VALUE:nums2[partY];
            
            if(a<=d && b>=c){
                if(isEven)
                    return ((double)Math.max(a,c)+(double)Math.min(b,d))/2.0;
                else
                    return (double)Math.max(a,c);
            }
            if(a>d)
                hi=partX-1;
            else
                lo=partX+1;
        }
        
        return 0.0;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len=arr.length;
        int lo=0;
        int hi=len-k;
        
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(x-arr[mid]>arr[mid+k]-x)
                lo=mid+1;
            else
                hi=mid;
                
        }
        
        return Arrays.stream(arr, lo, lo + k).boxed().collect(Collectors.toList());
    }
}
class Solution {
    int[] res;
    public List<Integer> countSmaller(int[] nums) {
        int len=nums.length;
        res=new int[len];
        int[][] arr=new int[len][2];
        for(int i=0;i<len;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        mergeSort(arr,0,len-1);
       
            
        return Arrays.stream(res)       
                                    .boxed()          
                                    .collect(Collectors.toList());
    }
    
    public void mergeSort(int[][] nums,int lo,int hi){
        if(lo>=hi)
            return;
        int mid=lo+(hi-lo)/2;
        mergeSort(nums,lo,mid);
        mergeSort(nums,mid+1,hi);
        merge(nums,lo,mid,hi);
    }
    
    
    public void merge(int[][] nums,int lo,int mid,int hi){
        
        int[][] left=new int[mid-lo+1][2];
        int[][] right=new int[hi-mid][2];
        
        for(int i=0;i<left.length;i++){
            left[i][0]=nums[i+lo][0];
            left[i][1]=nums[i+lo][1];
        }
        for(int i=0;i<right.length;i++){
            right[i][0]=nums[i+mid+1][0];
            right[i][1]=nums[i+mid+1][1];
        }
        int cnt=0;
        int i=0,j=0,k=lo;
        
        while(i<left.length || j<right.length){
            if(j>=right.length){
                res[left[i][1]]+=cnt;
                nums[k++]=left[i++];
            }else if(i>=left.length){
                nums[k++]=right[j++];
            }else if(left[i][0]>right[j][0]){
                cnt++;
                nums[k++]=right[j++];
            }else{
                 res[left[i][1]]+=cnt;
                 nums[k++]=left[i++];
            }
                
        }
    }
}
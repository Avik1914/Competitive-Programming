class Solution {
    int len;
    
    public int[] constructDistancedSequence(int n) {
        len=((n-1)*2)+1;
        int[] res=new int[len];
        backTrack(n,res,0,new HashSet());
        return res;
    }
    
    public boolean backTrack(int n,int[] arr,int start,Set<Integer> set){
        if(start>=len){
            return set.size()==n;
        }
        if(arr[start]!=0)
            return backTrack(n,arr,start+1,set);
        for(int i=n;i>=1;i--){
            if(set.contains(i))
                continue;
            if(i==1){
                arr[start]=i;
                set.add(i);
                if(backTrack(n,arr,start+1,set))
                    return true;
                set.remove(i);
                arr[start]=0;
            }else{
                if(i+start>=len || arr[i+start]!=0)
                    continue;
                arr[start]=i;
                arr[i+start]=i;
                set.add(i);
                if(backTrack(n,arr,start+1,set))
                    return true;
                set.remove(i);
                arr[start]=0;
                arr[i+start]=0;
            }
        }
        return false;
    }
}

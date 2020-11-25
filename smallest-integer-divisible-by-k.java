class Solution {
    public int smallestRepunitDivByK(int k) {
        Set<Integer> set=new HashSet();
        int itr=1;
        int val=1;
        int num=0;
        while(true){
            if(val%k==0)
                return itr;
             num=val%k;
            if(!set.add(val))
                return -1;
            val=(num*10)+1;
            itr++;
        }
    }
}

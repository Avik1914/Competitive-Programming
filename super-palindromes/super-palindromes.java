class Solution {
    public int superpalindromesInRange(String left, String right) {
        List<Long> set=new ArrayList<>();
        long l=Long.parseLong(left);
        long r=Long.parseLong(right);
        for(int i=1;i<10;i++)
            set.add(Long.valueOf(i));
        for(int i=1;i<10000;i++){
            String rev=new StringBuilder(""+i).reverse().toString();
            set.add(Long.parseLong(i+""+rev));
            for(int j=0;j<10;j++)
                set.add(Long.parseLong(i+""+j+""+rev));
        }
        int res=0;
        
        for(long val:set){
            long doub=val*val;
            String rev=new StringBuilder(""+doub).reverse().toString();
            if(String.valueOf(doub).equals(rev) && doub>=l && doub<=r){
                res++;
            }
        }
        
        return res;
    }
}
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] lkp=new int[256];
        
        for(char c:s.toCharArray())
            lkp[c]++;
        int e=0,o=0;
        
        for(int i=0;i<256;i++){
            if(lkp[i]%2==1)
                o++;
        }
        return o<=1;
    }
}

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        List<int[]> li=new ArrayList();
        int len=aliceValues.length;
        
        for(int i=0;i<len;i++)
            li.add(new int[]{aliceValues[i]+bobValues[i],i});
        Collections.sort(li,(a,b)->b[0]-a[0]);
        
        boolean isAlice=true;
        int a=0,b=0;
        
        for(int i=0;i<len;i++){
            if(isAlice)
                a+=aliceValues[li.get(i)[1]];
            else
                b+=bobValues[li.get(i)[1]];
            isAlice=!isAlice;
        }
        
        if(a==b)
            return 0;
        if(a>b)
            return 1;
        return -1;
    }
}

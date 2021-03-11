class Solution {
    public List<List<Integer>> getSkyline(int[][] b) {
        int len=b.length;
        List<int[]> li=new ArrayList();
        
        for(int i=0;i<len;i++){
            int[] x1=new int[]{b[i][0],b[i][2]};
            int[] x2=new int[]{b[i][1],0};
            for(int j=0;j<len;j++){
                if(i!=j){
                    if(x1[0]>=b[j][0] && x1[0]<b[j][1])
                        x1[1]=Math.max(x1[1],b[j][2]);
                    if(x2[0]>=b[j][0] && x2[0]<b[j][1])
                        x2[1]=Math.max(x2[1],b[j][2]);
                }
            }
            li.add(x1);
            li.add(x2);
        }
        for(int[] a:li){
            System.out.println(a[0]+","+a[1]);
        }
        Collections.sort(li,(x,y)->x[0]-y[0]);
        
       List<List<Integer>> res=new ArrayList();
        List<Integer> temp;
        int max=0;
        
        for(int i=0;i<li.size();){
            int[] val=li.get(i);
            int prev=val[0];
            int localMax=0;
            while(i<li.size() && li.get(i)[0]==prev){
                localMax=Math.max(localMax,li.get(i)[1]);
                i++;
            }
            if(max!=localMax){
                temp=new ArrayList();
                temp.add(prev);
                temp.add(localMax);
                res.add(temp);
                max=localMax;
            }
        }
        
        return res;
    }
}
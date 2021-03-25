class Solution {
    public int maxPoints(int[][] points) {
        int len=points.length;
        if(len<3)
            return len;
        int res=0;
        for(int i=0;i<len;i++){
            Map<String,Integer> map=new HashMap();
            for(int j=i+1;j<len;j++){
                int x=points[j][1]-points[i][1];
                int y=points[j][0]-points[i][0];
                int g=gcd(x,y);
                String s=(x/g)+","+(y/g);
                if(map.get(s)==null)
                    map.put(s,2);
                else
                    map.put(s,map.get(s)+1);
                res=Math.max(res,map.get(s));
            }
        }
        
        return res;
    }
    
    public int gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}
class Solution {
    public int maxPoints(int[][] points) {
        int len=points.length;
        int res=1;
        
        for(int i=0;i<len;i++){
            Map<String,Integer> map=new HashMap();
            for(int j=i+1;j<len;j++){
                int x=points[i][0]-points[j][0];
                int y=points[i][1]-points[j][1];
                int c=gcd(x,y);
                String str=(x/c)+","+(y/c);
                map.put(str,map.getOrDefault(str,1)+1);
                res=Math.max(map.get(str),res);
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
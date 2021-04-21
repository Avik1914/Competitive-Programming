class Solution {
    public int maxPoints(int[][] points) {
        int len=points.length;
        
        Map<String,Integer> map=new HashMap<>();
        int res=1;
        
        for(int i=0;i<len;i++){
            map.clear();
            for(int j=i+1;j<len;j++){
                int x=points[i][0]-points[j][0];
                int y=points[i][1]-points[j][1];
                int gcdOfXY=gcd(x,y);
                String val=(y/gcdOfXY)+","+(x/gcdOfXY);
                map.put(val,map.getOrDefault(val,1)+1);
                res=Math.max(res,map.get(val));
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
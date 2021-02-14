class Solution {
    int cnt=0;
    public boolean isPrintable(int[][] targetGrid) {
        Map<Integer,int[]> map=new HashMap();
        int row=targetGrid.length;
        int col=targetGrid[0].length;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!map.containsKey(targetGrid[i][j]))
                    map.put(targetGrid[i][j],new int[]{row,col,-1,-1});
                map.get(targetGrid[i][j])[0]=Math.min(map.get(targetGrid[i][j])[0],i);
                map.get(targetGrid[i][j])[1]=Math.min(map.get(targetGrid[i][j])[1],j);
                map.get(targetGrid[i][j])[2]=Math.max(map.get(targetGrid[i][j])[2],i);
                map.get(targetGrid[i][j])[3]=Math.max(map.get(targetGrid[i][j])[3],j);
            }
        }
        
        Set<Integer> visit=new HashSet();
        while(true){
            boolean yu=check(targetGrid,map,visit);
            if(!yu)
                break;
        }
        
        return cnt==map.size();
    }
    
    public boolean check(int[][] targetGrid,Map<Integer,int[]> map,Set<Integer> visit){
        
        for(int k:map.keySet()){
            if(!visit.contains(k)){
                boolean flag=true;
                
                for(int i=map.get(k)[0];i<=map.get(k)[2];i++){
                    for(int j=map.get(k)[1];j<=map.get(k)[3];j++){
                        if(targetGrid[i][j]!=k && targetGrid[i][j]!=0){
                            flag=false;
                            break;
                        }
                    }
                }
                if(flag){
                    visit.add(k);
                    cnt++;
                    for(int i=map.get(k)[0];i<=map.get(k)[2];i++){
                        for(int j=map.get(k)[1];j<=map.get(k)[3];j++)
                            targetGrid[i][j]=0;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
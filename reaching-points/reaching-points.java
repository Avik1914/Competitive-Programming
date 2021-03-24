class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx==tx && sy==ty)
            return true;
        
        if(sx==tx && ty>=sy)
            return ((ty-sy)%tx)==0;
        if(sy==ty && tx>=sx)
            return ((tx-sx)%ty)==0;
        if(sx>tx || sy>ty)
            return false;
        if(tx>ty)
            return reachingPoints(sx,sy,tx%ty,ty);
        return reachingPoints(sx,sy,tx,ty%tx);
    }
}
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int row=box.length;
        int col=box[0].length;
        
        char[][] res=new char[col][row];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                res[j][i]=box[i][j];
        }
        
        for(int i=0;i<col;i++){
            int x=0;
            int y=row-1;
            while(x<y){
                char temp=res[i][x];
                res[i][x]=res[i][y];
                res[i][y]=temp;
                x++;
                y--;
            }
        }
        int index=col-1;
        
        for(int i=0;i<row;i++){
            index=col-1;
            for(int j=col-1;j>=0;j--){
                if(res[j][i]=='*')
                    index=j-1;
                else if(res[j][i]=='#'){
                    res[j][i]='.';
                    res[index][i]='#';
                    index--;
                }
            }
        }
        
        return res;
    }
}
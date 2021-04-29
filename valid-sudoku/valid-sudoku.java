class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] setSquare=new HashSet[9];
        Set<Integer>[] setRow=new HashSet[9];
        Set<Integer>[] setCol=new HashSet[9];
        
        for(int i=0;i<9;i++){
                setSquare[i]=new HashSet<>();
                setRow[i]=new HashSet<>();
                setCol[i]=new HashSet<>();
        }
            
        
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                    continue;
                int val=(i/3)*3+j/3;
                int a=board[i][j]-'0';
                if(setSquare[val].contains(a))
                    return false;
                setSquare[val].add(a);
                if(setRow[i].contains(a) || setCol[j].contains(a))
                    return false;
                setRow[i].add(a);
                setCol[j].add(a);
                
                //System.out.println(i+","+j);
                
            }
        }
        
        return true;
    }
}
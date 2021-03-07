class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        
        int rowStart=0,rowEnd=row-1,colStart=0,colEnd=col-1;
        List<Integer> res=new ArrayList();
        
        while(rowStart<=rowEnd && colStart<=colEnd){
        for(int i=colStart;i<=colEnd;i++)
            res.add(matrix[rowStart][i]);
        
        for(int i=rowStart+1;i<=rowEnd;i++)
            res.add(matrix[i][colEnd]);
        
        if(rowStart<rowEnd)
            for(int i=colEnd-1;i>=colStart;i--)
                res.add(matrix[rowEnd][i]);
        if(colStart<colEnd)
            for(int i=rowEnd-1;i>rowStart;i--)
                res.add(matrix[i][colStart]);
            
        rowStart++;
        colStart++;
        rowEnd--;
        colEnd--;
            
        }
        return res;
    }
}
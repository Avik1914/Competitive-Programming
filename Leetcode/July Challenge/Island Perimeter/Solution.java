/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int r=grid.length;
        if(r==0)
            return 0;
        int c=grid[0].length;
        int res=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                  if(i==0 || grid[i-1][j]==0)
                      res++;
                  if(i==r-1 || grid[i+1][j]==0)
                      res++;
                  if(j==0 || grid[i][j-1]==0)
                      res++;
                  if(j==c-1 || grid[i][j+1]==0)
                      res++;
                }
            }
        }
        return res;
    }
}

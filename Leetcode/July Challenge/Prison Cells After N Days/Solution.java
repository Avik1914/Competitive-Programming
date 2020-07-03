/*
There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)

 

Example 1:

Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: 
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

Example 2:

Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]
 

Note:

cells.length == 8
cells[i] is in {0, 1}
1 <= N <= 10^9
*/

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String,Integer> map=new HashMap();
        Map<Integer,int[]> map1=new HashMap();
        int itr=0;
        while(!map.containsKey(Arrays.toString(cells)) && itr<N){
            map.put(Arrays.toString(cells),itr);
            map1.put(itr++,cells);
            int[] copy=cells.clone();
            for(int i=0;i<8;i++){
                if(i==0 || i==7)
                    copy[i]=0;
                else if(cells[i-1]==cells[i+1])
                    copy[i]=1;
                else
                    copy[i]=0;
            }
            cells=copy;
            //System.out.println(itr+"--"+Arrays.toString(cells));
        }   
        if(itr>=N)
            return cells; 
        int u=map.get(Arrays.toString(cells));
        if(u>0)
            N=N-u+1;
        else
            return map1.get(N%itr);
        itr--;
        int val=0;
        if(N%itr==0)
            val=itr;
        else
            val=N%itr;
        
        return map1.get(val);
    }
}

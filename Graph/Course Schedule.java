/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map=new HashMap();
        int[] indegree=new int[numCourses];
        List <Integer> temp;
        for(int[] p:prerequisites){
            temp=map.getOrDefault(p[1],new ArrayList());
            temp.add(p[0]);
            map.putIfAbsent(p[1],temp);
            indegree[p[0]]++;
        }
        Queue<Integer> queue=new LinkedList();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        int cnt=0;
        while(!queue.isEmpty()){
            int val=queue.poll();
            cnt++;
            temp=map.getOrDefault(val,new ArrayList());
            for(int t:temp){
                indegree[t]--;
                if(indegree[t]==0)
                    queue.add(t);
            }
        }
        
        return cnt==numCourses;
    }
}

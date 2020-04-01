/*

B. Forming Teams
time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
One day n students come to the stadium. They want to play football, and for that they need to split into teams, the teams must have an equal number of people.

We know that this group of people has archenemies. Each student has at most two archenemies. Besides, if student A is an archenemy to student B, then student B is an archenemy to student A.

The students want to split so as no two archenemies were in one team. If splitting in the required manner is impossible, some students will have to sit on the bench.

Determine the minimum number of students you will have to send to the bench in order to form the two teams in the described manner and begin the game at last.

Input
The first line contains two integers n and m (2 ≤ n ≤ 100, 1 ≤ m ≤ 100) — the number of students and the number of pairs of archenemies correspondingly.

Next m lines describe enmity between students. Each enmity is described as two numbers ai and bi (1 ≤ ai, bi ≤ n, ai ≠ bi) — the indexes of the students who are enemies to each other. Each enmity occurs in the list exactly once. It is guaranteed that each student has no more than two archenemies.

You can consider the students indexed in some manner with distinct integers from 1 to n.

Output
Print a single integer — the minimum number of students you will have to send to the bench in order to start the game.

Examples
inputCopy
5 4
1 2
2 4
5 3
1 4
outputCopy
1
inputCopy
6 2
1 4
3 4
outputCopy
0
inputCopy
6 6
1 2
2 3
3 1
4 5
5 6
6 4
outputCopy
2
*/
public class Main {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int m=sc.nextInt();
        Map<Integer,List<Integer>> map=new HashMap();
        for(int i=1;i<=n;i++)
            map.put(i,new ArrayList());
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            map.get(a).add(b);
            map.get(b).add(a);
        }
        int[] visit=new int[n+1];
        int res=0;
        for(int i=1;i<=n;i++){
            if(visit[i]==0)
                res+=bfs(map,i,visit);
        }
        if(res%2==1)
            res--;
        System.out.println(n-res);
    }
    
    public static int bfs(Map<Integer,List<Integer>> map,int val,int[] visit){
        Queue<Integer> queue=new LinkedList();
        queue.add(val);
        visit[val]=1;
        int res=0;
        while(!queue.isEmpty()){
            int val1=queue.poll();
            if(visit[val1]!=3)
                res++;
            for(int i:map.get(val1)){
                if(visit[i]==0){
                    visit[i]=visit[val1]==1?2:1;
                    queue.add(i);
                }else if(visit[val1]==visit[i])
                    visit[i]=3;
                    
            }
        }
        return res;
    }
}

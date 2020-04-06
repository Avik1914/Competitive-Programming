/*
Kefa decided to celebrate his first big salary by going to the restaurant.

He lives by an unusual park. The park is a rooted tree consisting of n vertices with the root at vertex 1. Vertex 1 also contains Kefa's house. Unfortunaely for our hero, the park also contains cats. Kefa has already found out what are the vertices with cats in them.

The leaf vertices of the park contain restaurants. Kefa wants to choose a restaurant where he will go, but unfortunately he is very afraid of cats, so there is no way he will go to the restaurant if the path from the restaurant to his house contains more than m consecutive vertices with cats.

Your task is to help Kefa count the number of restaurants where he can go.

Input
The first line contains two integers, n and m (2 ≤ n ≤ 105, 1 ≤ m ≤ n) — the number of vertices of the tree and the maximum number of consecutive vertices with cats that is still ok for Kefa.

The second line contains n integers a1, a2, ..., an, where each ai either equals to 0 (then vertex i has no cat), or equals to 1 (then vertex i has a cat).

Next n - 1 lines contains the edges of the tree in the format "xi yi" (without the quotes) (1 ≤ xi, yi ≤ n, xi ≠ yi), where xi and yi are the vertices of the tree, connected by an edge.

It is guaranteed that the given set of edges specifies a tree.

Output
A single integer — the number of distinct leaves of a tree the path to which from Kefa's home contains at most m consecutive vertices with cats.

Examples
inputCopy
4 1
1 1 0 0
1 2
1 3
1 4
outputCopy
2
inputCopy
7 1
1 0 1 1 0 0 0
1 2
1 3
2 4
2 5
3 6
3 7
outputCopy
2
*/

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int catArr[]=new int[n+1];
        Map<Integer,List<Integer>> map=new HashMap();
        
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList());
            catArr[i]=sc.nextInt();
        }
        for(int i=1;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            map.get(a).add(b);
            map.get(b).add(a);
        }
        System.out.println(dfs(map,1,0,catArr[1],m,catArr));
        
    }
    
    public static int dfs(Map<Integer,List<Integer>> map,int val,int parent,int count,int m,int[] c){
        if(count>m)
            return 0;
        if(map.get(val).size()==1 && val!=1)
            return 1;
        int res=0;
        for(int i:map.get(val)){
            if(i!=parent){
                int p=c[i]==0?0:count+1;
                res+=dfs(map,i,val,p,m,c);
            }
                
        }
        return res;
    }
}

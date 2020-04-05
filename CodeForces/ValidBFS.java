/*
The BFS algorithm is defined as follows.

Consider an undirected graph with vertices numbered from 1 to n. Initialize q as a new queue containing only vertex 1, mark the vertex 1 as used.
Extract a vertex v from the head of the queue q.
Print the index of vertex v.
Iterate in arbitrary order through all such vertices u that u is a neighbor of v and is not marked yet as used. Mark the vertex u as used and insert it into the tail of the queue q.
If the queue is not empty, continue from step 2.
Otherwise finish.
Since the order of choosing neighbors of each vertex can vary, it turns out that there may be multiple sequences which BFS can print.

In this problem you need to check whether a given sequence corresponds to some valid BFS traversal of the given tree starting from vertex 1. The tree is an undirected graph, such that there is exactly one simple path between any two vertices.

Input
The first line contains a single integer n (1≤n≤2⋅105) which denotes the number of nodes in the tree.

The following n−1 lines describe the edges of the tree. Each of them contains two integers x and y (1≤x,y≤n) — the endpoints of the corresponding edge of the tree. It is guaranteed that the given graph is a tree.

The last line contains n distinct integers a1,a2,…,an (1≤ai≤n) — the sequence to check.

Output
Print "Yes" (quotes for clarity) if the sequence corresponds to some valid BFS traversal of the given tree and "No" (quotes for clarity) otherwise.

You can print each letter in any case (upper or lower).

Examples
inputCopy
4
1 2
1 3
2 4
1 2 3 4
outputCopy
Yes
inputCopy
4
1 2
1 3
2 4
1 2 4 3
outputCopy
No
Note
Both sample tests have the same tree in them.

In this tree, there are two valid BFS orderings:

1,2,3,4,
1,3,2,4.
The ordering 1,2,4,3 doesn't correspond to any valid BFS order.
*/

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,Set<Integer>> map=new HashMap();
        for(int i=1;i<=n;i++)
            map.put(i,new HashSet());
        
        for(int i=1;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            map.get(a).add(b);
            map.get(b).add(a);
        }
        Queue<Integer> queue=new LinkedList();
        int[] arr=new int[n];
    
        
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        if(arr[0]!=1){
            System.out.println("No");
            return;
        }
        int itr=1;
        queue.add(1);
      
        
        while(!queue.isEmpty()){
                int val=queue.poll();
                while(itr<n){
                    if(map.get(val).contains(arr[itr])){
                        queue.add(arr[itr]);
                        itr++;
                    }else
                        break;
                }
        }
        if(itr==n)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

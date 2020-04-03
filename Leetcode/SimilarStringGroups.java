/*
Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y. Also two strings X and Y are similar if they are equal.

For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?

 

Example 1:

Input: A = ["tars","rats","arts","star"]
Output: 2
 

Constraints:

1 <= A.length <= 2000
1 <= A[i].length <= 1000
A.length * A[i].length <= 20000
All words in A consist of lowercase letters only.
All words in A have the same length and are anagrams of each other.
The judging time limit has been increased for this question.
*/

/*DFS Solution*/

class Solution {
    public int numSimilarGroups(String[] A) {
         int len=A.length;
         boolean[] visit=new boolean[len];
         int count=0;
         boolean inc=true;
         for(int i=0;i<len;i++){
            if(!visit[i]){
                dfs(A,i,visit);
                count++;
            }   
         }
        return count;
    }
    
    public void dfs(String[] arr,int start,boolean[] visit){
        visit[start]=true;
        for(int i=0;i<arr.length;i++){
            if(!visit[i] && helper(arr[start],arr[i]))
                dfs(arr,i,visit);
        }
    }
    
    public boolean helper(String s,String t){
        int res = 0, i = 0;
        while(res <= 2 && i < s.length()){
            if(s.charAt(i) != t.charAt(i)) res++;
            i++;
        }
        return res == 2 || res==0;
    }
}




/*Disjoint Set Solution*/

class Solution {
    public int numSimilarGroups(String[] A) {
        int len=A.length;
        UnionFind uf=new UnionFind(len);
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i!=j && helper(A[i],A[j]))
                    uf.union(i,j);
            }
        }
        return uf.noOfComp;
    }
    public boolean helper(String s,String t){
        int res = 0, i = 0;
        while(res <= 2 && i < s.length()){
            if(s.charAt(i) != t.charAt(i)) res++;
            i++;
        }
        return res == 2 || res==0;
    }
}

class UnionFind{
    int[] parent;
    int [] size;
    int noOfComp;
    
    UnionFind(int n){
        parent=new int[n];
        size=new int[n];
        noOfComp=n;
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    
    public int find(int a){
        int val=a;
        while(a!=parent[a])
            a=parent[a];
        while(val!=parent[val]){
            int next=parent[val];
            parent[val]=a;
            val=next;
        }
        return a;
    }
    
    public void union(int a,int b){
        int id1=find(a);
        int id2=find(b);
        if(id1!=id2){
            if(size[id1]<size[id2]){
                parent[id1]=id2;
                size[id2]+=size[id1];
            }else{
                parent[id2]=id1;
                size[id1]+=size[id2]; 
            }
            noOfComp--;
        }
    }
}

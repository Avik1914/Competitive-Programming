/*
You are given equations in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating-point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

 

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 

Constraints:

1 <= equations.length <= 20
equations[i].length == 2
1 <= equations[i][0], equations[i][1] <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= queries[i][0], queries[i][1] <= 5
equations[i][0], equations[i][1], queries[i][0], queries[i][1] consist of lower case English letters and digits.
*/

class Solution {
    Map<String,List<Pair<String,Double>>> map;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map=new HashMap();
        int len=equations.size();
        for(int i=0;i<len;i++){
            List<Pair<String,Double>> tmp=map.getOrDefault(equations.get(i).get(0),new ArrayList());
            Pair<String,Double> p=new Pair(equations.get(i).get(1),values[i]);
            tmp.add(p);
            map.put(equations.get(i).get(0),tmp);
            
            
            tmp=map.getOrDefault(equations.get(i).get(1),new ArrayList());
            double rev=1.0/values[i];
            p=new Pair(equations.get(i).get(0),rev);
            tmp.add(p);
            map.put(equations.get(i).get(1),tmp);
        }
        int itr=0;
        double[] res=new double[queries.size()];
        for(List<String> ls:queries)
            res[itr++]=dfs(ls.get(0),ls.get(1),new HashSet(),1.0);    
        return res;
    }
    
    public double dfs(String start,String end,Set<String> visit,double res){
        if(!map.containsKey(start))
            return -1.0;
        if(start.equals(end))
            return res;
        double fin=-1.0;
        visit.add(start);
        for(Pair<String,Double> p:map.get(start)){
            if(!visit.contains(p.getKey()))
                fin=dfs(p.getKey(),end,visit,res*p.getValue());
            if(fin!=-1.0)
                return fin;
        }
        return fin;
    }
}

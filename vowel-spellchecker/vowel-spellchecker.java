class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int len=wordlist.length;
        Set<String> set=new HashSet(Arrays.asList(wordlist));
        
        Map<String,String> caseMap=new HashMap();
        Map<String,String> noVowel=new HashMap();
        
        for(String w:wordlist){
            String s=w;
            s=s.toLowerCase();
            caseMap.putIfAbsent(s,w);
            s=s.replaceAll("[aeiou]","#");
            noVowel.putIfAbsent(s,w);
        }
        
        String[] res=new String[queries.length];
        int itr=0;
        
        for(String q:queries){
            String s=q;
            s=s.toLowerCase();
            if(set.contains(q))
                res[itr]=q;
            else if(caseMap.containsKey(s))
                res[itr]=caseMap.get(s);
            else{
                s=s.replaceAll("[aeiou]","#");
                res[itr]=noVowel.getOrDefault(s,"");
            }
            itr++;
        }
        return res;
    }
}
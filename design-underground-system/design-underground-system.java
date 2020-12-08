class UndergroundSystem {
    Map<String,Double> finalMap;
    Map<String,Integer> countMap;
    Map<Integer,Pair<String,Integer>> checkInMap;
    public UndergroundSystem() {
        finalMap=new HashMap();
        checkInMap=new HashMap();
        countMap=new HashMap();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Pair p=new Pair(stationName,t);
        checkInMap.put(id,p);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair p=checkInMap.get(id);
        double val=(double)(t-(int)p.getValue());
        String key=p.getKey()+","+stationName;
        finalMap.put(key,finalMap.getOrDefault(key,0.0)+val);
        checkInMap.remove(id);
        countMap.put(key,countMap.getOrDefault(key,0)+1);
         
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key=startStation+","+endStation;
        return finalMap.get(key)/(double)countMap.get(key);
    }
}
​
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

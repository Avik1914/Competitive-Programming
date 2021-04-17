class SnapshotArray {
    TreeMap<Integer,Integer>[] treeMap;
    int snap_id=0;
    public SnapshotArray(int length) {
        treeMap=new TreeMap[length];
        for(int i=0;i<length;i++){
            treeMap[i]=new TreeMap<>();
            treeMap[i].put(0,0);
        }
    }
    
    public void set(int index, int val) {
        treeMap[index].put(snap_id,val);
    }
    
    public int snap() {
        snap_id++;
        return snap_id-1;
    }
    
    public int get(int index, int snap_id) {
        return treeMap[index].get(treeMap[index].floorKey(snap_id));
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
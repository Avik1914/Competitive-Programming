/*
Design a data structure that accepts integers of a stream, and checks if it has a pair of integers that sum up to a particular value. 

Implement a TwoSum class:

TwoSum() Initializes the TwoSum object, with an empty array initially.
void add(int number) Adds number to the data structure.
boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.
 

Example 1:

Input
["TwoSum", "add", "add", "add", "find", "find"]
[[], [1], [3], [5], [4], [7]]
Output
[null, null, null, null, true, false]

Explanation
TwoSum twoSum = new TwoSum();
twoSum.add(1);   // [] --> [1]
twoSum.add(3);   // [1] --> [1,3]
twoSum.add(5);   // [1,3] --> [1,3,5]
twoSum.find(4);  // 1 + 3 = 4, return True
twoSum.find(7);  // No two integers sum up to 7, return False
*/

class TwoSum {
    Map<Integer,Integer> lkp;
    /** Initialize your data structure here. */
    public TwoSum() {
        lkp=new HashMap();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        lkp.put(number,lkp.getOrDefault(number,0)+1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int i:lkp.keySet()){
            if(value-i!=i && lkp.containsKey(value-i))
                return true;
            if(value-i==i && lkp.getOrDefault(value-i,0) >1)
                return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

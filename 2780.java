// import java.util.Collections; // Import the Collections class

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int res = -1;
        // findDominantNumber(nums);
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> sublist1 = nums.subList(0, i);
            List<Integer> sublist2 = nums.subList(i, nums.size());

            int domSublist1 = findDominantNumber(sublist1);
            int domSublist2 = findDominantNumber(sublist2);
            if(domSublist1 == domSublist2) {
                System.out.println(sublist1);
                System.out.println(sublist2);
                return i-1;
            }
        }
        return res;
    }

    public int findDominantNumber(List<Integer> sublist) {
        HashMap<Integer,Integer> map = new HashMap();
        int maxFreq = -1;
        int dominantNumber = -1;

        for(int i = 0; i < sublist.size(); i++) {
            Integer currentValue = sublist.get(i);
            if(map.size() == 0) {
                map.put(currentValue,1);
                maxFreq = 1;
                dominantNumber = currentValue;
            } else {
                if(map.containsKey(currentValue)) {
                    int currentValFreq = map.get(currentValue);
                    map.put(currentValue,(currentValFreq+1));
                } else {
                    map.put(currentValue,1);
                }
                
                if(map.get(currentValue) > maxFreq) {
                    maxFreq = map.get(currentValue);
                    dominantNumber = currentValue;
                }
            }
        }

// The array [3,3,3,7,2,2] has 6 elements, the most frequent element has a frequency of 3.
// More than half means that the frequency of the most frequent element is greater than half of all elements in the subarray.
        if(maxFreq > sublist.size()/2) {
            return dominantNumber;
        } else { return -1;}
    }
}
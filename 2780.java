class Solution {
    public int minimumIndex(List<Integer> nums) {
        int res = -1;
        int maindominantnumber = findMainDominantNumber(nums);
        if(maindominantnumber == -1) return -1;
        
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> sublist1 = nums.subList(0, i);
            List<Integer> sublist2 = nums.subList(i, nums.size());
            //check valid list
            boolean isvalid1 = isListValid(sublist1, maindominantnumber);
            boolean isvalid2 = isListValid(sublist2, maindominantnumber);
            // System.out.println("list1:"+sublist1+" - valid:"+isvalid1);
            // System.out.println("list2:"+sublist2+" - valid:"+isvalid2);
            if(isvalid1 && isvalid2) return i-1;
        }
        return res;
    }

    public boolean isListValid(List<Integer> sublist, int dominantNumber) {
        if(sublist.isEmpty() || !sublist.contains(dominantNumber)) return false;

        HashMap<Integer,Integer> map = new HashMap();
        int count = 0;

        for(int i = 0; i < sublist.size(); i++) {
            if(sublist.get(i) == dominantNumber) {
                count++;
            }
        }
        return count > sublist.size()/2;
    }

    public int findMainDominantNumber(List<Integer> list) {
        HashMap<Integer,Integer> map = new HashMap();
        int maxFreq = -1;
        int dominantNumber = -1;

        for(int i = 0; i < list.size(); i++) {
            Integer currentValue = list.get(i);
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
        return dominantNumber;
    }
}
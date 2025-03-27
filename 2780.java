class Solution {
    public int minimumIndex(List<Integer> nums) {
        int res = -1;
        int maindominantnumber = findMainDominantNumber(nums);
        if(maindominantnumber == -1) return -1;

        int totalDominantCount = 0;
        for (int num : nums) {
            if (num == maindominantnumber) {
                totalDominantCount++;
            }
        }

        int leftCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == maindominantnumber) {
                leftCount++;
            }

            int leftSubarrayCount = leftCount;
            int rightSubarrayCount = totalDominantCount - leftCount;
            //check valid list
            boolean isvalid1 = leftSubarrayCount > (i + 1) / 2 ;
            boolean isvalid2 = rightSubarrayCount > (nums.size() - i - 1) / 2;
            if(isvalid1 && isvalid2) return i;
        }
        return -1;
    }

    public int findMainDominantNumber(List<Integer> list) {
        int candidate = -1, count = 0;

        for(int i = 0; i < list.size(); i++) {
            if(count == 0) {
                candidate = list.get(i);
                count = 1;
            } else if(list.get(i) == candidate) {
                count ++;
            } else {
                count --;
            }
        }
        
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == candidate) {
                count++;
            }
        }
        if( count > list.size()/2)
            return candidate;
            else return -1;
    }
}
class Solution {
    public int findMin(int[] nums) {
        return bruteForceUsingLinearSearch(nums);
    }

    public int bruteForceUsingLinearSearch(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        for(int i : nums)
        {
            if(i < minValue) minValue=i;
        }
        return minValue;
    }
}
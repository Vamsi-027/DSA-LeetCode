class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) 
        {
            curSum += nums[i];
            maxSum = Math.max(curSum, maxSum);

            if(curSum < 0) curSum = 0;
        }
        return maxSum;
    }
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Sliding window technique
        int left = 0;
        int result = Integer.MAX_VALUE;
        int curSum = 0;
        for(int right=0; right<nums.length; right++)
        {
            curSum += nums[right];
            while(curSum >= target)
            {
                result = Math.min(result, right-left+1);
                curSum -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
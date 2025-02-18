class Solution {
    public int splitArray(int[] nums, int k) {
        
        int left = Integer.MIN_VALUE;
        int right = 0;
        for(int i : nums)
        {
            left = Math.max(left, i);
            right += i;
        }

        while(left <= right)
        {
            int mid = left + (right-left)/2;
            int subArraysCount = getSubArraysCount(nums, mid);
            if(subArraysCount <= k)
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }
        return left;
    }

    public static int getSubArraysCount(int[] nums, int subArraySum)
    {
        int counter = 1;
        int curSum = 0;
        for(int i : nums)
        {
            if(curSum + i > subArraySum)
            {
                counter++;
                curSum = i;
            }
            else
            {
                curSum += i;
            }
        }
        return counter;
    }
}
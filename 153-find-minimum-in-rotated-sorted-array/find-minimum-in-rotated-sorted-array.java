class Solution {
    public int findMin(int[] nums) {
        // return bruteForceUsingLinearSearch(nums);
        return usingBinarySearch(nums);
    }

    public int bruteForceUsingLinearSearch(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        for(int i : nums)
        {
            if(i < minValue) minValue=i;
        }
        return minValue;
    }

    public int usingBinarySearch(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int ans = Integer.MAX_VALUE;


        while(left <= right) 
        {
            int mid = left + (right-left)/2;
            if(nums[left] <= nums[mid])
            {
                ans = Math.min(nums[left], ans);
                left = mid+1;
            }
            else 
            {
                ans = Math.min(ans, nums[mid]);
                right = mid;
            }
        }
        return ans;
    }
}
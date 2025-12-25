class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int curZero = 0;

        while(l < n && r < n)
        {
            if(nums[r] == 0) curZero++;
            while(curZero > k)
            {
                if(nums[l] == 0) curZero--;
                l++;
            }
            r++;
            maxLen = Math.max(maxLen, r-l);
        }
        return maxLen;
    }
}
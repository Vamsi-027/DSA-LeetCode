class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n-1; i++)
        {
            if(nums[i] == nums[i+1])
            {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        moveZerosToEnd(nums, n);
        return nums;
    }

    public void moveZerosToEnd(int[] nums, int n)
    {
        int ind = 0;
        for(int i=0; i<n; i++)
        {
            if(nums[i] != 0)
            {
                nums[ind++] = nums[i];
            }
        }

        while(ind < n)
        {
            nums[ind++] = 0;
        }
    }
}
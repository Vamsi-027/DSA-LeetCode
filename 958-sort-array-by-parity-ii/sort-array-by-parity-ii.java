class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int ep = 0;
        int op = 1;
        while(ep < n && op < n)
        {
            if(nums[ep] % 2 == 0) ep += 2;
            else if(nums[op] %2 == 1) op += 2;
            else swap(nums, ep, op);
        } 
        return nums;
    }

    public void swap(int[] nums, int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
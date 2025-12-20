class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid < high)
        {
            if(nums[mid] % 2 == 0)
            {
                swap(nums, low, mid);
                mid++;
            }
            else
            {
                swap(nums, mid, high);
                high--;
            }
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
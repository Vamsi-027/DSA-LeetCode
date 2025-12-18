class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];

        int product = 1;
        for(int i=0; i<nums.length; i++)
        {
            prefixProduct[i] = nums[i]*product;
            product = prefixProduct[i];
        }

        product = 1;
        for(int i=nums.length-1; i>=0; i--)
        {
            suffixProduct[i] = nums[i] * product;
            product = suffixProduct[i];
        }

        int[] ans = new int[nums.length];
        ans[0] = suffixProduct[1];
        ans[ans.length-1] = prefixProduct[nums.length-2];

        for(int i=1; i<nums.length-1; i++)
        {
            ans[i] = prefixProduct[i-1] * suffixProduct[i+1];
        }

        return ans;
    }
}
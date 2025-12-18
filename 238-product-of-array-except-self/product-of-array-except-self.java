class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] preProd = new int[n];
        preProd[0] = 1;

        int[] sufProd = new int[n];
        sufProd[n-1] = 1;

        for(int i=1; i<n; i++)
        {
            preProd[i] = nums[i-1] * preProd[i-1];
        }

        for(int i=n-2; i>=0; i--)
        {
            sufProd[i] = nums[i+1] * sufProd[i+1];
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++)
        {
            ans[i] = preProd[i] * sufProd[i];
        }

        return ans;
    }
}
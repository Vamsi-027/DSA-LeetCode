class Solution {
    public int maxAbsoluteSum(int[] nums) {
        //Kadanes Algo
        int positivePrefixSum = 0;
        int negativePrefixSum = 0;
        int maxPositiveSum = Integer.MIN_VALUE;
        int maxNegativeSum = Integer.MAX_VALUE;
        for(int i : nums)
        {
            positivePrefixSum += i;
            negativePrefixSum += i;
            maxPositiveSum = Math.max(positivePrefixSum, maxPositiveSum);
            maxNegativeSum = Math.min(negativePrefixSum, maxNegativeSum);
            if(positivePrefixSum < 0) positivePrefixSum = 0;
            if(negativePrefixSum > 0) negativePrefixSum = 0;
        }
        return Math.max(maxPositiveSum, Math.abs(maxNegativeSum));
    }
}
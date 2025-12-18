class Solution {
    public int maxProfit(int[] prices) {
        // return trackMaxProfit(prices);
        return kadanesAlgo(prices);
    }

    public int trackMaxProfit(int[] prices)
    {
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for(int i=1; i<prices.length; i++)
        {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-min);
        }
        
        return maxProfit;
    }

    public int kadanesAlgo(int[] prices) {
        int[] priceDiffs = new int[prices.length-1];

        for(int i=1; i<prices.length; i++)
        {
            priceDiffs[i-1] = prices[i] - prices[i-1];
        }

        // Kadane's Algorithm
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<priceDiffs.length; i++)
        {
            System.out.println(priceDiffs[i]);

            curSum += priceDiffs[i];
            maxSum = Math.max(curSum, maxSum);

            if(curSum < 0) curSum = 0;
        }
        return maxSum >= 0 ? maxSum  : 0;
    }
}
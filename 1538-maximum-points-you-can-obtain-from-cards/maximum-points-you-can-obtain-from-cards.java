class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        int leftSum  = 0;
        int rightSum = 0;

        for(int i=0; i<k; i++)
        {
            leftSum += cardPoints[i];
        }

        int maxScore = leftSum;
        int lp = k-1;
        int rp = n-1;

        while(k > 0)
        {
            leftSum -= cardPoints[lp];
            rightSum += cardPoints[rp];

            maxScore = Math.max(leftSum+rightSum, maxScore);
            
            lp--;
            rp--;
            k--;
        }

        return maxScore;
    }
}
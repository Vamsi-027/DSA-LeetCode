class Solution {
    public int shipWithinDays(int[] weights, int days) 
    {
        Pair pair = getMinAndMaxLoad(weights);
        int left = pair.min;
        int right = pair.max;
        int result = 0;
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            if(isPossibleToLoad(weights, days, mid))
            {
                result = mid;
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }
        return result;
    }

    public Pair getMinAndMaxLoad(int[] weights)
    {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for(int load : weights)
        {
            max += load;
            min = Math.max(min, load);
        }
        return new Pair(min, max);
    }

    public boolean isPossibleToLoad(int[] weights, int maxDays, int maxLoad)
    {
        int curLoad = 0;
        int curDays = 1;
        for(int i=0; i<weights.length; i++)
        {
            if(curLoad+weights[i] > maxLoad)
            {
                curDays++;
                curLoad = weights[i];
            }
            else
            {
                curLoad += weights[i];
            }
        }
        if(curDays <= maxDays) return true;
        return false;
    }
}

class Pair 
{
    int min;
    int max;
    Pair(int min, int max)
    {
        this.min = min;
        this.max = max;
    }
}
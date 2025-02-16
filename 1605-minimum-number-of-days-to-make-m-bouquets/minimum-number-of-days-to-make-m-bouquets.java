class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int[] minMax = findMinAndMax(bloomDay);
        int left = minMax[0];
        int right = minMax[1];
        int result = -1;
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            int minBouquets = findMinBouquets(bloomDay, m, k, mid);
            if(minBouquets >= m) 
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


    public int[] findMinAndMax(int[] arr)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : arr)
        {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return new int[]{min,max};
    }

    public int findMinBouquets(int[] bloomDay, int bouquets, int adjFlowers, int curDay)
    {
        int counter = 0;
        int result = 0;
        for(int i : bloomDay)
        {
            if(i <= curDay)
            {
                counter++;
            }
            else
            {
                result = result + (counter/adjFlowers);
                counter = 0;
            }
        }
        result = result + (counter/adjFlowers);
        return result;
    }
}
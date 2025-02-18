class Solution {
    public int splitArray(int[] nums, int k) {
        Pair pair = getLeftAndRight(nums);
        int left = pair.left;
        int right = pair.right;
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            int subArraysCount = getSubArraysCount(nums, mid);
            if(subArraysCount <= k)
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }
        return left;
    }

    public static int getSubArraysCount(int[] nums, int subArraySum)
    {
        int counter = 1;
        int curSum = 0;
        for(int i : nums)
        {
            if(curSum + i > subArraySum)
            {
                counter++;
                curSum = i;
            }
            else
            {
                curSum += i;
            }
        }
        return counter;
    }

    public static Pair getLeftAndRight(int[] nums)
    {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for(int i : nums)
        {
            left = Math.max(left, i);
            right += i;
        }
        return new Pair(left, right);
    }
}



class Pair
{
    int left;
    int right;
    Pair(int left, int right)
    {
        this.left = left;
        this.right = right;
    }
}

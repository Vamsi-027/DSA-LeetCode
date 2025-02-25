class Solution {
    public int numOfSubarrays(int[] arr) {
        int count = 0;
        int prefixSum = 0;
        int oddCount = 0;
        int evenCount = 1;
        for(int i : arr)
        {
            prefixSum += i;
            if(prefixSum %2 == 0)
            {
                evenCount++;
                count += oddCount;
            }
            else
            {
                oddCount++;
                count += evenCount;
            }
            count %= (Math.pow(10, 9) + 7);
        }
        return count;
    }
}
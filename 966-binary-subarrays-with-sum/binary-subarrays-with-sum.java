class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int prefixSum = 0;
        map.put(0,1);

        for(int i : nums)
        {
            prefixSum += i;
            int balance = prefixSum - goal;
            count += map.getOrDefault(balance,0);
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
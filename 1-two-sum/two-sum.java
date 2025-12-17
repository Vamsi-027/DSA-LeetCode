class Solution {
    public int[] twoSum(int[] nums, int target) {
        // return bruteForce(nums, target);
        return usingHashMap(nums, target);
    }

    public int[] bruteForce(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target && i!=j) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    public int[] usingHashMap(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++)
        {
            int balance = target-nums[i];
            if(map.containsKey(balance)) return new int[]{map.get(balance), i};
            else map.put(nums[i], i);
        }

        return new int[]{};
    }
}
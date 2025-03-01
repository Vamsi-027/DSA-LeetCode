class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int num : nums)
        {
            int freq = freqMap.getOrDefault(num, 0);
            if(freq >= result.size()) result.add(new ArrayList<>());
            result.get(freq).add(num);
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        return result;
    }
}
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int[] nums : grid)
        {
            for(int i : nums)
            {
                map.put(i, map.getOrDefault(i,0)+1);
            }
        }

        for(int i=1; i<=grid.length*grid[0].length; i++)
        {
            if(map.get(i) == null || map.get(i) == 0)
            {
                result[1] = i;
            }
            else if(map.get(i) == 2)
            {
                result[0] = i;
            }
        }

        return result;
    }
}
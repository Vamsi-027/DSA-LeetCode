class Solution {
    public int minimumRecolors(String blocks, int k) {
        //Sliding window
        int left = 0;
        int result = Integer.MAX_VALUE;
        int whites = 0;
        for(int right=0; right<blocks.length(); right++)
        {
            if(blocks.charAt(right) == 'W') whites++;
            if(right-left+1 == k)
            {
                result = Math.min(result, whites);
                if(blocks.charAt(left) == 'W') whites--;
                left++;
            }
        }
        return result;
    }
}
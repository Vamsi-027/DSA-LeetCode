class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(int right = 0; right < n; right++)
        {
            char curChar = s.charAt(right);
            freqMap.put(curChar, freqMap.getOrDefault(curChar,0)+1);
            maxFreq = Math.max(maxFreq, freqMap.get(curChar));

            while((right-left+1)-maxFreq > k)
            {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar)-1);
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
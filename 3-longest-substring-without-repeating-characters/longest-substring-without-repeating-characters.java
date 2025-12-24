class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
    
        int lp = 0;
        int rp = 0;
        int maxLen = 0;

        while(rp < n)
        {
            char c = s.charAt(rp);
            if(map.containsKey(c) && map.get(c) >= lp)
            {
                lp = map.get(c)+1;
            }
            maxLen = Math.max(maxLen, rp-lp+1);
            map.put(c,rp);
            rp++;
        }
        return maxLen;
    }
}
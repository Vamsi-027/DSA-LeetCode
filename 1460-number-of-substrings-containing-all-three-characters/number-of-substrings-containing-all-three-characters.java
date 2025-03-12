class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int[] freq = new int[3];
        int total = 0;
        while(right < len)
        {
            char curChar = s.charAt(right);
            freq[curChar-'a']++;
            while(hasAllChars(freq))
            {
                total += len-right;
                char leftChar = s.charAt(left);
                freq[leftChar-'a']--;
                left++;
            }
            right++;
        }
        return total;
    }

    public boolean hasAllChars(int[] freq)
    {
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
}
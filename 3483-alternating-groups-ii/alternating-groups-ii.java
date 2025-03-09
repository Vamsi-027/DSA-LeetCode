class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] newColors = new int[colors.length + k - 1];

        for (int i = 0; i < colors.length; i++) {
            newColors[i] = colors[i];
        }

        for (int i = 0; i < k - 1; i++) {
            newColors[i + colors.length] = colors[i];
        }

        int length = newColors.length;
        int result = 0;
        int left = 0;
        int right = 1;
        while(right < length)
        {
            if(newColors[right] == newColors[right-1])
            {
                left = right;
                right++;
                continue;
            }
            right++;
            if(right-left < k) continue;
            else if(right-left == k)
            {
                result++;
                left++;
            }
            else continue;
        }
        return result;
    }
}
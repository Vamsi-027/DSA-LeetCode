class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int maxArea = Integer.MIN_VALUE;
        while(left <= right)
        {

            maxArea = Math.max(maxArea, findArea(left, right, height[left], height[right]));

            if(height[left] > height[right]) right--;
            else left++;
        }

        return maxArea;
    }

    public int findArea(int left, int right, int leftHeight, int rightHeight)
    {
        int breadth = right-left;
        int height = Math.min(leftHeight, rightHeight);

        return breadth * height;
    }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // return linearSearch(matrix, target);
        return binarySearch(matrix, target);
    }

    public boolean linearSearch(int[][] matrix, int target)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[][] matrix, int target)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0; i<rows; i++)
        {
            int leftInd = 0;
            int rightInd = cols-1;
            int left = matrix[i][leftInd];
            int right = matrix[i][rightInd];

            if(left <= target && right >= target)
            {
                while(leftInd <= rightInd)
                {
                    int midInd = leftInd + (rightInd-leftInd)/2;
                    if(matrix[i][midInd] == target) return true;
                    else if(matrix[i][midInd] < target)
                    {
                        leftInd = midInd+1;
                    }
                    else
                    {
                        rightInd = midInd-1;
                    }
                }
            }
            else continue;
        }
        return false;
    }
}
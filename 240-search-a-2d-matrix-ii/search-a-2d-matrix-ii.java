class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
            1. Start from the top right corner
            2. If curElement > target then we can skip that column, because col is in ascending order
            3. Else we can skip the row
        */
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowInd = 0;
        int colInd = cols-1;
        while(rowInd < rows && colInd >= 0)
        {
            int curEle = matrix[rowInd][colInd];
            if(curEle == target) return true;
            else if(curEle > target)
            {
                colInd--;
            }
            else
            {
                rowInd++;
            }
        }
        return false;
    }
}
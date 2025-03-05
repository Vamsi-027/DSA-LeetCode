class Solution {
    public long coloredCells(int n) {
        return  1 + 2 * (n-1) * (long)n;
    }
}
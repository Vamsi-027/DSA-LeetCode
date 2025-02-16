class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[(2*n)-1];
        boolean[] isNumUsed = new boolean[n+1];
        getLexicographicallyLargestSequence(0, result, isNumUsed, n);
        return result;
    }

    public boolean getLexicographicallyLargestSequence(int index, int[] result, boolean[] isNumUsed, int target)
    {
        if(index == result.length) return true;
       
        if(result[index] != 0)
        {
            return getLexicographicallyLargestSequence(index+1, result, isNumUsed, target);
        }

        for(int i=target; i>=1; i--)
        {
            if(isNumUsed[i]) continue;
            isNumUsed[i] = true;
            result[index] = i;
            if(i == 1)
            {
               if(getLexicographicallyLargestSequence(index+1, result, isNumUsed, target))
               {
                    return true;
               } 
            }
            else if(index+i < result.length && result[index+i] == 0)
            {
                result[index+i] = i;
                if(getLexicographicallyLargestSequence(index+1, result, isNumUsed, target))
                {
                    return true;
                }
                result[index+i] = 0;
            }
            result[index] = 0;
            isNumUsed[i] = false;
        }
        return false;
    }
}
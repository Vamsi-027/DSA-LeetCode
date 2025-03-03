class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i : nums)
        {
            if(i < pivot) left.add(i);
            else if(i > pivot) right.add(i);
        }

        int pivotsSize = nums.length - (left.size() + right.size());
        int[] result = new int[nums.length];
        int ind = 0;
        for(int i : left)
        {
            result[ind] = i;
            ind++;
        }
        while(pivotsSize > 0)
        {
            result[ind] = pivot;
            ind++;
            pivotsSize--;
        }

        for(int i : right)
        {
            result[ind]= i;
            ind++;
        }

        return result;
    }
}
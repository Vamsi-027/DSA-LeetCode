class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for(int i : arr)
        {
            set.add(i);
        }

        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                int prev = arr[j];
                int next = arr[i]+arr[j];
                int len = 2;
                while(set.contains(next))
                {
                    int temp = next;
                    next += prev;
                    prev = temp;
                    len++;
                    result = Math.max(result, len);
                }
            }
        }
        return result;
    }   
}
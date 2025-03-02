class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int ptr1 = 0;
        int ptr2 = 0;
        List<int[]> list = new ArrayList<>();
        
        while(ptr1 < n && ptr2 < m)
        {
            int key1 = nums1[ptr1][0];
            int key2 = nums2[ptr2][0];
            if(key1 == key2)
            {
                list.add(new int[]{key1, nums1[ptr1][1]+nums2[ptr2][1]});
                ptr1++;
                ptr2++;
            }
            else if(key1 < key2)
            {
                list.add(new int[]{key1, nums1[ptr1][1]});
                ptr1++;
            }
            else
            {
                list.add(new int[]{key2, nums2[ptr2][1]});
                ptr2++;
            }
        }

        while(ptr1 < n)
        {
            list.add(new int[]{nums1[ptr1][0], nums1[ptr1][1]});
            ptr1++;
        }

        while(ptr2 < m)
        {
            list.add(new int[]{nums2[ptr2][0], nums2[ptr2][1]});
            ptr2++;
        }

        int[][] result = new int[list.size()][2];
        for(int i=0; i<list.size(); i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }
}
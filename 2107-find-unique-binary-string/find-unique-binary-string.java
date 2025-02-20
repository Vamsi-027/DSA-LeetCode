class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for(String s : nums) set.add(s);

        return recursion(set, "", nums.length);
        // return cantorProof(nums);
    }

    //https://math.stackexchange.com/questions/517151/can-somebody-explain-to-me-cantors-diagonalization-argument

    public String cantorProof(String[] nums) 
    {
        StringBuilder result = new StringBuilder();
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i].charAt(i) == '0') result.append('1');
            else result.append('0');
        }
        return result.toString();
    }

    public String recursion(Set<String> set, String curStr, int n)
    {
        if(curStr.length() == n)
        {
            if(!set.contains(curStr)) return curStr;
            return null;
        }

        String result = recursion(set, curStr+'0', n);
        if(result != null) return result;
        result = recursion(set, curStr+'1', n);
        return result;
    }
}
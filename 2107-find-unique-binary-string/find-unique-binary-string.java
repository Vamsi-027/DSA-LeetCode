class Solution {
    String result;
    public String findDifferentBinaryString(String[] nums) {
        return cantorProof(nums);
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
}
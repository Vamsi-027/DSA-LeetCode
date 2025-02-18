class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> roman = new HashMap<>();
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);
        int ans = 0;
        for(int i=s.length()-1; i>=0; i--)
        {
            int value1 = roman.get(s.charAt(i));
            if(i!=0)
            {
                int value2 = roman.get(s.charAt(i-1));
                if(value1 > value2)
                {
                    ans = ans + (value1-value2);
                    i--;
                }
                else
                {
                    ans = ans + (value1);
                }
            }
            else
            {
                ans = ans+ value1;
            }
        }
        return ans;
    }
}
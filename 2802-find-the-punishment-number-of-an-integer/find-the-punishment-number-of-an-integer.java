class Solution {
    public int punishmentNumber(int n) {
        int result = 0;
        for(int i=1; i<=n; i++)
        {
            int square = i * i;
            if(isPunishmentNumber(String.valueOf(square), i))
            {
                result += square;
            }
        }
        return result;
    }

    public boolean isPunishmentNumber(String s, int target)
    {
        if(s.length() == 0 && target == 0)
        {
            return true;
        }
        if(target < 0)
        {
            return false;
        }
        for(int i=0; i<s.length(); i++)
        {
            String left = s.substring(0,i+1);
            String right = s.substring(i+1);
            int leftInt = Integer.valueOf(left);
            if(isPunishmentNumber(right, target-leftInt))
            {
                return true;
            }
        }
        return false;
    }
}
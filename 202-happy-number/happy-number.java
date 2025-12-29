class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        seen.add(n);

        while(n != 1)
        {
            n = sumSquareDigits(n);
            if(seen.contains(n)) return false;
            seen.add(n);
        }
        return true;
    }

    public static int sumSquareDigits(int number) {
        int sum = 0;
        int tempNumber = number;

        while (tempNumber > 0) {
            int digit = tempNumber % 10;      
            sum += digit * digit;       
            tempNumber = tempNumber / 10;     
        }
        
        return sum;
    }
}
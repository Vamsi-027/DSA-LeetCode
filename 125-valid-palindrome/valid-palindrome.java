class Solution {
    public boolean isPalindrome(String s) {
        String updatedString = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        
        int lp = 0;
        int rp = updatedString.length()-1;
        while(lp < rp)
        {
            if(updatedString.charAt(lp) != updatedString.charAt(rp)) return false;
            lp++;
            rp--;
        }
        return true;
    }
}
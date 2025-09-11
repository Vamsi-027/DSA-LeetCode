class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> vowelsArray = new ArrayList<>();
        for(char c : s.toCharArray())
        {
            if(isVowel(c)) vowelsArray.add(c);
        }

        Collections.sort(vowelsArray);
        String result = "";
        int vowelIndex = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            char curChar = s.charAt(i);
            if(isVowel(curChar))
            {
                result += vowelsArray.get(vowelIndex);
                vowelIndex++;
            }
            else
            {
                result += curChar;
            }
        }
        return result;
    }

    public boolean isVowel(char c)
    {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
        {
            return true;
        }
        return false;
    }
}
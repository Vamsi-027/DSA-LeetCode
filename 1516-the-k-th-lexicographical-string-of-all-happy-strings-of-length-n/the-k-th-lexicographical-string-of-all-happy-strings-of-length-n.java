class Solution {
    List<String> happyStrings = new ArrayList<>();
    public String getHappyString(int n, int k) {
        generateAllHappyStrings(n, "");
        if(happyStrings.size() < k) return "";
        Collections.sort(happyStrings);
        return happyStrings.get(k-1);
    }

    public void generateAllHappyStrings(int n, String curStr)
    {
        if(curStr.length() == n)
        {
            happyStrings.add(curStr);
            return;
        }
        for(char c='a'; c<='c'; c++)
        {
            if(curStr.length() > 0 && c == curStr.charAt(curStr.length()-1)) continue;
            else
            {
                generateAllHappyStrings(n, curStr+c);
            }
        }
    }
}
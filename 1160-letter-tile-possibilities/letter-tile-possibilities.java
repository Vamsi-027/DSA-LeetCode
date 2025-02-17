class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] isUsed = new boolean[tiles.length()];
        genereateAllSequences(tiles, "", set, isUsed);
        return set.size()-1;
    }

    public void genereateAllSequences(String tiles, String curStr, Set<String> set, boolean[] isUsed)
    {
        set.add(curStr);
        for(int i=0; i<tiles.length(); i++)
        {
            if(!isUsed[i])
            {
                isUsed[i] = true;
                genereateAllSequences(tiles, curStr+tiles.charAt(i), set, isUsed);
                isUsed[i] = false;
            }
        }
    }
}
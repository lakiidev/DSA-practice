class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        char[] map = new char[26];
        for(int i = 0;i<26;i++)
        {
            map[order.charAt(i) - 'a'] = (char) ('a' + i);
        }
    
        String prev = translate(words[0],map);

        for(int i = 1;i<words.length;i++)
        {
            String curr = translate(words[i],map);
            if(prev.compareTo(curr)>0) return false;
            prev=curr;
        }
        return true;
    }

    private String translate(String word,char[] map)
    {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) chars[i] = map[chars[i] - 'a'];
        return new String(chars);
    }
}
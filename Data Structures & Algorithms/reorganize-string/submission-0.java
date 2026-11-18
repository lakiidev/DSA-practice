class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;

        int maxLetter = 0;
        for (int i = 1; i < 26; i++)
            if (count[i] > count[maxLetter])
                maxLetter = i;
        if (count[maxLetter] > (n + 1) / 2)
            return "";

        char[] res = new char[n];
        int idx = 0;

        while (count[maxLetter]-- > 0) {
            res[idx] = (char) ('a' + maxLetter);
            idx += 2;
        }

        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0) {
                if (idx >= n)
                    idx = 1;
                res[idx] = (char) ('a' + i);
                idx += 2;
            }
        }
        return new String(res);
    }
}
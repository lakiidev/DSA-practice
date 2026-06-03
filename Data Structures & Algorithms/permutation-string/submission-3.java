class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] countS1 = new int[26];
        for (char c : s1.toCharArray()) {
            countS1[c - 'a']++;
        }
        int[] countS2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            countS2[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (countS1[i] == countS2[i])
                matches++;
        }
        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26)
                return true;
            int r = s2.charAt(right) - 'a';
            if (countS1[r] == countS2[r])
                matches--;
            countS2[r]++;
            if (countS1[r] == countS2[r])
                matches++;
            int l = s2.charAt(left) - 'a';
            if (countS1[l] == countS2[l])
                matches--;
            countS2[l]--;
            if (countS1[l] == countS2[l])
                matches++;
            left++;
        }
        return matches == 26;
    }
}

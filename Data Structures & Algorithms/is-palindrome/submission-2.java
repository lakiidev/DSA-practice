class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int rigth = s.length() - 1;
        while (left < rigth) {
            if (!Character.isLetterOrDigit(s.charAt(left)))
                left++;
            else if (!Character.isLetterOrDigit(s.charAt(rigth)))
                rigth--;
            else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(rigth)))
                    return false;
                left++;
                rigth--;
            }
        }
        return true;
    }
}

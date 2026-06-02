class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left=0;
        int rigth = s.length() - 1;
        while(left<rigth)
        {
            if(s.charAt(left++)!=s.charAt(rigth--)) return false;
        }
        return true;
    }
}

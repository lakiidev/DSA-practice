class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()) return result;
        Map<Character, String> keymap = new HashMap<>();
        keymap.put('2', "abc");
        keymap.put('3', "def");
        keymap.put('4', "ghi");
        keymap.put('5', "jkl");
        keymap.put('6', "mno");
        keymap.put('7', "pqrs");
        keymap.put('8', "tuv");
        keymap.put('9', "wxyz");
        backtrack(digits,keymap,new StringBuilder(),0,result);
        return result;
    }

    private void backtrack(String digits, Map<Character, String> keymap,StringBuilder path,int index,List<String> result)
    {
        if(index==digits.length())
        {
            result.add(path.toString());
            return;
        }

        String letters = keymap.get(digits.charAt(index));
        for(int i=0;i<letters.length();i++)
        {
            path.append(letters.charAt(i));
            backtrack(digits,keymap,path,index+1,result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

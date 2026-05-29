class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groups = new HashMap<>();
        for(String str:strs)
        {
            char[] key = new char[26];
            for (int i = 0; i < str.length(); i++)
            {
                key[str.charAt(i)-'a']++;
            }
            String frequencyKey = new String(key);
            if(!groups.containsKey(frequencyKey))
            {
                groups.put(frequencyKey,new ArrayList<>());
            }
            groups.get(frequencyKey).add(str);
         }
         return new ArrayList<>(groups.values());
    }
}

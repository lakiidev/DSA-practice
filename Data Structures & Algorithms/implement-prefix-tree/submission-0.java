class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    TrieNode()
    {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}


class PrefixTree {
    TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray())
        {
            if(!curr.children.containsKey(c))
            {
                curr.children.put(c,new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray())
        {
            if(!curr.children.containsKey(c))
            {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray())
        {
            if(!curr.children.containsKey(c))
            {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
}




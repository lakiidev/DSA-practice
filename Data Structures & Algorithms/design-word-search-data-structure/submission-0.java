class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchBactrack(word,0,root);
    }

    private boolean searchBactrack(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }
        char c = word.charAt(index);

        if (c != '.') {
            if (!node.children.containsKey(c)) {
                return false;
            }
            return searchBactrack(word, index + 1, node.children.get(c));
        } else {
            for (TrieNode child : node.children.values()) {
                if (searchBactrack(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }
    }
}

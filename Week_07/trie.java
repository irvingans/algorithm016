class Trie {
    class TrieNode {
    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode tn = root;
        for(int i = 0; i < word.length();i++){
            char curLet = word.charAt(i);
            if(!tn.containsKey(word.charAt(i))){
                tn.put(word.charAt(i),new TrieNode());
            }
            tn = tn.get(curLet);
        }
        tn.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode tn = root;
       for(int i=0;i<word.length();i++){
           char curLet = word.charAt(i);
           if(tn.containsKey(curLet)){
               tn = tn.get(curLet);
           }
           else{
               return null;
           }
       }
       return tn;
    }

    public boolean search(String word) {
       TrieNode tn = searchPrefix(word);
       return (tn != null) && tn.isEnd();
    }

     public boolean startsWith(String prefix) {
        TrieNode tn = searchPrefix(prefix);
       return (tn != null);
    }

}

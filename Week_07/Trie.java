package Week7;

class Trie {
    //root 应当是私有的，不能被随意改变
    private TrieNode root;


    /** Initialize your data structure here. */
    // 实例化
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        //将word一个字母一个字母地插入
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        //所有字母都插入了
        node.setEnd();
    }
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLet = word.charAt(i);
            if(node.containsKey(curLet)) {
                node = node.get(curLet);
            } else {
                return null;
            }
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        // 一直到最后，循环结束了，这里要判断它是一个完整的单词吗？还是只是某个单词的一部分
        return node != null && node.getEnd();

    }

    //这样写会使startsWith(String prefix)不能复用
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        /**
         // 这样写如果root是空，就会在node.containsKey报错空指针
         TrieNode node = root;
         for (int i = 0; i < prefix.length(); i++) {
         char ch = prefix.charAt(i);
         if (node.containsKey(ch)) {
         node = node.get(ch);
         } else {
         node = null;
         }
         }
         return node != null;
         */
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

// 对一层的处理, 这一层叫links, 有26个元素，每个元素都是一个TrieNode
class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public TrieNode get(char ch) {
        return links[ch-'a'];
    }

    public boolean containsKey(char ch) {
        return links[ch-'a'] != null;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean getEnd() {
        return isEnd;
    }

    public void put(char ch, TrieNode node) {
        links[ch-'a'] = node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
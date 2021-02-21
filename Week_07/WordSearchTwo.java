package Week7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordSearchTwo {
    TrieNode1 root = new TrieNode1();
    //                  左  右 上 下
    int[] x = new int[]{-1,1, 0, 0};
    int[] y = new int[]{0, 0,-1,1};

    Set<String> set = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {

        for(String str: words) {
            root.insert(str);
        }

        int row = board.length;
        int column = board[0].length;
        boolean[][] visited = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dfs(board, root, i, j, new StringBuilder(), visited);
            }
        }
        return new ArrayList<String>(set);
    }

    //当该点已经被访问过了，traceback->继续判断剩余方向的情况
    //该点没被访问过，在Trie里面吗？->不在，traceback
    // 在Trie里面，是最后一个字母了吗？是，添加到ans里，不是最后一个字母，继续向更深层探索
    // 探索结束，
    public void dfs(char[][] board, TrieNode1 node, int i, int j, StringBuilder builder, boolean[][] visited) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || visited[i][j]) {
            return;
        }

        char currentLetter = board[i][j];
        if (!node.containsKey(currentLetter))
            return;

        builder.append(currentLetter);
    //    System.out.println("i is " + i + ", j is " + j + ", StringBuilder is " + builder);
        visited[i][j] = true; // 第一个终止条件处进行判断，如果字母被扫描过了，直接return
        //找寻当前字母对应的下一个node，注：每个node都是一个26长度的数组
        node = node.get(currentLetter); //最后的时候，node是最后一个字母指代的空串，isEnd是true

        //单词已经找到了
        if(node.getEnd()) {
       //     System.out.println(builder + "单词找到了，" + currentLetter);
            set.add(builder.toString());
        }

        for (int k = 0; k < x.length; k++) {
            dfs(board, node, i + x[k], j + y[k], builder, visited);
        }

     //   System.out.println("清除状态前：" + builder);
        //清除状态
        builder.delete(builder.length()-1, builder.length());
    //    System.out.println("清除状态" + builder + " i is " + i + ", j is " + j);
        visited[i][j] = false;

    }

    // 对一层的处理, 这一层叫links, 有26个元素，每个元素都是一个TrieNode
    class TrieNode1 {
        private TrieNode1[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode1() {
            links = new TrieNode1[R];
        }

        public TrieNode1 get(char ch) {
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

        public void put(char ch, TrieNode1 node) {
            links[ch-'a'] = node;
        }

        public void insert(String word) {
            TrieNode1 node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.containsKey(word.charAt(i))) {
                    //给最后一个字母是一个空串
                    node.put(word.charAt(i), new TrieNode1());
                }
                // 此处是get了最后一个字母指代的空串
                node = node.get(word.charAt(i));
            }
            // 给最后一个字母指代的空串（26长度）设置end为true
            node.setEnd();
        }
    }
}

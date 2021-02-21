package Week7;

import java.util.ArrayList;
import java.util.List;

public class WordSearchTwoTest {
    public static void main(String[] args) {
        WordSearchTwo t = new WordSearchTwo();

//        char[][] board = new char[][]{{'o','a','a','n'},
//                                    {'e','t','a','e'},
//                                    {'i','h','k','r'},
//                                    {'i','f','l','v'}};
//        String[] words = {"oath","pea","eat","rain"};


        char[][] board = new char[][]{  {'o','a','a','n'},
                                        {'e','t','a','e'},
                                        {'i','h','k','r'},
                                        {'i','f','l','v'} };
        String[] words = {"oath","pea","eat","rain","hklf", "hf"};

        List<String> list = t.findWords(board,words);

        for(String s: list) {
            System.out.println(s);

        }
    }
}

package Week7;

public class NumberOfIslandsDFSTest {
    public static void main(String[] args) {
        NumberOfIslandsDFS n = new NumberOfIslandsDFS();

        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};
        int res = n.numIslands(grid);
        System.out.println(res);
    }
}

package Week7;

public class NumberOfIslandsDFS {
    // 上下左右
    int[] x = {0, 0, -1, 1};
    int[] y = {1, -1, 0, 0};
    int count = 0;
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //只有节点没有被访问过的时候才能调用方法findIsland()
                if (!visited[i][j] && grid[i][j] == '1'){
                    System.out.println("遍历新的节点");
                    findIsland(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void findIsland(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return;

        if (grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        System.out.println("i: " + i + ", j: " + j + ", visited[" + i + "][" + j + "]" + visited[i][j]);
        for (int k = 0; k < 4; k++) {
            findIsland(grid, visited, i + x[k], j + y[k]);
            System.out.println("i is: " + (i+x[k]) + ", j is: " + (j + y[k]));
            System.out.println("TRACEBACK");
        }
    }
}

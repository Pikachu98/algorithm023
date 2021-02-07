package Week6;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m][n];
        // 处理一下第一行和第一列
        for (int i = 0; i < n; i++) {
            if (i != 0)
                res[0][i] = grid[0][i] + res[0][i-1];
            else
                res[0][i] = grid[0][i];
        }

        for (int j = 0; j < m; j++) {
            if (j != 0)
                res[j][0] = grid[j][0] + res[j-1][0];
            else
                res[j][0] = grid[j][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i][j-1], res[i-1][j]) + grid[i][j];
            }
        }

        return res[m-1][n-1];
    }
}

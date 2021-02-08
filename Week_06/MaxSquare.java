package Week6;

public class MaxSquare {
    public static int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int maxSide = 0;

        int[][] res = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    if (i == 0 || j== 0) {
                        res[i][j] = 1;
                    } else {
                        int min = Math.min(Math.min(res[i-1][j] , res[i][j-1]) , res[i-1][j-1]);
                        res[i][j] = min + 1;
                    }
                    maxSide = Math.max(maxSide, res[i][j]);
                }
            }
        }


        return (int)(Math.pow(maxSide, 2));

    }

    public static void main(String[] args) {
        char[][] c = {{'0','1'},{'1','0'}};
        int res = maximalSquare(c);
        System.out.println(res);
    }
}

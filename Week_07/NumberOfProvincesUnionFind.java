package Week7;

public class NumberOfProvincesUnionFind {
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected.length);

        for (int i = 0; i < isConnected.length-1; i++) {
            for (int j = i + 1; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1)
                    uf.union(i, j);
            }
        }

        return uf.getCount();
    }
}

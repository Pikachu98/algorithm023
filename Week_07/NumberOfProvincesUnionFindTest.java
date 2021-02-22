package Week7;

public class NumberOfProvincesUnionFindTest {

    public static void main(String[] args) {
        NumberOfProvincesUnionFind npuf = new NumberOfProvincesUnionFind();

        int[][] isConneted = {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(npuf.findCircleNum(isConneted));
    }
}

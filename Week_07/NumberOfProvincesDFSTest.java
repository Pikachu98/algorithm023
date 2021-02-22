package Week7;

public class NumberOfProvincesDFSTest {
    public static void main(String[] args) {
        NumberOfProvincesDFS num = new NumberOfProvincesDFS();
        int[][] isConneted = {{1,1,0},{1,1,0},{0,0,1}};
        int res = num.findCircleNum(isConneted);
        System.out.println(res);

    }
}

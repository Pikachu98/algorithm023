package Week7;

public class NumberOfProvincesDFS {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            // 如果当前点没有被访问过
            if (!visited[i]) {
                System.out.println("第"+ i +"个人没有被访问过");
                dfs(visited, isConnected, i);
                count++;
            }
        }

        return count;
    }

    public void dfs (boolean[] visited, int[][] isConnected, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            System.out.println("i: " + i + ", j: " + j + ", visited[" + j + "]" + visited[j]);
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                System.out.println("因为isCnnected[" + i + "][" + j + "] is " + isConnected[i][j]+ ", visited[" + j + "]" + visited[j] + "\n进入dfs下一个循环");
                dfs(visited, isConnected,j);
                System.out.println("开始回退");
            }
        }
    }

}

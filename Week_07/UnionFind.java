package Week7;

public class UnionFind {
    // 最开始的时候这个count是size，最后随着不断的合并（每次一合并，count--）而减小
    private int count;
    private int[] parent;

    // 构造方法，初始化
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p]; //这里无关对象的指代
        }
        return p;
    }

    public void union (int p, int q) {
        System.out.println(">>>>");
        int rootP = find(p);
        int rootQ = find(q);
        System.out.println("p: " + p + ",q: " + q + ", count: " + count);

        if (rootP == rootQ)
            return;

        parent[rootQ] = rootP;
        count--;

    }

    public int getCount() {
        return count;
    }
}

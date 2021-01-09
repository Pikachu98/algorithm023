package Week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a Node.


public class NaryTreeLevelOrderTraversal {
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        // 因为我们从根节点开始遍历树，然后向下搜索最接近根节点的节点，这是广度优先搜索
        // queue,先进先出
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                // 依次弹出队列第一个node
                Node currentNode = queue.poll();
                // 第一个node的值添加进来
                list.add(currentNode.val);

                for (Node child: currentNode.children)
                    queue.add(child);
            }
            res.add(list);
        }
        return res;
    }
}

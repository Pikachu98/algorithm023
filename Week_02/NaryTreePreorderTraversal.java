package Week2;

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
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

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();

        return list;
    }
    // 把递归单独拿出来,将结果list作为参数传进来
    public void pre(Node root, List<Integer> list) {
        // 已经循环到底层叶子节点，当前递归结束
        if (root == null)
            return;

        // 前序遍历，先把root的值填进来
        list.add(root.val);

        // 再来遍历root的子节点们
        for (Node node: root.children) {
            //把子节点再放到pre()方法里进行遍历
            pre(node, list);
        }
    }
}

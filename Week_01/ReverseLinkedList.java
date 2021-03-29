package Week1;
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedList {
    public ListNode reverseList1(ListNode head) {
         // 迭代：迭代是函数内某段代码实现循环
         // 先声明要循环的两个“指针”
         ListNode prev = null;
         ListNode cur = head;

         while (cur != null) {
             // 先把当前节点的下一个节点保存，然后再给下一个节点赋予新的值
             ListNode next = cur.next;
             // 调转方向
             cur.next = prev;

             // 指针后移
             prev = cur;
             cur = next;
         }
         // 最后cur是null了，prev是原list的最后一个元素，也是新的list的第一个元素
         return prev;
     }

    public ListNode reverseList(ListNode head) {
        // 先写结束条件
        if (head == null || head.next == null) {
//            System.out.println("结束" + head.val);
            return head;
        }
        // p 接收的是结束条件给的那个head，也就是找到原list的最后一位，新list的第一位，进行返回，这也是为什么后面的操作与p无关
        ListNode p = reverseList(head.next);
//        System.out.println(head.val);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

class ReverseLinkedListTest {
    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode res = rll.reverseList(node1);

//        System.out.println(res.val);
//        System.out.println(res.next.val);
    }
}
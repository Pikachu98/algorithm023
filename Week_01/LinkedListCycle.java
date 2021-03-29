package Week1;


import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    // Solution1: HashSet(不允许重复元素）
    public boolean hasCycle1(ListNode1 head) {
        Set<ListNode1> set = new HashSet<>();

        while (head != null) {
            if (!set.add(head))
                return true;
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle(ListNode1 head) {
        if (head == null || head.next == null)
            return false; // 无环

        ListNode1 turtle = head;
        ListNode1 rabbit = head.next;

        // 这么写肯定错了。。。这样的话就只判断rabbit !=null 就行了，后面容易超出指针
//        while (rabbit != null || rabbit.next != null) {
//            if (rabbit == turtle)
//                return true;
//            turtle = turtle.next;
//            rabbit = rabbit.next.next;
//        }
//        return false;
        // 这里判读循环的条件应该是兔子和乌龟相不相等
        while (rabbit != turtle) {
            // 如果兔子或者兔子的下一个节点是null，那么无环，同时，这样写避免了指针超出
            if (rabbit == null || rabbit.next == null)
                return false;

            rabbit = rabbit.next.next;
            turtle = turtle.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode1 node1 = new ListNode1(3);
        ListNode1 node2 = new ListNode1(2);
        ListNode1 node3 = new ListNode1(0);
        ListNode1 node4 = new ListNode1(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        LinkedListCycle llc1 = new LinkedListCycle();
        System.out.println(llc1.hasCycle1(node1));
    }
}
class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1 (int x) {
        this.val = x;
        next = null;
    }
}
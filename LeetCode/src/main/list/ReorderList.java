package list;

import java.util.Stack;

public class ReorderList {

    public static void main(String[] args) {

       ListNodeBuilder listNodeBuilder = new ListNodeBuilder();
       listNodeBuilder.append(1).append(2).append(3).append(4).append(5);

       ListNode head = listNodeBuilder.toListNode();

       reorderList(head);

       System.out.println(head);

    }



    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        Stack<ListNode> stack = new Stack<>();

        int sum = pushToStack(head, stack);

        int halfSum = sum/2;

        ListNode node = head;

        int count = 0;
        while (count++ < halfSum) {
            ListNode tempNode = node.next;
            node.next = stack.pop();
            node.next.next = tempNode;
            node = node.next.next;
        }

        if (sum%2 == 0) {
            node.next.next = null;
        }else {
            node.next = null;
        }

    }

    private static int pushToStack(ListNode head, Stack<ListNode> stack) {
        ListNode node = head;
        int result = 0;
        while (node != null) {
            result++;
            stack.push(node);
            node = node.next;
        }
        return result;
    }
}

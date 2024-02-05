package LinkedList;

public class RotateLinkedList {

    public static ListNode rotateList(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int len = 0;
        ListNode current = head;
        ListNode tail = head;

        while (current != null) {
            len++;
            tail = current;
            current = current.next;
        }

        int move = k % len;
        if (move == 0)
            return head;

        move = len - move;
        current = head;
        int currentMove = 1;

        while (current != null) {
            if (currentMove == move)
                break;
            currentMove++;
            current = current.next;
        }
        tail.next = head;
        if (current != null) {
            head = current.next;
            current.next = null;
        }

        return head;
    }
}


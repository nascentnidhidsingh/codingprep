package LinkedList;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode prev = null;
        ListNode next;

        if (head == null || head.next == null)
            return head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}

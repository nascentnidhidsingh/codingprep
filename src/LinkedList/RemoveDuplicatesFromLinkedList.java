package LinkedList;

public class RemoveDuplicatesFromLinkedList {
    public ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode current = head;

        while (current != null && current.next != null) {
            ListNode newNode = current.next;

            while (newNode != null && current.val == newNode.val)
                newNode = newNode.next;
            current.next = newNode;
            current = current.next;
        }
        return head;
    }
}

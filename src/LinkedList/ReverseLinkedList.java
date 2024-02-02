package LinkedList;

public class ReverseLinkedList {
    public Node reverseList(Node head) {

        Node current = head;
        Node prev = null;
        Node next = null;

        if (head == null)
            return null;

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

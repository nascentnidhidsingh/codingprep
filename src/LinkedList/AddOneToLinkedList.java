package LinkedList;

public class AddOneToLinkedList {

    public static ListNode addOne(ListNode head) {

        if (head == null)
            return head;

        head = reverse(head);
        ListNode current = head;
        int carry = 1;

        while (current != null) {
            current.val = carry + current.val;
            if (current.val < 10) {
                carry = 0;
                break;
            } else {
                current.val = 0;
                carry = 1;
            }
            current = current.next;
        }
        if (carry == 1) {
            head = reverse(head);
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            return newNode;
        }
        return reverse(head);
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        ListNode one = new ListNode(9);
        ListNode two = new ListNode(9);
        ListNode three = new ListNode(9);
        ListNode four = new ListNode(9);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        head = addOne(head);
        printNodeData(head);
    }

    public static void printNodeData(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

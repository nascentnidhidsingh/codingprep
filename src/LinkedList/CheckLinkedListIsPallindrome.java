package LinkedList;

import static LinkedList.ReverseLinkedList.reverseList;

public class CheckLinkedListIsPallindrome {

    public static void main(String[] args) {
        ListNode e = new ListNode(1);
        ListNode f = new ListNode(2, e);
        ListNode d = new ListNode(3, f);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode head = new ListNode(1, b);

        System.out.println("The LinkedList : ");
        printNodeData(head);
        System.out.println();
        System.out.println("Is LinkedList pallindrome " + isPallindrome(head));
        System.out.println();
        System.out.println("The LinkedList : ");
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

    public static boolean isPallindrome(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverseList(slow.next);
        ListNode first = head;
        ListNode second = newHead;

        while (second != null) {
            if (first.val != second.val) {
                reverseList(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseList(newHead);
        return true;
    }
}

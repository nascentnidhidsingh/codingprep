package LinkedList;

public class IntersectionOfTwoLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        ListNode head1 = headA;
        ListNode head2 = headB;

        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;

            if (head1 == head2)
                return head1;

            if (head1 == null)
                head1 = headB;

            if (head2 == null)
                head2 = headA;
        }
        return head1;
    }
}


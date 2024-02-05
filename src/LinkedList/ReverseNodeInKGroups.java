package LinkedList;

public class ReverseNodeInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null)
            return head;

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if (kthNode == null) {
                if (prev != null)
                    prev.next = temp;
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseLinkedlist(temp);
            if (temp == head)
                head = kthNode;
            else
                prev.next = kthNode;

            prev = temp;
            temp = nextNode;
        }
        return head;
    }

    public static ListNode findKthNode(ListNode head, int k) {
        int count = 0;
        while (head != null) {
            count++;
            if (count == k)
                break;
            head = head.next;
        }
        return head;
    }

    public static ListNode reverseLinkedlist(ListNode temp) {
        ListNode current = temp;
        ListNode next = null;
        ListNode prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

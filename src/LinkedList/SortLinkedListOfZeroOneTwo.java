package LinkedList;

import static LinkedList.Node.printNodeData;

public class SortLinkedListOfZeroOneTwo {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node one = new Node(2);
        Node two = new Node(1);
        Node three = new Node(0);
        Node four = new Node(0);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        System.out.print("Data before deletion : ");
        printNodeData(head);
        Node temp = sortLinkedListOfZeroOneTwo(head);
        printNodeData(temp);
    }

    private static Node sortLinkedListOfZeroOneTwo(Node head) {
        if (head == null || head.next == null)
            return head;

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node current = head;

        while (current != null) {
            if (current.data == 0) {
                zero.next = current;
                zero = zero.next;
            } else if (current.data == 1) {
                one.next = current;
                one = one.next;
            } else {
                two.next = current;
                two = two.next;
            }
            current = current.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead;
        one.next = (twoHead.next != null) ? twoHead.next : null;
        two.next = null;
        return zeroHead.next;
    }
}

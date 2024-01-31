package LinkedList;

import static LinkedList.Node.printNodeData;

public class NodeDeletion {

    public static void main(String[] args) {
        Node head = new Node(4);
        Node one = new Node(5);
        Node two = new Node(2);
        Node three = new Node(1);
        Node four = new Node(4);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        System.out.print("Data before deletion : ");
        printNodeData(head);
        deletion(head, 4);
        System.out.println();
        System.out.print("Data after deletion : ");
        printNodeData(head);
    }

    private static Node deletion(Node head, int position) {
        if (head == null || position == 1)
            return null;

        Node prev = null;
        Node current = head;
        int count = 0;

        while (current != null) {
            count++;
            if (count == position) {
                prev.next = prev.next.next;
            }
            prev = current;
            current = current.next;
        }
        return head;
    }
}

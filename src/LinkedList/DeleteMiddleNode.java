package LinkedList;

import static LinkedList.Node.printNodeData;

class DeleteMiddleNode {
    public static void deleteMiddle(Node head) {

        if (head == null || head.next == null)
            return;

        if (head.next.next == null) {
            head.next = null;
            return;
        }

        Node slow = head;
        Node prev = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null)
            prev.next = prev.next.next;
        else
            slow.next = slow.next.next;
    }

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
        deleteMiddle(head);
        System.out.println();
        System.out.print("Data after deletion : ");
        printNodeData(head);
    }
}
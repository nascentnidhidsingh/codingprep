package LinkedList;

import static LinkedList.Node.printNodeData;

public class InsertionNode {

    public static void insertion(Node head, int k) {

        if (k == 1) {
            Node newNode = new Node();
            head = newNode;
        }

        //1->2->3->4, 3rd pos, 1->2->data->3->4

        int count = 0;
        Node current = head;
        Node prev = head;

        while (current != null) {
            count++;
            if (count == k - 1) {
                Node newNode = new Node();
                newNode.next = current.next;
                current.next = newNode;
            }
            current = current.next;
        }
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
        System.out.print("Data before insertion : ");
        printNodeData(head);
        insertion(head, 6);
        System.out.println();
        System.out.print("Data after insertion : ");
        printNodeData(head);
    }
}

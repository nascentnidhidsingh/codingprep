package LinkedList;

import static LinkedList.Node.printNodeData;

public class DeleteCurrentNode {
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
        deleteNode(three);
        System.out.println();
        System.out.print("Data after deletion : ");
        printNodeData(head);
    }
    public static void deleteNode(Node node) {

        if (node == null || node.next == null)
            return;

        if (node.next.next == null) {
            node.data = node.next.data;
            node.next = null;
        }
        Node prev = node;

        while (node.next != null) {
            prev = node;
            node.data = node.next.data;
            node = node.next;
        }
        prev.next = null;
    }
}

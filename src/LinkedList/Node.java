package LinkedList;

class Node {
    int data;
    Node next;

    private Node(int val, Node next) {
        this.data = val;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }

    public static void main(String[] args) {

        int[] ar = {2, 3, 4, 5, 6};

        Node head = convertArrayToLinkedList(ar);
        printNodeData(head);
        System.out.println("Length of the LinkedList : " + lengthOflL(head));
        System.out.println("Is 5 present in LinkedList : " + searchInLL(head, 5));
        head = deleteHead(head);
        printNodeData(head);
        head = deleteTail(head);
        printNodeData(head);

    }

    public Node() {
    }

    public static void printNodeData(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private static Node convertArrayToLinkedList(int[] ar) {
        Node head = new Node(ar[0], null);
        Node current = head;
        for (int i = 1; i < ar.length; i++) {
            Node newNode = new Node(ar[i]);
            current.next = newNode;
            current = current.next;
        }
        return head;
    }

    private static int lengthOflL(Node head) {
        Node current = head;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private static boolean searchInLL(Node head, int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data)
                return true;
            current = current.next;
        }
        return false;
    }

    private static Node deleteHead(Node head) {
        //automatic garbage collection
        head = head.next;
        return head;
    }

    private static Node deleteTail(Node head) {
        Node current = head;
        if (head == null || head.next == null)
            return null;
        while (current.next.next != null)
            current = current.next;
        current.next = null;
        return head;
    }
}

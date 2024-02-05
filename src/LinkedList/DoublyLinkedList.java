package LinkedList;

class DoublyLinkedList {
    int data;
    DoublyLinkedList next;
    DoublyLinkedList prev;


    public DoublyLinkedList(int val, DoublyLinkedList next, DoublyLinkedList prev) {
        this.data = val;
        this.next = next;
        this.prev = prev;
    }

    public DoublyLinkedList(int data) {
        this.data = data;
    }

    public DoublyLinkedList() {
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 5, 6, 4, 3};
        DoublyLinkedList head = arrayToDLL(ar);
        System.out.println("Data : ");
        printDoublyLLData(head);
//        System.out.println("Data after deletion : ");
//        deleteTailDLL(head);
//        deleteAnyElementDLL(head, 3);
//        printDoublyLLData(head);
//        head = deleteAnyElementDLL(head, 2);
//        printDoublyLLData(head);
        head = insertBeforeHead(head, 500);
        printDoublyLLData(head);
        insertInDLL(head, 500, 3);
        printDoublyLLData(head);

    }

    public static DoublyLinkedList arrayToDLL(int[] ar) {

        if (ar == null || ar.length == 0)
            return null;

        DoublyLinkedList head = new DoublyLinkedList(ar[0]);
        DoublyLinkedList current = head;

        for (int i = 1; i < ar.length; i++) {
            DoublyLinkedList node = new DoublyLinkedList(ar[i]);
            node.prev = current;
            current.next = node;
            current = current.next;
        }
        return head;
    }

    public static void printDoublyLLData(DoublyLinkedList head) {
        DoublyLinkedList current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private static DoublyLinkedList deleteHeadDLL(DoublyLinkedList head) {

        DoublyLinkedList prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }

    private static DoublyLinkedList deleteTailDLL(DoublyLinkedList head) {

        DoublyLinkedList tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }
        DoublyLinkedList prev = tail.prev;
        tail.prev = null;
        prev.next = null;
        return head;
    }

    public static DoublyLinkedList deleteAnyElementDLL(DoublyLinkedList head, int k) {
        int count = 0;
        DoublyLinkedList current = head;

        while (current != null) {
            count++;
            if (count == k)
                break;
            current = current.next;
        }
        DoublyLinkedList prev = current.prev;
        DoublyLinkedList next = current.next;

        if (prev == null && next == null)
            return null;
        else if (prev == null)
            deleteHeadDLL(head);
        else if (next == null)
            deleteTailDLL(head);
        else {
            prev.next = current.next;
            current.prev = prev;
        }
        return head;
    }

    private static DoublyLinkedList insertInDLL(DoublyLinkedList head, int val, int k) {

        if (k == 1) {
            insertBeforeHead(head, val);
            return head;
        }

        DoublyLinkedList current = head;
        int count = 0;

        while (current != null) {
            count++;
            if (count == k)
                break;
            current = current.next;
        }

        DoublyLinkedList dll = new DoublyLinkedList(val);
        DoublyLinkedList prev = current.prev;
        prev.next = dll;
        dll.prev = prev;
        dll.next = current;
        current.prev = dll;

        return head;
    }

    private static DoublyLinkedList insertBeforeHead(DoublyLinkedList head, int val) {

        DoublyLinkedList newHead = new DoublyLinkedList(val, head, null);
        head.prev = newHead;

        return newHead;
    }
}

package LinkedList;

import static LinkedList.DoublyLinkedList.arrayToDLL;
import static LinkedList.DoublyLinkedList.printDoublyLLData;

public class RemoveDuplicatesInDLL {

    public static DoublyLinkedList removeDuplicates(DoublyLinkedList head) {
        if (head == null || head.next == null)
            return head;

        DoublyLinkedList temp = head;

        while (temp != null && temp.next != null) {
            DoublyLinkedList nextNode = temp.next;
            while (nextNode != null && nextNode.data == temp.data) {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if (nextNode != null)
                nextNode.prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 3, 3};
        DoublyLinkedList head = arrayToDLL(ar);
        removeDuplicates(head);
        printDoublyLLData(head);
    }
}

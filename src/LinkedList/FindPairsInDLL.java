package LinkedList;

import java.util.HashMap;
import java.util.Map;

import static LinkedList.DoublyLinkedList.arrayToDLL;

public class FindPairsInDLL {

    public static Map findPairs(DoublyLinkedList head, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        DoublyLinkedList start = head;
        DoublyLinkedList end = head;
        while (end.next != null) {
            end = end.next;
        }

        while (start.data < end.data) {
            int sum = start.data + end.data;
            if (sum == target) {
                map.put(start.data, end.data);
                start = start.next;
                end = end.prev;
            } else if (sum < target) {
                start = start.next;
            } else {
                end = end.prev;
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 9};
        DoublyLinkedList head = arrayToDLL(ar);
        System.out.println(findPairs(head, 5));
    }
}

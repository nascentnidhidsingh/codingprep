//You are given the heads of two sorted linked lists list1 and list2.
//
//Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//Return the head of the merged linked list.
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null)
            return null;

        if (list1 == null)
            return list2;

        if (list1 != null && list2 == null)
            return list1;

        ListNode start1 = list1;
        ListNode start2 = list2;

        ListNode dummy_node = new ListNode(-1);
        ListNode temp = dummy_node;

        while (start1 != null && start2 != null) {
            if (start1.val < start2.val) {
                temp.next = start1;
                temp = start1;
                start1 = start1.next;
            } else {
                temp.next = start2;
                temp = start2;
                start2 = start2.next;
            }
        }

        if (start1 != null)
            temp.next = start1;
        if (start2 != null)
            temp.next = start2;

        return dummy_node.next;
    }
}

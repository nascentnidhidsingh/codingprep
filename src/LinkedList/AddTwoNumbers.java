package LinkedList;

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//        Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//
//
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy_head = new ListNode(0);
        ListNode l3 = dummy_head;

        int carry = 0;

        while (l1 != null || l2 != null) {

            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = carry + digit1 + digit2;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode curr = new ListNode(digit);
            l3.next = curr;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            l3 = l3.next;
        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            l3.next = node;
            l3 = l3.next;
        }
        return dummy_head.next;
    }
}
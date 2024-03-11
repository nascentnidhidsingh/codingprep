package Recursion;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(findHeight(root));
    }

    private static int findHeight(Node head) {
        if (head == null)
            return 0;
        int leftHeight = findHeight(head.left);
        int rightHeight = findHeight(head.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

//    private static int findHeight(Node head) {
//        Queue<Node> queue = new LinkedList<>();
//        if (head == null)
//            return 0;
//        int count = 0;
//        queue.add(head);
//        while (!queue.isEmpty()) {
//            List<Integer> currentLevel = new ArrayList<>();
//            int size = queue.size();
//            for (int i = 1; i <= size; i++) {
//                Node current = queue.remove();
//                currentLevel.add(current.data);
//                if (current.left != null) {
//                    queue.add(current.left);
//                }
//                if (current.right != null) {
//                    queue.add(current.right);
//                }
//            }
//            count++;
//        }
//        return count;
//    }
}

class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public Node(Node left, Node right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }
}

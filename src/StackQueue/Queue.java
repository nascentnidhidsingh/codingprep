package StackQueue;

public class Queue {
    int start = -1;
    int end = -1;
    int capacity = 5;
    int count = 0;
    int[] ar = new int[capacity];

    void push(int element) {
        if (count > capacity)
            return;
        end++;
        ar[end] = element;
        count++;
    }

    int pop() {
        if (count == 0)
            return -1;
        start++;
        int e = ar[start];
        count--;
        return e;
    }

    int size() {
        return count;
    }

    boolean isEmpty() {
        return count == 0;
    }

    int peek() {
        if (count > 0){
            start = 0;
        }
        return ar[start];
    }


    public static void main(String[] args) {
        Queue q = new Queue();
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println(q.isEmpty());
    }
}

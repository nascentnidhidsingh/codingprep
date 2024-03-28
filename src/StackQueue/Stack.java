package StackQueue;

public class Stack {
    int[] ar = new int[100000];
    int top = -1;

    public void push(int element) {
        top += 1;
        ar[top] = element;
    }

    public int pop() {
        int element = ar[top];
        top -= 1;
        return element;
    }

    public int length() {
        return top + 1;
    }

    public int top() {
        if (top != -1)
            return ar[top];
        return -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }


    public static void main(String[] args) {
        Stack s = new Stack();
        System.out.println(s.isEmpty());
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.isEmpty());
        System.out.println(s.length());
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.top());
    }
}

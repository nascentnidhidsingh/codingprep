package StackQueue;

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void enqueue(int element) {
        input.push(element);
    }

    public int dequeue() {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
        return output.pop();
    }

    public int peekOfQueue() {
        while (!input.isEmpty()) {
            output.push(input.peek());
            input.pop();
        }
        int ele = output.pop();
        output.push(ele);
        while (!output.isEmpty()) {
            input.push(output.peek());
            output.pop();
        }
        return ele;
    }

    public int sizeOfQueue() {
        return input.size();
    }

    public static void main(String[] args) {
        QueueUsingStacks obj = new QueueUsingStacks();
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);
        System.out.println(obj.sizeOfQueue());
        System.out.println(obj.peekOfQueue());
        System.out.println(obj.dequeue());
        System.out.println(obj.peekOfQueue());
        System.out.println(obj.sizeOfQueue());
    }
}

package StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q = new LinkedList<>();

    public int pop() {
        return q.poll();
    }

    public void push(int element) {
        q.add(element);
        for (int i = 0; i < q.size() - 1; i++){
            q.add(q.remove());
        }
    }

    public int size() {
        return q.size();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return (q.isEmpty());
    }

    public static void main(String[] args) {
        StackUsingQueue s = new StackUsingQueue();
        System.out.println(s.empty());
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.empty());
        System.out.println(s.size());
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.top());
    }
}

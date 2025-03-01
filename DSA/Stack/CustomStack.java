package DSA.Stack;

public class CustomStack {
    Node head;
    int size = 0;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        int val = head.data;
        if(isEmpty()) {
            return -1;
        }
        size--;
        if(head.next == null) {
            head = null;
            return val;
        }
        head = head.next;
        return val;
    }

    public int peek() {
        if(isEmpty()) {
            return -1; 
        }
        return head.data;
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(9);

        while(!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop(); 
        }
    }
}

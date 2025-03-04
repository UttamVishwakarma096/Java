package DSA.Queue;

public class Queue {
    Node head;
    Node tail;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
 
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public int remove() {
        if(isEmpty()) {
            return -1;
        }
        int val = head.data;
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
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}

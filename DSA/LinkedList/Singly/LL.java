package DSA.LinkedList.Singly;

import java.util.Scanner;

public class LL {
    Node head;
    private int size;

    LL() {
        this.size = 0;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void printList() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public void deleteFirst() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        size--;
        head = head.next;
    }

    public void deleteLast() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        size--;
        if(head.next == null) {
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = secondLast.next;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    public int getSize() {
        return size;
    }

    public void reverseIterative() {
        if(head == null || head.next == null) {
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            

            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public Node reverseRecursive(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public boolean hasCircle(Node head) {
        if(head == null) {
            return false;
        }
        Node hare = head;
        Node turtle = head;

        while(hare.next != null || hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
            if(hare == turtle) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        LL list = new LL();
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter no of Nodes: ");
            int num = scan.nextInt();

            for(int i = 0; i < num; i++) {
                list.addLast(scan.next());
            }
        }
        list.printList();
        list.head = list.reverseRecursive(list.head);
        list.printList();
    }
}

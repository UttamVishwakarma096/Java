package DSA.LinkedList.Doubly;

import java.util.Scanner;

public class DoublyLL {
    Node head;
    Node tail;
    
    class Node {
        private int data;
        private Node next;
        private Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        Node currNode = tail;
        currNode.next = newNode;
        newNode.prev = currNode;
        tail = newNode;
    }

    public void printList() {
        if(head == null) {
            System.out.println("list is Empty");
            return;
        }
        Node currNode = head;
        System.out.print("null <-> ");
        while(currNode != null) {
            System.out.print(currNode.data+" <-> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public void printReverse() {
        if(tail == null) {
            System.out.println("list is Empty");
            return;
        }
        Node currNode = tail;
        while(currNode != null) {
            System.out.print(currNode.data+" <-> ");
            currNode = currNode.prev;
        }
        System.out.println("null");
    }

    public void delete(int data) {
        if(head == null) {
            return;
        }
        if(head.next == null) {
            head = null;
            return;
        }
        Node secondNode = head;
        Node lastNode = secondNode.next;
        while(lastNode.data != data) {
            lastNode = lastNode.next;
            secondNode = secondNode.next;
        }
        secondNode.next = lastNode.next;
        lastNode.next.prev = secondNode;
        lastNode.next = null;
        lastNode.prev = null;
    }
    public static void main(String[] args) {
        DoublyLL list = new DoublyLL();
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter no of nodes: ");
            int nodes = scan.nextInt();
            
            for(int i = 0; i < nodes; i++) {
                list.addLast(scan.nextInt());
            }
            list.printList();
            System.out.print("enter number to delete : ");
            list.delete(scan.nextInt());
            list.printList();
        }
    }
}

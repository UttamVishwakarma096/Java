package DSA.LinkedList.HomeWork;

import java.util.Scanner;

public class LL {
    Node head;
    private int idx = 0;
    private int size = 0;

    class Node {
        private final int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
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
            System.out.println("list is Empty");
            return;
        }
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public int getIndex(int data) {
        Node currNode = head;
        while(currNode.data != data) {
            currNode = currNode.next;
            idx++;
        }
        int i = idx;
        idx = 0;
        return i;
    }

    public void deleteMoreThen(int data) {
        Node currNode = head;
        Node secondNode = currNode.next;
        while(currNode.next != null) {
            if(secondNode.data > data) {
                secondNode = secondNode.next;
                currNode.next = secondNode;
            }
            secondNode = secondNode.next;
            currNode = currNode.next;
        }
    }

    public void deleteData(int data) {
        Node currNode = head;
        Node secondNode = currNode.next;
        while(currNode.next != null) {
            if(secondNode.data == data) {
                secondNode = secondNode.next;
                currNode.next = secondNode;
            }
            secondNode = secondNode.next;
            currNode = currNode.next;
        }
        size--;
    }

    public int getSize() {
        return size;
    }

    public int getData(Node currNode) {
        return currNode.data;
    }

    public LL reversedList(LL list) {
        LL newList = new LL();
        int size = list.getSize();
        Node currNode = head;

        while(size > 0) {
            newList.addFirst(list.getData(currNode));
            currNode = currNode.next;
            size--;
        }
        return newList;
    }


    public boolean isPalindrome(LL list) {
        LL list2 = reversedList(list);
        Node currNode1 = list.head;
        Node currNode2 = list2.head;

        while(currNode1.next != null) {
            if(list.getData(currNode1) != list2.getData(currNode2)) {
                return false;
            }
            currNode1 = currNode1.next;
            currNode2 = currNode2.next;
        }
        return true;
    }
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            LL list = new LL();
            System.out.print("Enter no of Nodes: ");
            int num = scan.nextInt();

            for(int i = 0; i < num; i++) {
                list.addLast(scan.nextInt());
            }

            System.out.print("Orignal list: ");
            list.printList();

            LL list2 = list.reversedList(list);
            System.out.print("Reversed list: ");
            list2.printList();

            System.out.println("is Palindrome: "+list.isPalindrome(list));
        }
    }
}

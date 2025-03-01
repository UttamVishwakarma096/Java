package DSA.LinkedList.Circuler;

public class CirculerLL {
    Node head;
    Node tail;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
            return;
        }
        if(head == tail) {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    public void printList() {
        if(head == null) {
            System.out.println("list is Empty");
            return;
        }
        Node currNode = head;
        do { 
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        } while (currNode != head);
    }

    public static void main(String[] args) {
        CirculerLL list = new CirculerLL();
        list.printList();
        list.add(3);
        list.add(5);
        list.add(45);
        list.add(6);
        list.printList();
    }
}

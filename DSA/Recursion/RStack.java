package DSA.Recursion;

public class RStack { //Deleting Middle Element
    Node head;        //of Stack
    private int Size = 0;
    
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            Size++;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if(head == null) {
            return -1;
        }
        Size--;
        int val = head.data;
        head = head.next;
        return val;
    }

    public int peek() {
        if(head == null) {
            return -1;
        }
        return head.data;
    }

    public void printStack() {
        Node currNode = head;
        while(currNode != null) {
            System.out.println("|"+currNode.data+"|");
            currNode = currNode.next;
        }
    }

    public int getSize() {
        return Size;
    }

    public int Mid(int size) {
        if((size & 1) == 0) {
            return size / 2;
        } else {
            return (size / 2) + 1;
        }
    }

    public void deleteMidNode(Node head, int i, int mid) {
        Node currHead = head;
        if(currHead.next == null) {
            return;
        }
        if(i == mid - 1) {
            if(this.getSize() % 2 == 0) {
                currHead.next = currHead.next.next.next;
                Size -= 2;//deleting 2 node if stack is of even size
                return;
            } else {
                currHead.next = currHead.next.next;
                Size--;//deleting 1 node if stack is of odd size
                return;
            }
        }
        deleteMidNode(currHead.next, i+1, mid);
    }

    public Node reverseStack(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseStack(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public static void main(String[] args) {
        RStack stack = new RStack();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(8);
        stack.push(16);
        
        System.out.println("Original Stack: ");
        stack.printStack();

        System.out.println("Reversed Stack: ");
        stack.head = stack.reverseStack(stack.head);
        stack.printStack();
    }
}

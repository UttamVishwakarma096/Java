package DSA.Tree;

public class BinaryTree {
    static int i = -1;

    public class Node { // Tree Node
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public class Queue { // Implementing Queue
        QNode head;      // for Level Order Traversal
        QNode tail;

        public class QNode {
            Node node;
            QNode next;

            public QNode(Node node) {
                this.node = node;
                this.next = null;
            }
        }

        public void add(Node node) {
            QNode newNode = new QNode(node);
            if(head == null) {
                head = newNode;
                tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public Node remove() {
            if(head == null) {
                return null;
            }
            Node removedNode = head.node;
            head = head.next;
            if(head == null) {
                tail = null;
            }
            return removedNode;
        }

        public boolean isEmpty() {
            return head == null && tail == null;          
        }
    }

    public Node BuildTree(int[] node) {
        i++;
        if(node[i] == -1) {
            return null;
        }

        Node newNode = new Node(node[i]);
        newNode.left = BuildTree(node);
        newNode.right = BuildTree(node);
        return newNode;
    }

    public void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left); 
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public void levelOrder(Node root) { // Example of BFS
        if(root == null) {
            return;
        }
        Queue queue = new Queue();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            Node currNode = queue.remove();
            if(currNode == null) {
                System.out.println();
                if(queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                System.out.print(currNode.data+" ");
                if(currNode.left != null) {
                    queue.add(currNode.left);
                }
                if(currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
    }

    public int sumOfNodeAtKth(int k, Node root){
        if(root == null){
            return 0;
        }
        Queue queue = new Queue();
        int level = 0;
        int sum = 0;
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            Node currNode = queue.remove();
            if(currNode == null) {
                level++;
                if(queue.isEmpty()) {
                    break;
                } 
                queue.add(null);
            } else {
                if(level == k) {
                    sum += currNode.data;
                }
                if(currNode.left != null) {
                    queue.add(currNode.left);
                }
                if(currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] node = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.BuildTree(node);

        System.out.println("Level Order Traversal : ");
        tree.levelOrder(root);
        System.out.println();

        int val = tree.sumOfNodeAtKth(1, root);
        System.out.println("Sum of Nodes at Kth level: "+val);
    }
}

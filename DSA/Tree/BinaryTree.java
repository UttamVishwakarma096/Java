package DSA.Tree;

public class BinaryTree {
    static int i = -1;

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
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
    public static void main(String[] args) {
        int[] node = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.BuildTree(node);

        System.out.print("Pre Order Traversal : ");
        tree.preOrder(root);
        System.out.println();

        System.out.print("In Orede Traversal : ");
        tree.inOrder(root);
        System.out.println();

        System.out.print("Post Order Traversal : ");
        tree.postOrder(root);
    }
}

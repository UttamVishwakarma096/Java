package DSA.Tree;

public class QBinaryTree {
    static int i = -1;

    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node BuildTree(int[] nodes) {
        i++;
        if(nodes[i] == -1) {
            return null;
        }

        Node newNode = new Node(nodes[i]);
        newNode.left = BuildTree(nodes);
        newNode.right = BuildTree(nodes);
        return newNode;
    }

    public int countNodes(Node root) {
        if(root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    public static void main(String[] args) {
        int[] node = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        QBinaryTree tree = new QBinaryTree();
        Node root = tree.BuildTree(node);

        System.out.println("Total no of Nodes : "+tree.countNodes(root));
    }
}

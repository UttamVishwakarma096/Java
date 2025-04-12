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

    public int countOfNodes(Node root) {
        if(root == null) {
            return 0;
        }
        return countOfNodes(root.left) + countOfNodes(root.right) + 1;
    }

    public int sumOfNodes(Node root) {
        if(root == null) {
            return 0;
        }
        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
    }

    public int height(Node root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }
 
    public int diameter(Node root) {
        if(root == null) {
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;
        return Math.max(diam3, Math.max(diam1, diam2));
    }
    public static void main(String[] args) {
        int[] node = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        QBinaryTree tree = new QBinaryTree();
        Node root = tree.BuildTree(node);
 
        System.out.println("Diameter of Tree: "+tree.diameter(root));
    }
}

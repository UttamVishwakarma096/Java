package DSA.Tree;

public class BST {
    public class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public Node BuildTree(BST tree, int[] val) {
        Node root = null;
        for(int i = 0; i < val.length; i++) {
            root = insert(root, val[i]);
        }
        return root;
    }

    public Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }
        if(root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public void inOrder(Node root) {
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data > key) {
            return search(root.left, key);
        } else if(root.data == key) {
            return true;
        } else {
            return search(root.right, key);
        }
    }

    public Node delete(Node root, int val) {
        if(root.data > val) {
            root.left = delete(root.left, val);
        } else if(root.data < val) {
            root.right = delete(root.right, val);
        } else {
            if(root.left == null && root.right == null) {
                return null;
            } else if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    private Node inorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        BST tree = new BST();
        Node root = tree.BuildTree(tree, values);

        tree.inOrder(root);
        System.out.println();

        tree.delete(root, 10);

        tree.inOrder(root);
    }    
}

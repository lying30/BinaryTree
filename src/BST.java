import java.sql.Array;
import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Lucas Ying
 * @version: 4/28/23
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        BSTNode root = getRoot();
        return searchVal(val, root);
    }
    //Recursive method that searches for a value in a tree,
    //And returns a boolean value to determine whether it is or isn't in the tree.
    public boolean searchVal(int val, BSTNode root) {
        if(root == null){
            return false;
        }
        if(val == root.getVal()) {
            return true;
        }
        if(val > root.getVal()) {
            return searchVal(val, root.getRight());
        }
        if(val < root.getVal()) {
            return searchVal(val, root.getLeft());
        }
        return false;

    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        BSTNode root = getRoot();
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        inorder(root, arr);
        return arr;
    }
    public void inorder(BSTNode root, ArrayList<BSTNode> arr) {
        //If root is not null,
        //Add the nodes in the order left, root, then right.
        if(root == null){
            return;
        }
        inorder(root.getLeft(), arr);
        arr.add(root);
        inorder(root.getRight(), arr);

    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        BSTNode root = getRoot();
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        preorder(root, arr);
        return arr;
    }
    public void preorder(BSTNode root, ArrayList<BSTNode> arr) {
        //If root is not null,
        //Add the nodes in the order root, left, then right.
        if(root == null){
            return;
        }
        arr.add(root);
        preorder(root.getLeft(), arr);
        preorder(root.getRight(), arr);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> arr = new ArrayList<>();
        postorder(root, arr);
        return arr;
    }

    public void postorder(BSTNode root, ArrayList<BSTNode> arr){
        //If root is not null,
        //Add the nodes in the order left, then right, then root.
        if(root == null){
            return;
        }
        postorder(root.getLeft(), arr);
        postorder(root.getRight(), arr);
        arr.add(root);

        //
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        insertion(val, root);
    }

    //Inserts value into tree as a node.
    public void insertion(int val, BSTNode root){
        //If root is null then make the value the new root.
        if(root == null){
            root = new BSTNode(val);
        }
        //If root is in tree then return.
        if(root.getVal() == val) {
            return;
        }

        if(root.getVal() > val) {
            if(root.getLeft() == null) {
                root.setLeft(new BSTNode(val));
                return;
            }
            insertion(val, root.getLeft());
        }

        if (root.getVal() < val) {
            if (root.getRight() == null) {
                root.setRight(new BSTNode(val));
                return;
            }
            insertion(val, root.getLeft());
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}

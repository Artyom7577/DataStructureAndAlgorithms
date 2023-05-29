package treenode.bstree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTree {
    static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }
    Node root;
    BSTree() {
        root = null;
    }
    void deleteKey(int key) {
        root = deleteRecursive(root, key);
    }
    Node deleteRecursive(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = deleteRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRecursive(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);

            root.right = deleteRecursive(root.right, key);
        }
        return root;
    }
    static Node deleteIterative(Node root, int key) {
        if (root == null) {
            return null;
        }

        Node parent = null;
        Node current = root;

        while (current != null && current.key != key) {
            parent = current;
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current == null) {
            return root;
        }
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (current == parent.left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (current == parent.left) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.right == null) {
            if (current == root)
                root = current.left;
            else if (current == parent.left)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else {
            Node successor = findSuccessor(current.right);
            current.key = successor.key;
            current.right = deleteIterative(current.right, successor.key);
        }
        return root;
    }
    private static Node findSuccessor(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    int minValue(Node root) {
        int minval = root.key;

        while (root.left != null) {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }
    int minValueIterative(Node root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        Node current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current.key;
    }
    void insert(int key) {
        root = insertRecursive(root, key);
    }
    Node insertRecursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = insertRecursive(root.right, key);
        }
        return root;
    }
    void insertIterative(int key) {
        Node newNode = new Node(key);

        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent;

        while (true) {
            parent = current;
            if (key < current.key) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }

    }
    void inorder() {
        inorderRecursive(root);
    }
    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.println(root.key + " ");
            inorderRecursive(root.right);
        }
    }
    static void inorderTraversalIterative(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.println(current.key + " ");
            current = current.right;
        }
    }
    void postorder() {
        postorderRecursive(root);
    }
    void postorderRecursive(Node root) {
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.println(root.key + " ");
    }
    static void postorderTraversalIterative(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node current = stack1.pop();
            stack2.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }
        while (!stack2.isEmpty()) {
            Node node = stack2.pop();
            System.out.println(node.key + " ");
        }
    }
    void preorder() {
        preorderRecursive(root);
    }
    void preorderRecursive(Node root) {
        System.out.println(root.key + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }
    static void preorderTraversalIterative(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.key + " ");

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }
    }
    boolean search(int key) {
        root = searchRecursive(root, key);
        return root != null;
    }
    Node searchRecursive(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (root.key > key) {
            return searchRecursive(root.left, key);
        }
        return searchRecursive(root.right, key);
    }
    boolean searchIterative(Node root, int key) {
        if (root == null) {
            return false;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.key == key) {
                return true;
            }
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return false;
    }

    public static void saveBinarySearchTreeToFile(Node root , String filePath) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            saveNodeToFile(root, writer);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the binary search tree to file: " + e.getMessage());
        }
    }
    private static void saveNodeToFile(Node node, BufferedWriter writer) throws IOException {
        if (node == null) {
            return;
        }
        writer.write(Integer.toString(node.key));
        writer.newLine();

        saveNodeToFile(node.left, writer);
        saveNodeToFile(node.right, writer);
    }

    public static void main(String[] args) {
        BSTree bst = new BSTree();

        bst.insert(45);
        bst.insert(10);
        bst.insert(7);
        bst.insert(12);
        bst.insert(90);
        bst.insert(50);

        System.out.println();
        bst.inorder();

        bst.deleteKey(12);
        bst.inorder();

        bst.deleteKey(90);
        bst.inorder();

        bst.deleteKey(45);
        bst.inorder();

        boolean ret_val = bst.search(50);
        System.out.println("\nKey 50 found in BST:" + ret_val);
        ret_val = bst.search(12);
        System.out.println("\nKey 12 found in BST:" + ret_val);
    }
}


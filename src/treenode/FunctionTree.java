package treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;

class TreeNode<T> {
    private final T data;
    private final List<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void addChildren(TreeNode<T> child) {
        children.add(child);
    }

    public void removeChild(TreeNode<T> child) {
        children.remove(child);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

public class FunctionTree {
    private TreeNode<Function<Integer, Integer>> root;

    public FunctionTree(Function<Integer, Integer> data) {
        this.root = new TreeNode<>(data);
    }

    public TreeNode<Function<Integer, Integer>> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<Function<Integer, Integer>> root) {
        this.root = root;
    }

    public int execute(int number) {
        Queue<TreeNode<Function<Integer, Integer>>> queue = new LinkedList<>();
        queue.offer(root);
        int result = number;

        while (!queue.isEmpty()) {
            TreeNode<Function<Integer, Integer>> node = queue.poll();
            result = node.getData().apply(result);

            List<TreeNode<Function<Integer, Integer>>> children = node.getChildren();
            for (TreeNode<Function<Integer, Integer>> child : children) {
                queue.offer(child);
            }
        }

        return result;
    }

    public void show(TreeNode<Function<Integer, Integer>> node, int number, String prefix) {
        int result = node.getData().apply(number);
        System.out.println(result);

        List<TreeNode<Function<Integer, Integer>>> children = node.getChildren();
        for (TreeNode<Function<Integer, Integer>> child : children) {
            show(child, result, prefix + "  ");
        }
    }

    public void show() {
        show(root, 0, "");
    }

    public static void main(String[] args) {
        FunctionTree tree = new FunctionTree(n -> n + 5);

        TreeNode<Function<Integer, Integer>> nodeMultiply = new TreeNode<>(n -> n * 2);
        TreeNode<Function<Integer, Integer>> nodeSubtract = new TreeNode<>(n -> n - 5);

        tree.getRoot().addChildren(nodeMultiply);
        tree.getRoot().addChildren(nodeSubtract);

        tree.show();

        int result = tree.execute(10);

        System.out.println(result);
    }
}

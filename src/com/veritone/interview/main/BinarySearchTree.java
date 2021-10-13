package com.veritone.interview.main;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(12);
        array.add(11);
        array.add(90);
        array.add(82);
        array.add(7);
        array.add(9);
        BinarySearchTree test1 = new BinarySearchTree();
        TreeNode root = test1.arrayToBinarySearchTree(array);
        test1.printTreeNodes(root);
    }

    public void printTreeNodes(TreeNode root) {
        if (root ==null) {
            return;
        }
        System.out.println(root.value);
        printTreeNodes(root.left);
        printTreeNodes(root.right);
    }

    private int deepestNodeDepth = 0;
    private TreeNode deepestNode = null;

    /**
     * Get the deepestNode in Binary Search Tree
     */
    public TreeNode getDeepestNode() {
        return deepestNode;
    }

    /**
     * Get the deepth of the Binary Search Tree
     */
    public int getDeepestNodeDepth() {
        return deepestNodeDepth;
    }

    /**
     * Convert an unsorted array to Binary Search Tree
     * @param array input array
     */
    public TreeNode arrayToBinarySearchTree (List<Integer> array) {
        if (array.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(array.get(0));
        for (Integer value : array) {
            root = insert(root, value);
        }
        return root;
    }

    /**
     * Insert a data in the Binary Search Tree
     * @param root insert into a TreeNode
     * @param target target to be inserted
     */
    public TreeNode insert(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode(target);
        }
        insertHelper(root, target, 1);
        return root;
    }

    /**
     * Insert a data in the Binary Search Tree helper function
     * @param root insert into a TreeNode
     * @param target target to be inserted
     */
    public void insertHelper(TreeNode root, int target, int currentDepth) {
        if (root == null) {
            return;
        }
        if (root.value == target) {
            if (currentDepth > deepestNodeDepth) {
                deepestNodeDepth = currentDepth;
                deepestNode = root;
            }
        } else if (root.value > target) {
            if (root.left == null) {
                root.left = new TreeNode(target);
            }
            insertHelper(root.left, target, currentDepth + 1);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(target);
            }
            insertHelper(root.right, target, currentDepth + 1);
        }
    }
}

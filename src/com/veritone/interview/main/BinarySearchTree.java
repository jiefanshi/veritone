package com.veritone.interview.main;

import java.util.*;

public class BinarySearchTree {
    private int deepestNodesDepth = 0;
    private Set<TreeNode> deepestNodes = null;

    /**
     * Get the deepestNode in Binary Search Tree
     */
    public Set<TreeNode> getDeepestNodes() {
        return deepestNodes;
    }

    /**
     * Get the depth of the Binary Search Tree
     */
    public int getDeepestNodeDepth() {
        return deepestNodesDepth;
    }

    /**
     * Convert an unsorted array to Binary Search Tree
     * @param array input array
     * @return return a binary search tree
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
     * Insert a node in the Binary Search Tree
     * @param root insert into a TreeNode
     * @param target target to be inserted
     * @return return the tree after insert
     */
    public TreeNode insert(TreeNode root, int target) {
        if (root == null) {
            deepestNodesDepth = 1;
            deepestNodes = new HashSet<>();
            root = new TreeNode(target);
            deepestNodes.add(root);
            return root;
        }
        insertHelper(root, target, 1);
        return root;
    }

    /**
     * Insert a node in the Binary Search Tree helper function
     * @param root insert into a TreeNode
     * @param target target to be inserted
     */
    private void insertHelper(TreeNode root, int target, int currentDepth) {
        if (root == null) {
            return;
        }
        if (root.value == target) {
            if (currentDepth > deepestNodesDepth) {
                deepestNodesDepth = currentDepth;
                deepestNodes = new HashSet<>();
            }
            deepestNodes.add(new TreeNode(target));
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

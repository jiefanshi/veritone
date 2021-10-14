package com.veritone.interview.test;


import com.veritone.interview.main.BinarySearchTree;
import com.veritone.interview.main.TreeNode;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinarySearchTreeTest {

    BinarySearchTree test;
    List<Integer> array;

    @BeforeEach
    public void setUp() {
        test = new BinarySearchTree();
        array = new ArrayList<>();
    }

    @Test
    @DisplayName("BSTConstruction.arrayToTree empty test")
    public void testArrayToBinarySearchTreeEmpty () {
        TreeNode root = test.arrayToBinarySearchTree(array);
        assertNull(root);
    }

    @Test
    @DisplayName("BSTConstruction.arrayToTree test")
    public void testArrayToBinarySearchTree () {
        array.add(12);
        array.add(11);
        array.add(90);
        array.add(82);
        array.add(7);
        array.add(9);
        TreeNode root = test.arrayToBinarySearchTree(array);
        assertEquals(12, root.value);
        assertEquals(11, root.left.value);
        assertEquals(7, root.left.left.value);
        assertEquals(9, root.left.left.right.value);
        assertEquals(90, root.right.value);
        assertEquals(82,root.right.left.value);
    }

    @Test
    @DisplayName("BSTConstruction.arrayToTree duplication test")
    public void testArrayToBinarySearchTreeDuplication () {
        array.add(12);
        array.add(11);
        array.add(90);
        array.add(82);
        array.add(7);
        array.add(9);
        array.add(9);
        array.add(12);
        array.add(90);
        TreeNode root = test.arrayToBinarySearchTree(array);
        assertEquals(12, root.value);
        assertEquals(11, root.left.value);
        assertEquals(7, root.left.left.value);
        assertEquals(9, root.left.left.right.value);
        assertNull(root.left.left.right.left);
        assertNull(root.left.left.right.right);
        assertEquals(90, root.right.value);
        assertEquals(82,root.right.left.value);
    }

    @Test
    @DisplayName("BSTConstruction.getDeepestNodeDepth empty test")
    public void testGetDeepestNodeDepthEmpty () {
        test.arrayToBinarySearchTree(array);
        assertEquals(0, test.getDeepestNodeDepth());
    }

    @Test
    @DisplayName("BSTConstruction.getDeepestNodeDepth test")
    public void testGetDeepestNodeDepth () {
        array.add(12);
        array.add(11);
        array.add(90);
        array.add(82);
        array.add(7);
        array.add(9);
        test.arrayToBinarySearchTree(array);
        assertEquals(4, test.getDeepestNodeDepth());
    }

    @Test
    @DisplayName("BSTConstruction.getDeepestNode empty test")
    public void testGetDeepestNodeEmpty () {
        test.arrayToBinarySearchTree(array);
        assertNull(test.getDeepestNodes());
    }

    @Test
    @DisplayName("BSTConstruction.getDeepestNode test")
    public void testGetDeepestNode () {
        array.add(12);
        array.add(11);
        array.add(90);
        array.add(82);
        array.add(7);
        array.add(9);
        test.arrayToBinarySearchTree(array);
        assertEquals(9, test.getDeepestNodes().iterator().next().value);
    }

    @AfterAll
    public static void cleanUp(){
        System.out.println("Tests finish.");
    }


}

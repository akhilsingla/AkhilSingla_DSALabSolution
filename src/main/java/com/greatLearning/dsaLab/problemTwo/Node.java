package com.greatLearning.dsaLab.problemTwo;

//Node class which represent Node of tree with left child, right child and data
public class Node
{
    private Node leftChild;
    private Node rightChild;
    private int data;

    // constructor, set data value
    // set left, right child to null
    public Node(int data) {
        this.leftChild = null;
        this.rightChild = null;
        this.data = data;
    }

    // set left child
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    // set right child
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    // set data
    public void setData(int data) {
        this.data = data;
    }

    // get left child
    public Node getLeftChild() {
        return leftChild;
    }

    // get right child
    public Node getRightChild() {
        return rightChild;
    }

    // get data
    public int getData() {
        return data;
    }
}

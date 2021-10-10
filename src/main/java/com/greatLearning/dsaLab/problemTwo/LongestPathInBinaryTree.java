package com.greatLearning.dsaLab.problemTwo;

import java.util.ArrayDeque;

public class LongestPathInBinaryTree {

    public static void main(String args[])
    {
        //create a tree
        Node rootNode = new Node(100);
        //construct left tree of root node
        rootNode.setLeftChild(new Node(20));
        rootNode.getLeftChild().setLeftChild(new Node(10));
        rootNode.getLeftChild().setRightChild(new Node(50));
        rootNode.getLeftChild().getLeftChild().setLeftChild(new Node(5));

        //construct right tree of root node
        rootNode.setRightChild(new Node(130));
        rootNode.getRightChild().setLeftChild(new Node(110));
        rootNode.getRightChild().setRightChild(new Node(140));

        //find longest path of the tree
        ArrayDeque longestPathStack = new LongestPathInBinaryTree().getLongestPath(rootNode);

        System.out.print("Longest Path :- ");
        //pop from stack to show longest path
        while (!longestPathStack.isEmpty())
        {
            // if size is 1, don't print ->
            // this check for last element of stack or if only single node is in the tree, no need to print ->
            if(longestPathStack.size() == 1)
                System.out.print(longestPathStack.pop());
            else
                System.out.print(longestPathStack.pop() + " -> ");
        }

    }

    /*
    function to find longest path, using ArrayDeque to implement Stack to find longest path
     */
    private ArrayDeque<Integer> getLongestPath(Node rootNode)
    {
        // if root node is null return empty deque
        if(rootNode == null)
         return new ArrayDeque<Integer>();

        // recursively find longest path of left/right sub-tree
        ArrayDeque<Integer> leftTree = getLongestPath(rootNode.getLeftChild());
        ArrayDeque<Integer> rightTree = getLongestPath(rootNode.getRightChild());

        // if left tree is longer then right, push root node to left tree and return left tree
        if(leftTree.size() > rightTree.size())
        {
            leftTree.push(rootNode.getData());
            return leftTree;
        }// else return right tree
        else
        {
            rightTree.push(rootNode.getData());
            return rightTree;
        }
    }
}

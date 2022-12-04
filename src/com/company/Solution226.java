package com.company;

/*
翻转二叉树LeedCode226
 */
public class Solution226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode newRoot = new Solution226().invertTree(root);
        new Solution104().preOrderTravel(newRoot);
    }

    public TreeNode invertTree(TreeNode root) {
        TreeNode tempRoot;
        if (root == null) {
            return root;
        }
        tempRoot = root.right;
        root.right = root.left;
        root.left = tempRoot;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

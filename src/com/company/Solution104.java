package com.company;

import java.util.List;

/*
2022-12-04 LeetCode104 二叉树最大深度
https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class Solution104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        new Solution104().preOrderTravel(root);
        System.out.println();
        new Solution104().innerOrderTravel(root);
        System.out.println();
        new Solution104().backOrderTravel(root);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public void preOrderTravel(TreeNode root) {
        // 前序遍历：前左后，找到根节点就输出，再分别遍历左节点和右节点(先按照一层遍历写顺序，然后再将左右改为递归遍历)
        if (root == null) {
            //System.out.print("null" + " ");
            return;
        }
        System.out.print(root.val + " ");
        preOrderTravel(root.left);
        preOrderTravel(root.right);
    }

    public void innerOrderTravel(TreeNode root) {
        // 中序遍历：左前后
        if (root == null) {
            return;
        }
        innerOrderTravel(root.left);
        System.out.print(root.val + " ");
        innerOrderTravel(root.right);
    }

    public void backOrderTravel(TreeNode root) {
        // 后序遍历：左后前
        if (root == null) {
            return;
        }
        backOrderTravel(root.left);
        backOrderTravel(root.right);
        System.out.print(root.val + " ");
    }
}

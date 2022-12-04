package com.company;
/*
 有返回值的前序遍历，leetCode144
 https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
  */
import java.util.ArrayList;
import java.util.List;

public class Solution144 {
    List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Integer> result = new Solution144().preorderTraversal(root);
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}

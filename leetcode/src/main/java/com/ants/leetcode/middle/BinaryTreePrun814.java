package com.ants.leetcode.middle;

/**
 * @author ants_
 */
public class BinaryTreePrun814 {
    public static void main(String[] args) {

        BinaryTreePrun814 test=new BinaryTreePrun814();
        TreeNode treeNode = test.pruneTree(null);
        System.out.println(treeNode);


    }



    public TreeNode pruneTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode tree=root;


        tree.left=pruneTree(root.left);
        tree.right=pruneTree(root.right);

        if (root.left==null&&root.right==null&&root.val==0){
            return null;
        }
        return tree;


    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

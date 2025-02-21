package com.csbd.tree;

public class FindElements {
    // 1261. Find Elements in a Contaminated Binary Tree

    public static final int SIZE = 100001;
    private final TreeNode root;
    private final boolean[] marker;

    public FindElements(TreeNode root) {
        this.root = root;
        this.root.val = 0;
        marker = new boolean[SIZE];
        marker[0] = true;
        dfs(this.root);
    }

    public boolean find(int target) {
        if(target > SIZE)
            return false;
        return marker[target];
    }

    private void dfs(TreeNode root){
        if(root == null)
            return;

        if(root.left != null){
            int val = 2 * root.val + 1;
            root.left.val = val;
            marker[val] = true;
            dfs(root.left);
        }

        if(root.right != null){
            int val = 2 * root.val + 2;
            root.right.val = val;
            marker[val] = true;
            dfs(root.right);
        }
    }
}

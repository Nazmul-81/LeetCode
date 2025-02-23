package com.csbd.tree;

import java.util.HashMap;
import java.util.Map;

public class Feb23_2025 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // 889. Construct Binary Tree from Preorder and Postorder Traversal

        int n = preorder.length;
        Map<Integer, TreeNode> map = new HashMap<>();

        int firstNode = preorder[0];
        TreeNode root = new TreeNode(firstNode);
        map.put(firstNode, root);

        for (int i = 1; i < n; i++) {
            int left = preorder[i];
            TreeNode leftNode = new TreeNode(left);
            map.put(left, leftNode);

            int postOrderPosition = -1;
            for (int j = 0; j < postorder.length; j++) {
                if (postorder[j] == left) {
                    postOrderPosition = j;
                    break;
                }
            }

            for (int j = postOrderPosition + 1; j < postorder.length; j++) {
                TreeNode node = map.get(postorder[j]);
                if (node != null) {
                    if (node.left == null) {
                        node.left = leftNode;
                    } else {
                        node.right = leftNode;
                    }
                    break;
                }
            }
        }
        return root;
    }
}

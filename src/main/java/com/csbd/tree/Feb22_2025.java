package com.csbd.tree;

import java.util.List;

public class Feb22_2025 {

    static int index = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        index = 0;
        return dfs(traversal, index);
    }

    TreeNode dfs(String traversal, int depth) {
        if (index >= traversal.length())
            return null;

        int dashCount = 0;
        while (index + dashCount < traversal.length() && traversal.charAt(index + dashCount) == '-') {
            dashCount++;
        }

        if (dashCount != depth)
            return null;

        index += depth;

        int value = 0;
        while (index < traversal.length() && Character.isDigit(traversal.charAt(index))) {
            value = value * 10 + (traversal.charAt(index++) - '0');
        }

        TreeNode node = new TreeNode(value);
        node.left = dfs(traversal, depth + 1);
        node.right = dfs(traversal, depth + 1);

        return node;
    }


}

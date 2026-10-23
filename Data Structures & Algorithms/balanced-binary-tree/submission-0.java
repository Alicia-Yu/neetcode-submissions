/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {1, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        int leftBalanced = left[0];
        int leftHeight = left[1];
        int rightBalanced = right[0];
        int rightHeight = right[1];

        boolean balanced;
        if (leftBalanced == 1 && rightBalanced == 1 && 
                Math.abs(leftHeight - rightHeight) <= 1) {
            balanced = true;
        } else {
            balanced = false;
        }

        int height = 1 + Math.max(leftHeight, rightHeight);

        int balancedNumber;
        if (balanced) {
            balancedNumber = 1;
        } else {
            balancedNumber = 0;
        }

        return new int[]{balancedNumber, height};
    }
}

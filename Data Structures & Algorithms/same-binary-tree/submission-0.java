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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQ = new LinkedList<>();
        Queue<TreeNode> qQ = new LinkedList<>();
        pQ.add(p); 
        qQ.add(q); 
        while (!pQ.isEmpty() && !qQ.isEmpty()) {
            int size = pQ.size();
            for (int i = 0; i < size; i ++) {
                TreeNode pNode = pQ.poll();
                TreeNode qNode = qQ.poll();
                if (pNode == null && qNode == null) {
                    continue; 
                }
                if (pNode == null || qNode == null || pNode.val != qNode.val) {
                    return false; 
                }
                pQ.add(pNode.left);
                pQ.add(pNode.right);
                qQ.add(qNode.left);
                qQ.add(qNode.right); 
            }
        }
        return true; 
    }
}

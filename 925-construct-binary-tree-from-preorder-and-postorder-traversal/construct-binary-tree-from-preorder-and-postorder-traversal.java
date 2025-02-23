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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int noOfNodes = preorder.length;
        return constructTree(0, noOfNodes-1, 0, preorder, postorder);
    }

    private TreeNode constructTree(int preStart, int preEnd, int postStart, int[] preorder, int[] postorder)
    {
        if(preStart > preEnd) return null;
        if(preStart == preEnd) return new TreeNode(preorder[preStart]);
        int leftRoot = preorder[preStart + 1];
        int noOfLeftNodes = 1;
        while(postorder[postStart+noOfLeftNodes-1] != leftRoot) noOfLeftNodes++;
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = constructTree(preStart+1, preStart+noOfLeftNodes, postStart, preorder, postorder);
        root.right = constructTree(preStart+noOfLeftNodes+1, preEnd, postStart+noOfLeftNodes, preorder, postorder);
        return root;
    }

}
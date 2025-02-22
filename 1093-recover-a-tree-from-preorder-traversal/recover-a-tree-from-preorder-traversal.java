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
    static int index = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        index = 0;
        return constructTree(traversal, 0);
    }

    public TreeNode constructTree(String traversal, int depth)
    {
        if(index >= traversal.length()) return null;
        int dashCounter = 0;
        while((index+dashCounter) < traversal.length() && traversal.charAt(index+dashCounter) == '-')
        {
            dashCounter++;
        }        

        if(dashCounter != depth) return null;
        
        index += dashCounter;
        int value = 0;
        
        while(index < traversal.length() && Character.isDigit(traversal.charAt(index)))
        {
            value = value * 10 + (traversal.charAt(index) - '0');
            index++;
        }

        TreeNode node = new TreeNode(value);
        node.left = constructTree(traversal, depth+1);
        node.right = constructTree(traversal, depth+1);

        return node;
    }
}

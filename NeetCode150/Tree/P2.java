public class P2 {
    public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
        }
    }
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;

        int leftDepth = maxDepth(root.left)+1;
        int rightDepth = maxDepth(root.right)+1;

        return Math.max(leftDepth,rightDepth);
    }
}

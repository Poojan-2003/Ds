public class P9 {
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
    public int preOrder(TreeNode root,int ans, int currMax){
        if(root == null)return 0;
        int currAns = 0;
        if(root.val>=currMax){
            currAns = 1;
            currMax = root.val;
        }

        int leftAns = preOrder(root.left,currAns,currMax);
        int rightAns = preOrder(root.right,currAns,currMax);

        return leftAns + rightAns+currAns;
    }
    public int goodNodes(TreeNode root) {
        return preOrder(root,0,Integer.MIN_VALUE);
    }
}

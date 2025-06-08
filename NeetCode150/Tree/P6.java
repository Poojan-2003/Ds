public class P6 {
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
    public String preOrderTraversal(TreeNode root){
        if(root == null)return "null";

        StringBuilder sb = new StringBuilder("^");
        sb.append(root.val);
        sb.append(preOrderTraversal(root.left));
        sb.append(preOrderTraversal(root.right));

        return sb.toString();

    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String rootpreOrderTraversal = preOrderTraversal(root);
        String subRootpreOrderTraversal = preOrderTraversal(subRoot);

        System.out.println(rootpreOrderTraversal+" "+subRootpreOrderTraversal);
        return rootpreOrderTraversal.contains(subRootpreOrderTraversal);
    }
}

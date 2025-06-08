import javax.swing.tree.TreeNode;

public class P10 {
    public boolean validateBST(TreeNode root,int min,int max){
        if(root == null)return true;

        if(root.val>=min || root.val<=max)return false;

        return validateBST(root.left,min,root.val) && validateBST(root.right,root.val,max);
    }
    public boolean isValidBST(TreeNode root) {
        return validateBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}

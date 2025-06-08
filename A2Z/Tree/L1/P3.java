import java.util.ArrayList;
import java.util.List;

public class P3 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }
    
    //Inorder Traversal  => left -> root -> right
    //Preorder Traversal => root -> left -> right
    //Post Traversal     => left -> right -> root

    public void inorderTraversal(TreeNode node, ArrayList<Integer>ans){
        if(node == null)return;

        inorderTraversal(node.left, ans);
        ans.add(node.val);
        inorderTraversal(node.right, ans);
    }

    public void preorderTraversal(TreeNode root,List<Integer>ans){
        if(root == null)return ;

        ans.add(root.val);
        preorderTraversal(root.left,ans);
        preorderTraversal(root.right,ans);
    }
    
    public void postorder(TreeNode root,List<Integer>ans) {
        if(root == null)return ;

        postorder(root.left,ans);
        postorder(root.right,ans);
        ans.add(root.val);
    }
}

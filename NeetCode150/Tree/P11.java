import javax.swing.tree.TreeNode;

public class P11 {
    public int ans = 0;
    public int cnt = 0;
    public void kSmallest(TreeNode root,int k){
        if(root == null)return ;

        kSmallest(root.left,k);
        cnt++;
        if(k == cnt){
            ans = root.val;
            return ;
        }
        kSmallest(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        kSmallest(root,k);
        return ans;
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class P8 {
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
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        if(root == null)return ans;

        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int rowSize = q.size();
            List<Integer>currRow = new ArrayList<>();

            for(int i=0;i<rowSize;i++){
                TreeNode currNode = q.poll();

                if(currNode.left != null)q.add(currNode.left);
                if(currNode.right != null)q.add(currNode.right);

                currRow.add(currNode.val);
            }
            ans.add(currRow.get(currRow.size()-1));
        }
        return ans;
    }
    public List<Integer> rightSideView(TreeNode root) {
        return levelOrder(root);
    }
}

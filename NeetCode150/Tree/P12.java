import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

public class P12 {
    public TreeNode createTree(int[]preorder,Map<Integer,Integer>mp,int inOrderIndex,int left,int right){
        TreeNode node = new TreeNode(preorder[inOrderIndex]);

        int mid = mp.get(preorder[inOrderIndex]);
        if(mid>left){
            node.left = createTree(preorder,mp,inOrderIndex+1,left,mid-1);
        }
        if(mid<right){
            node.right = createTree(preorder,mp,inOrderIndex+mid-left+1,mid+1,right);
        }
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer>mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return createTree(preorder,mp,0,0,inorder.length-1);
    }
}

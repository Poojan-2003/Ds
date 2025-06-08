import javax.swing.tree.TreeNode;

public class P13 {
    private int maxSum = Integer.MIN_VALUE;

    private int dfs(TreeNode root) {

        if (root == null)
            return 0;

        // Recursively get max sum from left and right
        int left = Math.max(0, dfs(root.left)); // Only add if > 0
        int right = Math.max(0, dfs(root.right)); // Only add if > 0

        // Calculate the max path **through this node**
        int currentMax = root.val + left + right;

        // Update global max if needed
        maxSum = Math.max(maxSum, currentMax);

        // Return max gain if continuing path through parent
        return root.val + Math.max(left, right);
    }

    public int sum(TreeNode root) {
        if (root == null)
            return 0;
        int ans = root.val;

        int leftSubTreeVal = sum(root.left);
        int rightSubTreeVal = sum(root.right);

        return root.val > 0 ? leftSubTreeVal + rightSubTreeVal + ans : Math.max(leftSubTreeVal, rightSubTreeVal);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
}

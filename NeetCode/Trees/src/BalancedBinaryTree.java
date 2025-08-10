public class BalancedBinaryTree {
    int calDepth(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        if(root.left == null && root.right == null)
        {
            return 1;
        }
        return 1 + Math.max(calDepth(root.left), calDepth(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        if(root.left == null && root.right == null)
        {
            return true;
        }
        boolean isBalancedTree = true;
        int leftHeight = calDepth(root.left);
        int rightHeight = calDepth(root.right);
        if(Math.abs(rightHeight - leftHeight) > 1)
        {
            isBalancedTree = false;
        }
        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);
        return isBalancedTree && leftBalanced && rightBalanced;
    }
}

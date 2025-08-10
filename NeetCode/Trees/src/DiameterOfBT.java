public class DiameterOfBT {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return maxDiameter;
    }
    public int calculateDepth(TreeNode root)
    {
        if(root.left == null || root.right == null)
        {
            return 0;
        }
        int leftDepth = calculateDepth(root.left);
        int rightDepth = calculateDepth(root.right);
        maxDiameter=Math.max(maxDiameter,leftDepth+rightDepth);
        return Math.max(leftDepth,rightDepth)+1;
    }
}

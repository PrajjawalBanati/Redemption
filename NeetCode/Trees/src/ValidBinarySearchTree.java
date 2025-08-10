public class ValidBinarySearchTree {
    public boolean valid(TreeNode root, int leftLimit, int rightLimit)
    {
        if(root == null)
        {
            return true;
        }
        if(!(root.val > leftLimit && root.val < rightLimit))
        {
           return false;
        }
        return valid(root.left, leftLimit, root.val) && valid(root.right, root.val, rightLimit);
    }
    public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

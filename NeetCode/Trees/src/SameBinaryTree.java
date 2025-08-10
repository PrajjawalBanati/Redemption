public class SameBinaryTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isBalanced = true;
        if(p == null && q == null) {
            return true;
        }
        else if(p == null || q == null)
        {
            return false;
        }
        else{
            if(p.val != q.val)
            {
                isBalanced = false;
            }
            isBalanced = isBalanced && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return isBalanced;
    }
}

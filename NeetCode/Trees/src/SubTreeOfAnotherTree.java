public class SubTreeOfAnotherTree {
    public boolean checkSameTree(TreeNode p, TreeNode q) {
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
            isBalanced = isBalanced && checkSameTree(p.left,q.left) && checkSameTree(p.right,q.right);
        }
        return isBalanced;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
        {
            return true;
        }
        if(root == null || subRoot == null)
        {
            return false;
        }
        boolean isSubTreeFound = true;
        if(root.val == subRoot.val)
        {
            // possibility of finding a SubTree
            isSubTreeFound = checkSameTree(root.left,subRoot.left) && checkSameTree(root.right,subRoot.right);

        }
        else{
            isSubTreeFound = isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        return isSubTreeFound;
    }
}

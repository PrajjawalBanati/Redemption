public class CountGoodNodes {
   int count = 0;
    void countGoodNodes(TreeNode root, int maxValue)
    {
        if(root == null)
        {
            return;
        }
        if(root.val >= maxValue)
        {
            maxValue = root.val;
            count++;
        }
        countGoodNodes(root.left, maxValue);
        countGoodNodes(root.right,maxValue);
    }
    public int goodNodes(TreeNode root) {
        if(root == null){return 0;}
        countGoodNodes(root, root.val);
        return count;
    }
}

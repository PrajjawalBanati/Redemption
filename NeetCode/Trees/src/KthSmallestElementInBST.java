import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
    void inorder(TreeNode root, List<Integer> ll)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left, ll);
        ll.add(root.val);
        inorder(root.right,ll);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ll = new ArrayList<>();
        inorder(root, ll);
        return ll.get(k-1);
    }
}

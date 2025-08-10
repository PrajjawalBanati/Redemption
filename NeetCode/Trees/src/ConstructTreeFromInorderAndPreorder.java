import java.util.Arrays;

public class ConstructTreeFromInorderAndPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length== 0)
        {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int mid = -1;
        for(int i = 0 ; i < inorder.length; i++)
        {
            if(preorder[0] == inorder[i])
            {
                mid = i;
                break;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid+1);
        root.left = buildTree(leftPreorder, leftInorder);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid+1, inorder.length);
        int[] rightPreorder = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;

    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodeList = new ArrayList<>();
        if(root == null)
        {
            return List.of();
        }
        if(root.left == null && root.right == null)
        {
            return List.of(List.of(root.val));
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        treeNodeQueue.offer(null);
        List<Integer> elements = new ArrayList<>();
        while(treeNodeQueue.size() > 1)
        {
            TreeNode temp = treeNodeQueue.poll();
            if(temp == null)
            {
                nodeList.add(elements);
                elements.clear();
                treeNodeQueue.offer(null);
            }
            else
            {
                elements.add(temp.val);
                if(temp.left != null)
                {
                    treeNodeQueue.offer(temp.left);
                }
                if(temp.right != null)
                {
                    treeNodeQueue.offer(temp.right);
                }
            }
        }
        return nodeList;
    }
}

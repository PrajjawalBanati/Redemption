
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
        {
            return List.of();
        }
        if(root.left == null && root.right == null)
        {
            return List.of(root.val);
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        treeNodeQueue.offer(null);
        List<Integer> answer = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        while(treeNodeQueue.size() > 1)
        {
            TreeNode temp = treeNodeQueue.poll();
            if(temp == null)
            {
                answer.add(nodeList.getLast().val);
                treeNodeQueue.offer(null);
                nodeList.clear();
            }
            else{
                nodeList.add(temp);
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
        answer.add(nodeList.getLast().val);
        return  answer;
    }
}

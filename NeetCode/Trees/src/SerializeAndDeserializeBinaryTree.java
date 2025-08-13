import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        if(root == null)
        {
            return stringBuilder.append("N,").toString();
        }
        treeNodeQueue.offer(root);
        while(!treeNodeQueue.isEmpty())
        {
            TreeNode node = treeNodeQueue.poll();
            if(node == null)
            {
                stringBuilder.append("N,");
            }
            else {
                stringBuilder.append(node.val).append(",");
                treeNodeQueue.offer(node.left);
                treeNodeQueue.offer(node.right);
            }
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if(vals[0] == "N"){
            return null;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        treeNodeQueue.offer(root);
        int index = 1;
        while(!treeNodeQueue.isEmpty())
        {
            TreeNode node = treeNodeQueue.poll();
            if(!(vals[index] == "N")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(vals[index]));
                node.left = leftNode;
                treeNodeQueue.offer(leftNode);
            }
            index++;
            if(!(vals[index] == "N")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(vals[index]));
                node.right = rightNode;
                treeNodeQueue.offer(rightNode);
            }
            index++;
        }
        return root;
    }
}

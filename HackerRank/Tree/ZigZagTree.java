import java.util.*;

/**
 * Definition for a binary tree TreNode. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Stack<TreeNode> leftToRigth  =new Stack<TreeNode>();
        Stack<TreeNode> rightToLeft = new Stack<TreeNode>();
        if(root == null){
            return res;
        }
        leftToRigth.add(root);
        while(leftToRigth.size() != 0 || rightToLeft.size() != 0){
            List<Integer> line = new ArrayList<>();

            if(leftToRigth.size() != 0){
                while(leftToRigth.size() != 0){
                    TreeNode node = leftToRigth.pop();
                    line.add(node.val);
                    if(node.left != null){
                        rightToLeft.add(node.left);
                    }
                    if(node.right != null){
                        rightToLeft.add(node.right);
                    }
                }
            }else{
                while(rightToLeft.size() != 0){
                    TreeNode node = rightToLeft.pop();
                    line.add(node.val);
                    if(node.right != null){
                        leftToRigth.add(node.right);
                    }
                    if(node.left != null){
                        leftToRigth.add(node.left);
                    }
                }
            }
            res.add(line);
        }
        return res;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int data) {
        this.val = data;
        left = null;
        right = null;
    }
}

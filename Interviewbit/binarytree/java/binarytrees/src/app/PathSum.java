
package app;

import java.util.Stack;

public class PathSum {
    public static void main(String[] args) {
        Solution s = new Solution();

    }
}

class Solution {

    public static boolean done;

    public int hasPathSum(TreeNode A, int B) {
        return rec(A, 0, B) ? 1 : 0;
    }

    public boolean rec(TreeNode n, int sum, int target) {

        if (n.val + sum == target && n.left == null && n.right == null) {
            return true;
        } else {
            boolean left = n.left != null ? this.rec(n.left, sum + n.val, target) : false;
            boolean right = n.right != null ? this.rec(n.right, sum + n.val, target) : false;
            return left || right;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
    
    public void print(){
        this.print(this, 0);
    }
    public void print(TreeNode root, int level) {
        if (root == null)
            return;
        print(root.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++)
                System.out.print("|\t");
            System.out.println("|-------" + root.val);
        } else
            System.out.println(root.val);
            print(root.left, level + 1);
    }
   
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Pair{
    Integer min, max;
    public Pair(Integer min, Integer max){
        this.min = min;
        this.max = max;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, new Pair(null, null));
    }

    private boolean isValidBST(TreeNode node, Pair pair){
        if(node == null){
            return true;
        }else{
            if( pair.min != null && node.val <= pair.min){
                return false;
            }
            else if(pair.max != null && node.val  >= pair.max){
                return false;
            
            }else{
                return isValidBST(node.left, new Pair(pair.min, node.val)) &&
                    isValidBST(node.right, new Pair(node.val, pair.max));
            }
        }
        
    }
}
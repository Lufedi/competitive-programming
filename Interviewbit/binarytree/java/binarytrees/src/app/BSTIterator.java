package app;
import java.util.*;



public class BSTIterator {

    private Stack<TreeNode> path;
    private TreeNode root;
    public BSTIterator(TreeNode root) {
        this.root = root;
        path = new Stack<>();
        buildPath(root, path);
    }

    private void buildPath(TreeNode node, Stack<TreeNode> path){
        if(node != null){
            path.add(node);
            buildPath(node.left, path);
        }else{
            return;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return path.size() > 0;        
    }

    /** @return the next smallest number */
    public int next() {
        if(path.size() > 0){
            TreeNode res = path.peek();
            if(path.size() > 0){
                rebuild(path);    
            }
            return res.val;
        }
        return -1;
        
    }

    public void rebuild(Stack<TreeNode> path){
        TreeNode last = path.pop();
        if(last.right != null){
            buildPath(last.right, path);
        }
    }
    public static void main(String[] args) {
       
       
        int[] nums = new int[]{ 4,2,9,1,3,8,11,-1,-1,-1,-1,7,-1,10,12,5,-1,-1,-1,-1,13,-1,6,-1,-1,-1,-1};
        TreeNode root = fill(0, nums);
        BSTIterator it = new BSTIterator(root);

        /*while(it.hasNext()){
            System.out.println(it.next());
        }*/

    }

    public static TreeNode fill(int pos, int[] nums){
        
        if( nums[pos] == -1){
            return null;
        }
        TreeNode a = new TreeNode(nums[pos]);
        a.left = fill(pos == 0? 1: pos*2, nums);
        a.right = fill(pos == 0? 2 : pos*2+1, nums);
        return a;
    }
}




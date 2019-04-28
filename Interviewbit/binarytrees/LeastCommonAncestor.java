import java.util.ArrayList;





public class LeastCommonAncestor{

    public int lca(TreeNode A, int B, int C) {
        int res =  -1;

        ArrayList<Integer> bPath = new ArrayList<Integer>();
        ArrayList<Integer> cPath = new ArrayList<Integer>();
        if(!getPath(A, B, bPath) || !getPath(A, C, cPath) || cPath.size() < 0 || bPath.size() < 0){
            return  -1;
        }
        
        res = (bPath.size() > 0)? bPath.get(0) : -1;
        for (int i = 0; i < Math.min(bPath.size(), cPath.size()); i++) {
            if(!bPath.get(i).equals(cPath.get(i))){
               return bPath.get(i-1);
            }else{
                res= bPath.get(i);
            }
        }
        return res;
    }
    public boolean getPath(TreeNode node, int k, ArrayList<Integer> path){

        if(node == null || node.val == -1){
            return false;
        }
        path.add(node.val);
        if(node.val == k){
            return true;
        }
        if(getPath(node.left, k, path) ){
            return true;
        }
        if(getPath(node.right, k, path)){
            return true;
        }
        path.remove(path.size() -1);
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1,-1,-1 };
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
     val = x;
     left=null;
     right=null;
    }
}

package app;

public class ConvertSortedListToBST{
    public static void main(String[] args) {
        SolutionConvertSortedListToBST s = new SolutionConvertSortedListToBST();
        ListNode list=  new ListNode(-10);
        list.next = new ListNode(-3);
        list.next.next = new ListNode(0);
        list.next.next.next = new ListNode(5);
        list.next.next.next.next = new ListNode(9);
        
        //list.next.next.next.next.next = new ListNode(10);
        //list.next.next.next.next.next.next = new ListNode(15);
        //list.next.next.next.next.next.next.next = new ListNode(20);
       TreeNode r  =  s.sortedListToBST(list);
       r.print();
       
        System.out.println("done");
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class SolutionConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
       return this.res(head, size);
    }

    private TreeNode res(ListNode head, int size) {
        if (head == null || size == 0){
            return null;
        }
        ListNode middleNode = middle(head, size);
        TreeNode root = new TreeNode(middleNode.val);
        if(size == 1){
            return root;
        }    
        root.left = this.res(head, size%2 == 0 ? size/2 - 1 : size/ 2);
        root.right = res(middleNode.next,size/2);
        return root;
    }

    public int getSize(ListNode list) {
        int size = 0;
        while(list != null){
            size+=1;
            list = list.next;
        }
        return size;
    }

    public ListNode middle(ListNode list, int size){
        if(size == 1 ){
            return list;
        }
        int target = size % 2 == 0 ? size / 2 : size/2 + 1 ;
        int index = 1;
        while(list != null && index != target){
            list = list.next;
            index+=1;
        }
        return list;
    }
}
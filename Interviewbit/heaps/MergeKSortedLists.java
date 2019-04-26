import java.util.ArrayList;
import java.util.PriorityQueue;


  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }

      @Override
      public String toString() {
          String path = "";
          ListNode curr = next;
          while(curr != null){
            path += curr.val + "->";
            curr = curr.next;
          }
          return path;
      }
  }

public class MergeKSortedLists {
    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i =0; i < a.size(); i++){
            ListNode node = a.get(i);
            while(node != null){
                queue.add(node.val);
                node = node.next;
            }
        }
        
        ListNode res = null;
        if(queue.size() > 0){
            res = new ListNode(queue.poll());
        }
        ListNode headRes = res;
        while(queue.size() != 0){
            ListNode nextNode = new ListNode( queue.poll());
            res.next = nextNode;
            res = nextNode;
        }
        return headRes;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
            {1,10,20},
            {4,11,13},
            {3,8,9}
        };
        ArrayList<ListNode> lists = new ArrayList<>();
        for(int[] l : nums){
            ListNode newList = new ListNode(0);
            ListNode head = newList;
            for(int a : l){
                newList.next = new ListNode(a);
                newList = newList.next;
            }
            lists.add(head.next);
        }
        for(ListNode a : lists){
            System.out.println(a);
        }

        System.out.println(mergeKLists(lists));
        

    }
}

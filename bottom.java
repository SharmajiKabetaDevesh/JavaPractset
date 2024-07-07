
class ListNode
{
    int data;
    ListNode next;
    ListNode bottom;

    ListNode(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
    
}
public class bottom {
    ListNode flatten(ListNode root)
    {
        return mergeSort(root);
    }

    static ListNode mergeSort(ListNode head){
        if(head==null|| head.next==null)return head;

        ListNode aagewlahead=mergeSort(head.next);
        return merge(head,aagewlahead);

    }

    static ListNode merge(ListNode head,ListNode aagewlahead){
        if(head==null){
            return aagewlahead;
        }else if(aagewlahead==null){
            return head;
        }

        ListNode l=head;
        ListNode r=aagewlahead;
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(l!=null && r!=null){
            if(l.data<r.data){
                temp.bottom=l;

                temp=temp.bottom;
                l=l.next;
            }else{
                temp.bottom=r;
                temp=temp.bottom;
                r=r.next;
            }

        }

        if(l!=null){
            temp.bottom=l;
        }
        if(r!=null)temp.bottom=r;

        return dummy.bottom;
    };

    public static void main(String[] args) {

    }
}

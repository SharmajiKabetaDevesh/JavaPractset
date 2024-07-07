import java.util.ArrayDeque;
import java.util.Deque;

class MyStack
{
     class StackNode {
         int data;
         StackNode next;
         StackNode(int a) {
             data = a;
             next = null;
         }
     }
    StackNode head;
     StackNode temp;

    public MyStack(){
        head=new StackNode(-1);
        temp=head;

    }
    public static void main(String[]args){


    }
    void push(int a)
    {
        temp.next= new StackNode(a);
        temp=temp.next;
    }

    //Function to remove an item from top of the stack.
    int pop()
    {
        StackNode use=head;
        if(use.next==null)return -1;
        StackNode prev=null;
        while(use.next!=null){
            prev=use;
            use=use.next;
        }
        int x=-1;
        if(prev!=null) {
            x=prev.next.data;
            prev.next=null;
        }

        return x;
    }
}
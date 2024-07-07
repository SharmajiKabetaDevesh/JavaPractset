import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
class Node{
    int data;
    Node next;
    public Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
    public Node(int data){
        this.data=data;
        this.next=null;
    }

}



public class linkedlistbasic {

    static Node converttoLL(int [] arr){
        Node head=new Node(arr[0]);
        Node mover=head;

        for(int i=1;i<arr.length;i++){
            Node temp=new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }

static Node deletetail(Node head){
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        return head;
}

    static int countll(Node head){
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    static void printll(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }

    }

    static Node deletehead(Node head){
        head=head.next;
        return head;
    }


    static Node deleteNode(Node head ,int k){
        if(head==null ) return head;

        if(k==1){
            head=head.next;
            return head;
        }
        int count=1;

        Node prev= head;
        while(prev!=null){
            count++;
            if(count==k){
               prev.next=prev.next.next;
               break;
            }
            prev=prev.next;

        }
     return head;
    }


    static Node deleteelement(Node head,int el){
        if(head==null) return head;
        if(head.data==el){
            head=head.next;
            return head;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.next.data==el){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }

        return head;
    }

    static Node insertfirst(Node head,int element){
        Node newhead=new Node(element);
        newhead.next=head;
        return newhead;
    }

    static Node insertatlast(Node head,int element){
        Node temp=head;
        Node last=new Node(element);
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=last;

        return head;
    }

    static Node insertatanypos(Node head,int k,int ele){
        if(head==null) return new Node(ele);
        Node nodetobeinderted=new Node(ele);
        if(k==1){
            nodetobeinderted.next=head;
            return nodetobeinderted;
        }
        int count=1;
        Node prev=head;
        while(prev!=null){

            if(count==k-1){
                nodetobeinderted.next=prev.next;
                prev.next=nodetobeinderted;
                break;
            }
            count++;
            prev=prev.next;

        }
       return head;
    }

    static Node addNodebefore(Node head,int before,int ele){

        if(head==null) return new Node(ele);
        Node newnode=new Node(ele);
        if(head.data==before){
            newnode.next=head;
            return newnode;
        }
        Node temp=head;
        while(temp.next.data!=before){
            temp=temp.next;
        }

        newnode.next = temp.next;
        temp.next=newnode;

        return head;
    }
    public static boolean isPalindrome(Node head) {
        if(head==null || head.next ==null){
            return true;
        }

        Stack<Integer> stack=new Stack <>();
        Node temp=head;

        while(temp!=null ){
            stack.push(temp.data);
            temp=temp.next;
        }
        System.out.println(stack);
        System.out.println(stack.reversed());
        return (stack.reversed().equals(stack));



    }


    static Node findmid(Node head){
       Node fast=head;
        Node slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;

    }
//    public static Node addNode(Node head) {
//        ArrayList<Long> arr=new ArrayList<>();
//        Node temp=head;
//        int count=0;
//        while(temp!=null){
//            arr.add((long)temp.data);
//            count++;
//            temp=temp.next;
//        }
//        System.out.println(count);
//        Long num=0L;
//        for(int i=0;i<arr.size();i++){
//            Long currnum=arr.get(i);
//            num=((num*10)+currnum);
//        }
//        num++;
//
//        String numstring=Long.toString(num);
////        System.out.println(numstring.length());
//        Node newhead=new Node(0);
////        System.out.println(num);
////        System.out.println(numstring);
//
//        if(numstring.length()>count){
//            newhead.next=head;
//            temp=newhead;
//            for(int i=0;i<numstring.length();i++){
//                if(temp!=null){
//                    temp.data=numstring.charAt(i)-'0';
//                    temp=temp.next;
//                }
//
//
//        }
//
//return newhead;
//
//        }else{
//            temp=head;
//            for(int i=0;i<numstring.length();i++){
//                temp.data=numstring.charAt(i)-'0';
//                temp=temp.next;
//
//            }
//            return head;
//        }
//
//
//    }
    public  static void main (String args[]){
int[] array ={1,2,3,4,5};
        Node head=converttoLL(array);
//
//  printll(addNodebefore(head,100,300));
//        ArrayList<Integer> arr=new ArrayList<>();
//        arr.add(10);
//        arr.add(20);
//        arr.add(30);
//        arr.add(40);
//        arr.add(50);
//        arr.add(60);
//        arr.reversed();
//
//List<Integer> ss=  arr.subList(3,arr.size());
//ss.reversed();
//ss.clear();
//        System.out.println(arr);
//        Node temp=head;
//        while(temp!=null) {
//            arr.add(temp);
//            temp = temp.next;
//        }
//
//        System.out.println(findmid(head).data);
//        Node temp=head;
//        int carry= usingrecursion(temp,1);
//        printll(head);



printll(rotateRight(head,3));

    }
    public static void reverseme1(Node temp){
        Node curr=temp;
        Node prev=null;
        while(curr!=null){
            Node forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
        }

    }
    public static  Node rotateRight(Node head, int k) {
        Node temp=head;
        int lengthll=0;
        while(temp!=null){
            lengthll++;
            temp=temp.next;
        }
      k=k%lengthll;
        if (k == 0 || lengthll == 1) {
            return head;
        }
       temp=head;
       for(int i=1;i<(lengthll-k);i++){
           temp=temp.next;
       }
       Node firsthead=head;
       Node firstend=temp;
        Node secondhead=temp.next;
       firstend.next=null;



       Node first=reverseme(firsthead);
       Node second=reverseme(secondhead);
       firsthead.next=second;
       return reverseme(firstend);
    }

    public static Node reverseKGroup(Node head, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        Node temp=head;
        int lengthll=0;
        while(temp!=null){
            arr.add(temp.data);
            lengthll++;
            temp=temp.next;
        }
        temp=head;

        if(lengthll>=k){
            while(temp!=null){
                for(int i=k-1;i>=0;i--){
                    temp.data=arr.get(i);
                    lengthll--;
                    if(temp!=null ){
                        temp=temp.next;
                    }else if(lengthll<k||temp==null){
                        break;
                    }
                }
                List <Integer>use=arr.subList(0,k);
                use.clear();
                if(lengthll<=k && temp!=null){
                    temp=temp.next;
                } else{
                    break;
                }

            }
        }
        return head;

    }
    public static int usingrecursion(Node head,int carry){
        if(head.next==null){
            int val=head.data+carry;
            head.data=val%10;
            if(val>9){
                carry=1;
            }else{
                carry=0;
            }
            return carry;
        }

        usingrecursion(head.next,carry);
        if(carry==1){
            int val=head.data+carry;
            head.data=val%10;
            System.out.println(head.data);
            if(val>9){
                carry=1;
            }else{
                carry=0;
            }

        }
        return carry;
    }
    public static Node addOne(Node head)
    {
        Node reversed=reverseme(head);
        Node temp=reversed;
        int carry=1;
        while(temp!=null){
            if(carry==1){
                int val=temp.data+1;
                temp.data=val%10;
                System.out.println(temp.data+"  data");
                if(val>9){
                    carry=1;
                    temp=temp.next;
                    continue;
                }
                carry=0;
            }
            temp=temp.next;
        }
        printll(reversed);
        if(carry==1){
            Node newnode=new Node(1);
            newnode.next= reverseme(reversed);
            return newnode;

        }
        return reverseme(reversed);
    }

    public static Node addOne1(Node head)
    {
        Node reversehead=reverseme(head);
        Node temp=reversehead;
        int carry=0;
        while(temp!=null){
            if(temp.data==9){
                carry=1;
                temp.data=0;
            }else{
                temp.data=temp.data+1;
                carry=0;
                break;
            }

            temp=temp.next;
        }
        Node oghead=reverseme(reversehead);
        if(carry==1){
            Node newhead=new Node(1);
            newhead.next=oghead;
            return newhead;
        }else{
            return oghead;
        }

    }
    public static Node reverseme(Node head){
        Node first=null;
        Node curr=head;

        while(curr!=null){
            Node forward=curr.next;
            curr.next=first;
            first=curr;
            curr=forward;
        }
        return first;
    }

}

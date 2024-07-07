import javax.swing.tree.AbstractLayoutCache;
import java.lang.reflect.Array;
import java.nio.file.NotDirectoryException;
import java.util.*;

import static java.util.Arrays.asList;

class Nodedll {
    int data;
     Nodedll next;
     Nodedll prev;
    public Nodedll (int data ,Nodedll  next, Nodedll  prev){
        this.data=data;
        this.next=next;
       this.prev=prev;
    }


    public Nodedll (int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
public class dlllinkedlist {

    static Nodedll deletehead(Nodedll head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return null;
        }
        head=head.next;
        head.prev=null;
        return head;
    }

    static Nodedll converttodll(int []arr){
        Nodedll head=new Nodedll(arr[0]);
        Nodedll temp=head;
        for(int i=1;i<arr.length;i++){
            Nodedll newNode=new Nodedll(arr[i]);
            temp.next=newNode;
            newNode.prev=temp;
           temp=newNode;
        }
        return head;
    }
    public static Nodedll insertAtTail(Nodedll list, int K) {
        Nodedll temp=list;
        while(temp.next!=null){
            temp=temp.next;
        }
        Nodedll newNode=new Nodedll(K);
        temp.next=newNode;
        newNode.prev=temp;
        return list;
    }


    static void printforward(Nodedll head){
        Nodedll temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public static Nodedll deleteLastNode(Nodedll head) {
        if(head.next==null){
            return null;
        }
        Nodedll temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }
    @Deprecated static Nodedll deleteatk(Nodedll head,int k){
        int count=0;
        Nodedll temp=head;
        while(temp!=null ){
            count++;
            if(count==k){
              break;
            }
            temp=temp.next;
        }
        Nodedll forward=temp.next;
        Nodedll backward=temp.prev;
        if(forward==null && backward==null){
            return null;
        }else if(forward==null){
          return deleteLastNode(head);
         }else if(backward==null){
            return deletehead(head);
        }else {
            backward.next=forward;
            forward.prev=backward;
            temp.next=null;
            temp.prev=null;
        }
        return head;
     }

     static void deletenode(Nodedll temp){
        Nodedll backward=temp.prev;
        Nodedll forward=temp.next;
        if(forward==null){
            backward.next=null;
            temp.prev=null;
        }else{
            backward.next=forward;
            forward.prev=backward;
        }
     }
    @Deprecated static Nodedll inserthead(Nodedll head,int el){
        if(head==null){
            return new Nodedll(el);
        }
         Nodedll newhead=new Nodedll(el);
           newhead.next=head;
           head.prev=newhead;
         return newhead;
     }

     @Deprecated static Nodedll insetrbeforetail(Nodedll head,int el){
        if(head==null){
            return new Nodedll(el);
        }
        Nodedll temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        Nodedll forward=temp.next;
        Nodedll newnode=new Nodedll(el);
        temp.next=newnode;
        newnode.prev=temp;
        newnode.next=forward;
        forward.prev=newnode;
        return head;
     }

     @Deprecated static Nodedll insertatk(Nodedll head,int k,int el){
        if(head==null){
            return new Nodedll(el);
        }
        if(k==1){
            return inserthead(head,el);
        }
        Nodedll temp=head;
        int count=0;
        while(temp!=null){
            count++;
            if(count==k){
                break;
            }
            temp=temp.next;
        }
        Nodedll backward=temp.prev;
         Nodedll newNode=new Nodedll(el);
         if(backward.next==null){
                backward.next=newNode;
                newNode=backward;
                return head;
            } else {
            backward.next=newNode;
            newNode.prev=backward;
            newNode.next=temp;;
            temp.prev=newNode;
            return head;
        }

        }

    @Deprecated    static void insertbeforeNode(Nodedll node,int el){

        Nodedll backward=node.prev;
        Nodedll newNode=new Nodedll(el);
        backward.next=newNode;
        newNode.prev=backward;

        newNode.next=node;
        node.prev=newNode;
        }



//     @Deprecated   public static Nodedll reverseDLL(Nodedll head)
//        {
//            //    Stack<Integer> stack=new Stack<>();
//            //    Node temp=head;
//
//            //    while(temp!=null){
//            //     stack.push(temp.data);
//            //        temp=temp.next;
//
//            //    }
//
//            //    Node sec=head;
//            //    while(sec!=null){
//            //        sec.data=stack.pop();
//            //        sec=sec.next;
//
//            //    }
//
//            //    return head;
//
//            if(head==null || head.next==null){
//                return head;
//            }
//
//
//            Nodedll current=head;
//            Nodedll last=null;
//            while(current!=null){
//                last=current.prev;
//                current.prev=current.next;
//                current.next=last;
//                current=current.prev;
//            }
//
//            return last.prev;
//
//        }

    public static boolean detectCycle(Nodedll head) {
        if(head.next==null|| head==null){
            return false;
        }

        HashMap<Nodedll,Integer> hash=new HashMap<>();

        Nodedll temp=head;

        while(temp.next!=null){

            if(hash.getOrDefault(temp,0)==0){
                hash.put(temp,1);
            }else{
                return true;
            }

            temp=temp.next;
        }
        return false;
    }
//    public static Nodedll deleteAllOccurrences(Nodedll head, int k) {
//        if (head == null) {
//            return head;
//        }
//        Nodedll temp=head;
//
//        while(temp!=null){
//
//            if(temp.data==k){
//                if(temp.prev==null){
//
//                    temp=temp.next;
//                    temp.prev=null;
//                }
//                Nodedll previousone=temp.prev;
//                if(temp.next==null){
//                    previousone.next=null;
//                    return head;
//                }
//                Nodedll nextone=temp.next;
//                previousone.next=nextone;
//                nextone.prev=previousone;
//            }
//            temp=temp.next;
//        }
//
//        return head;
//    }
public static Nodedll deleteAllOccurrences(Nodedll head, int k) {
    if (head == null) {
        return head;
    }

    Nodedll temp = head;

    while (temp != null) {

        if (temp.data == k) {
            if (temp.prev == null) {
                // If the first node is equal to k
                head = temp.next;  // Update head to the next node
                if (head != null) {
                    head.prev = null;
                }
            } else {
                Nodedll previousone = temp.prev;
                Nodedll nextone = temp.next;

                if (nextone != null) {
                    nextone.prev = previousone;
                }
                previousone.next = nextone;
            }
        }
        temp = temp.next;
    }

    return head;
}

    public static Nodedll deleteAllOccurrences1(Nodedll head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        Nodedll temp=head;
        while(temp!=null){
            Nodedll previouswala=temp.prev;
            Nodedll nextwala=temp.next;
            if(temp.data==k){
                if(previouswala==null){
                    head=head.next;
                    head.prev=null;
                    temp=head;
                }else{
                    if(nextwala!=null){
                        previouswala.next=nextwala;
                        nextwala.prev=previouswala;
                    }else{
                        previouswala.next=null;
                    }
                }


            }
            temp=temp.next;
        }
        return head;
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int k, Nodedll head) {
        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
        int count=0;
        Nodedll temp=head;
        ArrayList<Integer> hash=new ArrayList<>();
        while(temp!=null){
            int diff=k-temp.data;
            if( hash.contains(diff)){
                ArrayList<Integer> foruse=new ArrayList<>();

                    foruse.add(temp.data);
                    foruse.add(diff);



                arr.add(foruse);
            }else{
                hash.add(temp.data);
            }
            temp=temp.next;
        }

        return arr;
    }


    public static boolean isPalindrome(Nodedll head) {
        Nodedll fast=head;
        Nodedll slow=head;
        Nodedll prev=null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        prev.next=null;
        printforward(head);
        Nodedll reversed=reverseme(slow);
        printforward(reversed);
        Nodedll rev=reversed;
        Nodedll temp=head;
        while(temp!=null && rev!=null){
            if(temp.data!=rev.data){
                return false;
            }
            temp=temp.next;
            rev=rev.next;
        }
        return true;
        // Stack <Integer>stack =new Stack<>();
        // Nodedll temp=head;
        // while(temp!=null){
        //     stack.push(temp.val);
        //     temp=temp.next;
        // }
        //     temp=head;
        // while(!stack.isEmpty()){
        //     if(stack.peek()!=temp.val){
        //         return false;
        //     }
        //     stack.pop();
        //     temp=temp.next;
        // }
        // return true;
    }

    static Nodedll reverseme(Nodedll slow){
        Nodedll prev=null;
        Nodedll curr=slow;
        Nodedll forward=slow.next;
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=forward;
            if(forward==null){
                break;
            }

            forward=forward.next;
        }
        return prev;
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum1(int target, Nodedll head) {
        ArrayList<ArrayList<Integer>> ret=new ArrayList<>();
        Nodedll r=head;
        while(r.next!=null){
            r=r.next;
        }
        Nodedll l=head;
        while(l!=r){
            int digit=l.data+r.data;
            if(digit==target){
                ArrayList<Integer> tp=new ArrayList<>();
                tp.add(l.data);
                tp.add(r.data);
                l=l.next;
                ret.add(tp);
            }else if(digit >target){
                r=r.prev;
            }else{
                l=l.next;
            }
        }

        return ret;

//        Nodedll temp=head;
//        ArrayList<Integer>map=new ArrayList<>();
//        ArrayList<ArrayList<Integer>> ret=new ArrayList<>();
//        while(temp!=null){
//            int a=target-temp.data;
//            if(map.contains(a)){
//                ArrayList<Integer>tp=new ArrayList<>();
//                if(a<temp.data){
//                    tp.add(a);
//                    tp.add(temp.data);
//                }else{
//                    tp.add(temp.data);
//                    tp.add(a);
//                }
//                ret.add(tp);
//            }
//            map.add(temp.data);
//            temp=temp.next;
//        }
//        return ret;
    }
    static Nodedll reverseme1(Nodedll head){
        Nodedll prev=head;
        Nodedll curr=head.next;
        Nodedll forward=null;
        if(head.next!=null){
            forward=head.next.next;
        }
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=forward;
            if(forward==null){
                break;
            }
            forward=forward.next;
        }
        return prev;
    }
    static Nodedll findnode(Nodedll temp,int k){
        int count=1;
        Nodedll use=temp;
        while(use!=null){
            if(count==k) return use;
            count++;
            use=use.next;
        }
        return null;
    }
    public static void main(String []args){

        int max=1<<3;
        if((70&max)==0){
            System.out.println("zero");
        }else{
            System.out.println("one");
        }

//        System.out.println(findPairsWithGivenSum1(5,head));
//        printforward(el);
//        printme(head);
//        printforward(head);

//      printme(rev);
////        Nodedll n3=new Nodedll(arr[3]);
////        n2.next=n3;
////        n3.prev=n2;
//        System.out.println( detectCycle(head));
//        Stack<Integer> st=new Stack<>();
//        st.push(1);
//        st.push(2);
//        st.push(2);
//        st.push(1);
//
//        System.out.println(st);
//
//        System.out.println(st.reversed());
////        int []arr1={1,23,54,45,78,78};
////        System.out.println(arr==arr1);
//



    }




    static void printme(Nodedll head){
        Nodedll temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}

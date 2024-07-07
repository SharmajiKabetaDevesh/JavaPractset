import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

//class Node{
//
//    int data;
//    Node next;
//    Node child;
//    public  Node(int data,Node next,Node child){
//        this.data=data;
//        this.child=child;
//        this.next=next;
//    }
//
//    public Node(){
//        this.data=0;
//        this.next=null;
//        this.child=null;
//    }
//
//    public Node (int data){
//        this.data=data;
//        this.next=null;
//        this.child=null;
//    }
//}
public class linkedlistflattingquestion {
//    public static Node flattenLinkedList(Node head) {
//        ArrayList<Integer> arr=new ArrayList<>();
//
//        Node temp=head;
//
//        while(temp.next!=null){
//            Node children=temp;
//            while(children!=null){
//                arr.add(children.data);
//                children=children.child;
//            }
//            temp=temp.next;
//        }
//
//        if(temp!=null && !arr.contains(temp.data)){
//            arr.add(temp.data);
//        }
//
//        Node newhead=createll(arr);
//        return newhead;
//
//    }
//
//    public static Node createll(ArrayList<Integer>arr){
//        Node head=new Node(arr.get(0));
//        Node temp=head;
//        for(int i=1;i<arr.size();i++){
//            Node newnode=new Node(arr.get(i));
//            temp.next=newnode;
//            temp=newnode;
//        }
//
//        return head;
//    }
    public static void main (String[]args){


        System.out.println(divide(10,3));
    }
    public static int divide(int dividend, int divisor) {
        return binary(0,dividend*divisor,dividend,divisor);
    }

    public static int binary(int low,int high,int dividened,int divisor){
        int mid=(low+high)/2;
        int ans=0;

        while(low<=high){
            if((mid*divisor) >=dividened){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    static int setBit(int n){
           int org=n;
        int pos=0;
        while(n>0){
            if(n%2==1){
                pos++;
            }else{
                break;
            }

            n=n>>1;
        }
        int bitmask=1<<pos;
        return org|bitmask;
    }
    public static void quicksort(int low,int high,ArrayList<Integer>arr){
        if(low<=high){
            int partition=sort(low,high,arr);
            quicksort(low,partition-1,arr);
            quicksort(partition+1,high,arr);
        }
    }

    public static int sort(int low,int high,ArrayList<Integer>arr){
        int pivot=low;
        int i=low;
        int j=high;
        while(i<j){
            while(arr.get(i)<=arr.get(pivot) && i<=high-1)i++;
            while(arr.get(j)>arr.get(pivot) && j>=low)j--;
            if(i<j){
                int temp=arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,temp);
            }
        }
        int temp=arr.get(j);
        arr.set(j,arr.get(pivot));
        arr.set(pivot,temp);
        return j;
    }
    public static double myPow(double x, int n) {
        if(n==0) return 1;
        if(x==0) return 0;
        double ans=1;
        while(n!=0){
            if(n%2==1){
                n=n-1;
                ans=x*ans;
            }else{
                x=x*x;
                n=n/2;
            }
        }

       return ans;

    }
}

import java.util.HashMap;
import java.util.Map;

//import java.util.ArrayList;
//class Stack {
//    ArrayList<Integer>arr=new ArrayList<>();
//    int num;
//    Stack(int capacity) {
//        this.num=capacity;
//    }
//    int []a=new int[num];
//    int top=-1;
//    public void push(int num) {
//        if(a.length!=999){
//            top++;
//            a[top]=(num);
//        }
//    }
//    public int pop() {
//        int prev=a[top];
//        top--;
//        return prev;
//    }
//    public int top() {
//        if(top!=0){
//            return a[top];
//        }
//        return 0;
//    }
//    public int isEmpty() {
//        if(a.length==0){
//            return 0;
//        }else{
//            return 1;
//        }
//    }
//    public int isFull() {
//        if(a.length==1000){
//            return 1;
//        }else{
//            return 0;
//        }
//    }
//
//    public static void main(String[] args) {
//        Stack s=new Stack(10);
//        s.push(140);
//        s.push(5745);
//        System.out.println(s.top());
//    }
//}
class Stack {
    //Write your code here
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
    Node head;
    Stack()
    {
        head=new Node(-1);
    }
    int getSize()
    {
        int count=0;
        Node temp=head.next;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    boolean isEmpty()
    {
        if(head.next==null){
            return true;
        }else{
            return false;
        }
    }

    void push(int data)
    {
        Node temp=head;
        Node newNode=new Node(data);
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    void pop()
    {
            if(head.next==null)return ;
            Node temp=head;
            if(temp==null)return;
            while(temp.next.next!=null){
                temp=temp.next;
            }

            temp.next=null;


    }
    int getTop()
    {
        if(head.next==null)return -1;
        Node temp=head.next;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp.data;
    }

    public static void main(String[] args) {
        String s="deve";
        HashMap<Character,Integer>arr=new HashMap<>();
        for(int i=0;i<s.length();i++){
            arr.put(s.charAt(i),arr.getOrDefault(s.charAt(i),0)+1);
        }
        int start=arr.get(s.charAt(0));
                int count=0;
        for( Map.Entry<Character,Integer> i :arr.entrySet()){
               if(i.getValue()>start){
                   count++;
               }
        }
        if(count>1){
            System.out.println(false);
        }else{
            System.out.println(true);
        }

    }
}
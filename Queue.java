import java.util.Arrays;

class Queue {
//    int front, rear;
//    int []arr;
//
//    Queue() {
//        front = 0;
//        rear = 0;
//        arr = new int[6];
//    }
//    // Enqueue (add) element 'e' at the end of the queue.
//    public void enqueue(int e) {
//        arr[rear]=e;
//        rear++;
//    }
//    // Dequeue (retrieve) the element from the front of the queue.
//    public int dequeue() {
//        if(front>=rear) return -1;
//        int prev=arr[front];
//      if(prev==0) return -1;
//
//      front++;
//
////        for(int i=1;i<rear;i++){
////            arr[i-1]=arr[i];
////        }
//
//        return prev;
//    }



     class Node {
     public int data;
     public Node next;

     Node()
     {
     this.data = 0;
     this.next = null;
     }

     Node(int data)
     {
     this.data = data;
     this.next = null;
     }

     Node(int data, Node next)
     {
     this.data = data;
     this.next = next;
     }
     };


     Node front;
     Node rear;
     void push(){};
     Queue() {
     front =new Node(-1);
     rear = front;
     }




    public static class Solution extends Queue{

        public void push(int x) {
            Node newnode=new Node(x);
            rear.next=newnode;
            rear=newnode;
        }

        public int pop() {
            if(front==null || front.next==null || rear==null)return -1;
           int prev=front.next.data;
           front=front.next;
           return prev;
        }
    }
    public static void main(String[] args) {

  Solution s =new Solution();
    s.push(45);
    s.push(100);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}

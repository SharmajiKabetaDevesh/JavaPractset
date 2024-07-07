import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.util.Queue;

public class bitwiseoperator {

    public static void findSubset(List<Integer> arr, List<Integer> ans, HashSet<List<Integer>> out) {
        if (arr.isEmpty()) {
            // Create a new ArrayList to store a copy of ans
            out.add(new ArrayList<>(ans));
            return;
        }

        int el = arr.remove(0);
        ans.add(el);
        findSubset(arr, ans, out);
        ans.remove(ans.size() - 1); // Remove the last element to backtrack
        findSubset(arr, ans, out);
        arr.add( el); // Add the removed element back to arr for backtracking
    }

    static class stack {
        ArrayList<Integer>arr=new ArrayList<>();
        stack(int capacity) {

        }
        public void push(int num) {
            if(arr.size()==1000){
                return;
            }else{
                arr.add(num);
            }
        }
        public int pop() {
            return arr.remove(arr.size()-1);
        }
        public int top() {
            if(!arr.isEmpty()){
                return arr.get(arr.size()-1);
            }
            return 0;
        }
        public int isEmpty() {
            if(arr.isEmpty()){
                return 0;
            }else{
                return 1;
            }
        }
        public int isFull() {
            if(arr.size()==1000){
                return 1;
            }else{
                return 0;
            }
        }
    }

    public static double countpow(double x ,int n){
        if(n==0)return 1;
        if(x==0)return 0;

        if(n%2==1){
            n=n-1;
            return  (countpow(x,n/2)*countpow(x,n/2)*x);
        }else{
            return countpow(x,n/2)*countpow(x,n/2);
        }
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        
        int[] prev = intervals[0];
      Arrays.sort(prev);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                merged.add(prev);
                prev = interval;
            }
        }

        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[]args){
char[][]hd=new char[10][5];
Arrays.fill(hd,'.');
        System.out.println(hd[0]);

        //        List<Integer> merged = new ArrayList<>();
//        StringBuilder s=new StringBuilder("Devesh");
//        String x= s.toString();
//
//           s.deleteCharAt(s.length()-1);
//        StringBuilder d=new StringBuilder(s.reverse());
//        System.out.println(s.equals(d));
//        System.out.println(Arrays.toString(merged.toArray()));
//  int i=4;
//        int count=0;
//        int n=1;
//        while(n<i){
//            count++;
//            n=n<<1;
//        }
//        System.out.println(count);
//        int num= 678883006 ;
//        int bitmask=1<<i-1;
//        int get=num&bitmask;
//        if(get==0) get=0;
//        else get=1;
//
//        int set=num|bitmask;
//
//        int notbitmask=~(bitmask);
//        System.out.println(bitmask);
//        System.out.println(notbitmask);
//        int clear = notbitmask&num;
//
//        System.out.println(get+" "+set+" "+ clear);
//    int []arr={1,2,3,4};
//
//        Queue<Integer>ds=new ArrayDeque<>();
//        ds.add(10);
//        ds.remove();
////        System.out.println( 1<<1);List<Integer> as=new ArrayList<>();
//       stack s =new stack(10);
//       s.push(10);
//       s.push(100);
//       s.push(200);

//        System.out.println(s.isFull());
//    for(int i:arr){
//        as.add(i);
//    }
//
//HashSet<List<Integer>> asl=new HashSet<>();
//        List<Integer>ans=new ArrayList<>();
//        findSubset(as,ans,asl);
//
//        for(List<Integer> a:asl){
//            System.out.println(a);
//        }
//
//        List<List<Integer>>oi= new ArrayList<>(asl);
    }

    public static long findpower(int n,int r){
        if(r==0){
            return 1;
        }
        if(r%2==1){
            r=r-1;
            return (n*findpower(n,r/2)*findpower(n,r/2))%1000000000;
        }else{
            return (findpower(n,r/2)*findpower(n,r/2))%1000000000;
        }
    }
}

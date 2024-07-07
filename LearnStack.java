import java.util.Stack;

public class LearnStack {
    Stack<int[]>stack;
    public  LearnStack() {
        stack=new Stack<>();
    }

    public int next(int price) {
        if(stack.isEmpty()){

            stack.push(new int[]{price,1});
            return 1;
        }

        int count=0;
        while(!stack.isEmpty() && stack.peek()[0] <=price){
            System.out.println("in");
            count+=stack.pop()[1];

        }
        stack.push(new int[]{price,count});
        return count;
    }

    public static void main(String[] args) {
        StringBuffer s=new StringBuffer("a+b*(c^d-e)^(f+g*h)-i");
        int n=s.length();
        s.reverse();
        System.out.println(s);
        String e=""+'d';
    }
}


import kotlin.Pair;

import java.util.*;
import java.util.Stack;

import static java.util.Arrays.compare;

public class MinStack {
        int top;
        int []arr;
        public MinStack() {
            top=-1;
            arr=new int[100];
        }

        public void push(int val) {
            top++;
            arr[top]=val;
            int o=top();
            System.out.println(o+" me");
        }

        public void pop() {
            top--;
        }

        public int top() {
            int prev=arr[top];

            return prev;
        }

        public int getMin() {
            int mini=Integer.MAX_VALUE;
            for(int i=top;i>=0;i--){
                mini= Math.min(mini,arr[i]);
                System.out.println(mini);
            }
            return mini;
        }

    public static String postToInfix(String postfix) {
        StringBuilder s=new StringBuilder(postfix);
        Stack<String> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            char currChar=s.charAt(i);
            if(Character.isLetterOrDigit(currChar)){
                stack.push(String.valueOf(currChar));
            }else{
                if(!stack.isEmpty()){
                    String first=stack.pop();
                    String second =stack.pop();
                    String third ="(" +  second  + currChar +first + ")";
                    stack.push(third);
                }else{
                    stack.push(String.valueOf(currChar));
                }
            }
        }

        return stack.pop();
    }
    public static String postfixToPrefix(String exp) {

        Stack<String> stack=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char currChar=exp.charAt(i);
            if(Character.isLetterOrDigit(currChar)){
                stack.push(String.valueOf(currChar));
            }else{
                if(!stack.isEmpty()){
                    String first=stack.pop();
                    String second=stack.pop();
                    String third="(" +second +currChar+first+")";
                    stack.push(third);
                }else{
                    stack.push(String.valueOf(currChar));
                }
            }
        }

        StringBuilder s=new StringBuilder(stack.pop());
        s.reverse();
        Stack<Character> stac=new Stack<>();
        StringBuilder ans= new StringBuilder();
        for(int i=0;i<s.length();i++){
            char currChar=s.charAt(i);
            if(Character.isLetterOrDigit(currChar)){
                ans.append(currChar);
            }else if(currChar==')'){
                stac.push(currChar);
            }else if(currChar=='('){
                while(!stac.isEmpty() && stac.peek()!=')'){
                    ans.append(stac.pop());
                }
                stac.pop();
            }else{
                while(!stac.isEmpty() && (precedence(stac.peek())>precedence(currChar))){
                    ans.append(stac.pop());
                }
                stac.push(currChar);
            }
        }

        while(!stac.isEmpty()){
            ans.append(stac.pop());
        }

        return ans.reverse().toString();
    }
    public static String preToPost(String exp) {
        StringBuilder s =new StringBuilder(exp);
        s.reverse();
        Stack<String> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            char currChar=s.charAt(i);
            if(Character.isLetterOrDigit(currChar)){
                stack.push(String.valueOf(currChar));
            }else{
                if(!stack.isEmpty()){
                    String first=stack.pop();
                    String second=stack.pop();
                    String third="("+first+currChar+second+")";
                    stack.push(third);
                }else{
                    stack.push(String.valueOf(currChar));
                }
            }
        }

        StringBuilder e=new StringBuilder(stack.pop());
        System.out.println(e);
        StringBuilder ans=new StringBuilder();
        Stack<Character> stac=new Stack<>();

        for(int i=0;i<e.length();i++){
            char currChar=e.charAt(i);
            if(Character.isLetterOrDigit(currChar)){
                ans.append(currChar);
            }else if(currChar=='('){
                stac.push(currChar);
            }else if(currChar==')'){
                while(!stac.isEmpty() && stac.peek()!='('){
                    ans.append(stac.pop());
                }
               if (!stac.isEmpty()) stac.pop();
            }else{
                while(!stac.isEmpty() && (precedence(stac.peek())>=precedence(currChar))){
                    ans.append(stac.pop());
                }
                stac.push(currChar);
            }
        }

        while(!stac.isEmpty()){
            ans.append(stac.pop());
        }

        return ans.toString();
    }

    public  static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int a=nums1.length;
        int b=nums2.length;
        int location=0;
        int [] arr=new int[a+1];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(nums1[i]==nums2[j] ){
                    j++;
                    while(j<b){
                        if(nums2[j]>nums1[i] ){
                            arr[location]=nums2[j];
                            location++;
                            break;
                        }
                        j++;
                    }
                    if(location<a && arr[location]==0){
                        arr[location]=-1;
                        location++;
                        break;
                    }
                }
            }
        }
        return arr;
    }


    public static int[] nextGreaterElements(int[] nums) {
        int a = nums.length;
        int[] greater = new int[a];
        int location = 0;
        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < a; j++) {
            int current = nums[j];
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(current);
                greater[location] = -1;
                location++;
            } else {
                for (int i = (2 * a) - 1; i >= 0; i--) {
                    if (nums[i % a] > current) {
                        greater[location] = nums[i % a];
                        stack.push(nums[i % a]);
                        location++;
                    } else {
                        stack.push(current);
                        greater[location] = -1;
                        location++;
                    }
                }
            }
        }
    return greater;
        }

    public static void main(String[] args) {
//            Pair<Integer,Integer> n=new Pair<>(10,20);

        HashMap<Integer,Integer>map=new HashMap<>();
        map.remove(10);
        map.put(100,1);
        if(map.containsKey(100)){
            map.put(100,map.getOrDefault(100,0)+10);
        }
//        map.remove(100);
//        System.out.println(map);
List<Integer>lr=new ArrayList<>(map.keySet());
        System.out.println(lr );
//        Stack<Pair<Integer,Integer>>stack=new Stack<>();
//        System.out.println(stack.size());
//        stack.push(n);
//        System.out.println(stack.peek().getFirst());
//ArrayList<Pair<Integer,Integer>>rr=new ArrayList<>();
//rr.add(n);
//        System.out.println(rr.get(0).component1());
//        System.out.println(rr);
//      rr.add(45);
//        rr.add(15);
//        rr.add(35);
//        rr.add(85);
//        rr.add(15);
//        System.out.println(rr);
//        Collections.reverse(rr);
//        System.out.println(rr);
//            String s="devesh sharma";
//            s=s+"";
//        System.out.println(s);
//        System.out.println(infixtoprefix("a+b*(c^d-e)^(f+g*h)-i"));
//        int[] nums1 ={4,1,2};
//Deque<Integer>d=new ArrayDeque<>();
//
//d.addFirst(10);
//        d.addLast(600);
//        d.addLast(700);
//        d.addLast(500);
//d.addLast(100);
//d.removeFirst();
//d.pollLast();
//        System.out.println(d);
//        StringBuffer ans=new StringBuffer();
//        ans.append("devbjds");
//        System.out.println(ans);
//        ans.deleteCharAt(1);
//        System.out.println(ans);
//        ArrayList<Integer> nums2 =rr;
//        System.out.println(Arrays.toString(nextGreaterElements(nums2)));
    }



  public static String infixtoprefix(String exp){
//      -+a*b^-^cde+f*ghi
//            StringBuffer s=new StringBuffer(exp);
//            s.reverse();
//            StringBuffer ans=new StringBuffer();
//            Stack<Character>stack=new Stack<>();
//            for(int i=0;i<s.length();i++){
//                char curr=s.charAt(i);
//                if(Character.isLetterOrDigit(curr)){
//                    ans.append(curr);
//                }else if(curr==')'){
//                    stack.push(curr);
//                }else if(curr=='('){
//                    while(!stack.isEmpty() && stack.peek()!=')'){
//                        ans.append(stack.pop());
//                    }
//                    if(!stack.isEmpty())stack.pop();
//                }else {
//                    while(!stack.isEmpty() &&  precedence(stack.peek()) >precedence(curr)){
//                        ans.append(stack.pop());
//                    }
//                    stack.push(curr);
//                }
//
//            }
//
//            while(!stack.isEmpty()){
//                ans.append(stack.pop());
//            }
//
//
//      return ans.reverse().toString();
      StringBuilder s=new StringBuilder(exp);
      s.reverse();
      Stack<Character> stack=new Stack<>();
      StringBuilder ans=new StringBuilder();
      for(int i=0;i<s.length();i++){
          char currChar=s.charAt(i);
          if(Character.isLetterOrDigit(currChar)){
              ans.append(currChar);
          }else if(currChar==')'){
              stack.push(currChar);
          }else if(currChar=='('){
              while(!stack.isEmpty() && stack.peek()!=')'){
                  ans.append(stack.pop());
              }
              stack.pop();
          }else{
              while(!stack.isEmpty() && precedence(stack.peek())>precedence((currChar))){
                  ans.append(stack.pop());
              }
              stack.push(currChar);
          }
      }

      while(!stack.isEmpty()){
          ans.append(stack.pop());
      }
      return ans.reverse().toString();
  }

  public static int precedence(char a){
            if(a=='^') return 3;
            else if (a=='/' || a=='*') return 2;
            else if (a=='+' || a=='-') return 1;
            else return -1;
  }
    public static String infixToPostfix(String exp ){
        StringBuilder ans =new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char currChar=exp.charAt(i);
            if(Character.isLetterOrDigit(currChar)){
                ans.append(currChar);
            }else if(currChar=='('){
                stack.push(currChar);
            }else if(currChar==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    ans.append(stack.pop());
                }
                if(!stack.isEmpty()) stack.pop();
            }else{
                while(!stack.isEmpty() && (precedence(stack.peek())>=precedence(currChar))){
                    ans.append(stack.pop());
                }
                stack.push(currChar);
            }

        }
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }

        return ans.toString();
//        Stack<Character> stack=new Stack<>();
//        StringBuilder ans=new StringBuilder();
//        for(int i=0;i<s.length();i++){
//            char currchar=s.charAt(i);
//
//            if(Character.isLetterOrDigit(currchar) ){
//                ans.append(currchar);
//            }else if(currchar=='('){
//                stack.push(currchar);
//            }else if(currchar==')'){
//                while (!stack.isEmpty() && stack.peek() != '(') {
//                    ans.append(stack.pop());
//                }
//                if(!stack.isEmpty()) stack.pop();
//            }else{
//                while(!stack.isEmpty() && prescendenceFinder(stack.peek())>=prescendenceFinder(currchar)){
//                    ans.append(stack.pop());
//                }
//
//                stack.push(currchar);
//            }
//        }
//
//        while(!stack.isEmpty()){
//            ans.append(stack.pop());
//        }
//
//        return ans.toString();
    }

    public static int prescendenceFinder(char a){
        if(a=='^'){
            return 3;
        }else if(a=='/' || a=='*'){
            return 2;
        }else if(a=='+' || a=='-'){
            return 1;
        }else{
            return -1;
        }
    }
}


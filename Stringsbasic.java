import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;
import java.util.Queue;
import java.util.Stack;


public class Stringsbasic {
    public String largestOddNumber(String num) {
        int n=num.length();
        if((num.charAt(n-1)-'0')%2 !=0){
            return num;
        }
        for(int i=n-1;i>=0;i--) {
            int currnum = num.charAt(i) - '0';
            if (currnum % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
            return "";
    }
    public static String commonPrefix(String []arr,int n){
        String matchingprefix="-1";
        String tempString=arr[0];
        for(int i=1;i<=tempString.length();i++){
            String temp=tempString.substring(0,i);
            for(int j=1;j<n;j++){
                String iterator=arr[j];
                if(!iterator.substring(0,i).equals(temp)){
                    return matchingprefix;
                }
            }
            matchingprefix=temp;
        }
        return matchingprefix;
    }

    public static boolean areIsomorphic(String str1, String str2) {

        HashMap<Character, Character> map=new HashMap<>();
        for(int i=0;i<str1.length();i++){
            if(!map.containsKey(str1.charAt(i)) && !map.containsValue(str2.charAt(i))){
                map.put(str1.charAt(i),str2.charAt(i));
            }
        }
        System.out.println(map);
        String temp="";
        for(int i=0;i<str1.length();i++){
            temp+=map.get(str1.charAt(i));
            System.out.println(temp);
        }
        System.out.println(temp);
        return temp.equals(str2);
    }
    public static int isCyclicRotation(String p, String q)  {
        int n=p.length();
        int i=0;
        while(i<n){
            char firstone=p.charAt(0);
            StringBuilder temp=new StringBuilder(p);
            temp.deleteCharAt(0);
            System.out.println(temp);
            temp.append(firstone);
            System.out.println(temp);
            if((temp.toString()).equals(q)){
                return 1;
            }
            p=temp.toString();
            i++;
        }
        return 0;
    }
    public static boolean isAnagram(String str1, String str2) {
        return permutations(str1,str2,"");
    }

    public static  boolean permutations(String str1,String str2,String ans){
        if(Objects.equals(ans, str2)){
            return true;
        }
        for(int i=0;i<str1.length();i++){
            char currchar=str1.charAt(i);
            String str=str1.substring(0,i)+str1.substring(i+1);
            System.out.println(ans +" -"+str);
            permutations(str,str2,ans+currchar);
        }

        return false;

    }

    public static boolean isAnagram1(String str1, String str2) {
//        int n1=str1.length();
//        int n2=str2.length();
//
//        if(n1!=n2) return false;
//
//        for(int i=0;i<n2;i++){
//            String temp=str2.substring(i,i+1);
//            if(!str1.contains(temp)){
//                return false;
//            }
//        }
//        return true;
//        int n1=str1.length();
//        int n2=str2.length();
//
//        if(n1!=n2) return false;
//
//        char [] stringarray1=str1.toCharArray();
//        char [] stringarray2=str2.toCharArray();
//        Arrays.sort(stringarray1);
//        Arrays.sort(stringarray2);
//        return Arrays.equals(stringarray1, stringarray2);

        ArrayList<String> permutes=new ArrayList<>();
        permutations(str1,"",permutes);
        return permutes.contains(str2);
    }
    public static void permutations(String str1,String perm,ArrayList<String> permutes ){
        if(str1.isEmpty()){
                permutes.add(perm);
        }
        for(int i=0;i<str1.length();i++){
            char currchar=str1.charAt(i);
            String temp=str1.substring(0,i)+str1.substring(i+1);
            permutations(temp,perm+currchar,permutes);
        }

    }
    public static void sortByFrequency(int n, String s) {
        HashMap <Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            int value=map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i),value+1);
        }
        char maxKey=' ';
        StringBuilder ans=new StringBuilder();
        List<Character> list=new ArrayList<>(map.keySet());
        list.sort((ob1,ob2) -> (map.get(ob2)-map.get(ob1)));
        for(char ch:list){
              for(int i=0;i<map.get(ch);i++){
                  ans.append(ch);
            }
        }
        System.out.println(ans);

    }
    public static int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I' ,  1);
        map.put('V'    ,5);
        map.put('X'   ,10);
        map.put('L'   ,50);
        map.put('C'   ,100);
        map.put('D'  ,500);
        map.put('M'  ,1000);

        int sum=0;
        for(int i=0;i<s.length()-1;i++){
            if(map.get(s.charAt(i+1))>map.get(s.charAt(i))){
                System.out.println(map.get(s.charAt(i+1))+" "+map.get(s.charAt(i)));
                sum+=map.get(s.charAt(i+1))-map.get(s.charAt(i));
                if(i==s.length()-2){
                    sum+=map.get(s.charAt(s.length()-1));
                }
            }else{
                sum+=map.get(s.charAt(i));
                if(i==s.length()-2){
                    sum+=map.get(s.charAt(s.length()-1));
                }
            }

        }


        return sum;
    }
    public  static int myAtoi(String str) {
        int n=str.length();
        String ans="";
        for(int i=0;i<n;i++){
            while(i<str.length() && (str.charAt(i) ==' ' || str.charAt(i)=='0' ) && ans.isEmpty())i++;
            if(str.charAt(i)-'0' <10  && str.charAt(i) != ' ' && str.charAt(i) !='.') {
                if(i>=1 && !ans.isEmpty()&&(str.charAt(i)=='-'|| str.charAt(i)=='+' )&& (ans.charAt(0)=='-'  || ans.charAt(0)=='+')){
                    break;
                }else{
                    ans+=str.charAt(i);
                }
            }else if(str.charAt(i)-'0' >10){
                break;
            }else if (str.charAt(i) == ' ') {
                continue;
            }else{
                break;
            }
            if(ans.length()>2){
                long d= ans.isEmpty()  ? 0:Long.parseLong(ans);
                if(d>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else if(d<Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
        }

        if(ans.length()==1 && (ans.charAt(0)=='-' || ans.charAt(0)=='+')) return 0;
        return ans.isEmpty() ? 0 :Integer.parseInt(ans);
    }

    public static int countSubStrings(String str, int k) {
//        int len =str.length();
//        if(len==k) return 1;
//        int count=0;
//
//        for(int i=0;i<len;i++){
//            String ans=""+str.charAt(i);
//            int distinctcount=1;
//            for(int j=i+1;j<len;j++){
//                if(!ans.contains(""+str.charAt(j))){
//                    System.out.println(distinctcount);
//                    distinctcount++;
//
//                }
//               ans+=str.charAt(j);
//                if(distinctcount==k){
//                    System.out.println(ans);
//
//                    count++;
//                }
//            }
//        }
//
//        return count;

        Set<Character> temp=new HashSet<>();
        for(int i=0;i<str.length();i++){
            temp.add(str.charAt(i));
        }
        if(temp.size()==k){
            return 1;
        }else{
            return temp.size()+1;
        }

    }
    public static String longestPalindrome(String s) {
    int len=s.length();
    String ans="";
    for(int i=0;i<len;i++){
        String temp="";
        for(int j=i;j<len;j++){
            temp+=s.charAt(j);
            if(ispalindrome(temp)){
                if(ans.length()<temp.length()){
                    ans=temp;
                }
            }
        }
    }
return ans;


    }

    public static boolean ispalindrome(String s){
        int low=0;
        int high=s.length()-1;

        while(low<=high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    public int beautySum(String s) {
        int len=s.length();
        if(len==1) return 0;
        int count=0;

        for(int i=0;i<len;i++){
            int []freq=new int[26];

            for(int j=i;j<len;j++){
                freq[s.charAt(j)-'a']++;
                int max=Integer.MIN_VALUE;
                int min=Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                    if(freq[k]!=0){
                        max=Math.max(max,freq[k]);
                        min=Math.min(min,freq[k]);
                    }
                }
                count+=max-min;

            }


        }

        return count;
    }
    public String reverseWords(String s) {
        s=s.trim();
        String ans="";
        int len =s.length();
        int end=len;
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)==' '){
                ans+=s.substring(i,end);
                ans=ans.trim();
                end=i;
            }
            if(i==0){
                ans+=" "+s.substring(0,end);
            }

        }
        ans=ans.trim();

        return ans;
    }
    public static void main(String[] args) {
//
//        System.out.println(myAtoi("-+00000000000654640000+"));
//Stringsbasic in=new Stringsbasic();
        int []arr={10,-1,20,30,40,50,56};
        int top=5;
        int mini=Integer.MAX_VALUE;
        for(int i=top;i>=0;i--){
            mini= Math.min(mini,arr[i]);
            System.out.println(mini);
        }
//          String s="(){}[]";
//        Stack<Character> stack=new Stack<>();
//
//        for(int i=1;i<s.length();i++){
//            char curchar=s.charAt(i);
//            if(!stack.isEmpty()){
//
//                char attop=stack.peek();
//                if(curchar==')' && attop=='(') stack.pop();
//                else if(curchar==']' && attop=='[') stack.pop();
//                else if(curchar=='}' && attop=='{') stack.pop();
//                else{
//                    stack.push(s.charAt(i));
//                }
//            }else{
//                stack.push(s.charAt(i));
//            }
//        }
//        System.out.println(stack);
//        System.out.println(stack.isEmpty());

//String s="  Dev             ";
//
//        System.out.println(s.trim());

//        System.out.println(temp);
//
//        System.out.println(a==b);
//        System.out.println(temp.reverse());





//        String []d={"QQFV",
//                "QQFVvYVwS",
//                "QQFVzC"};
//        System.out.println(commonPrefix(d,d.length));
//            String data = "I am Devil";

//        System.out.println(data.startsWith("i"));
//        System.out.println(data.contains("i"));4
//            Stack<String> stack = new Stack<>();
//
//            for (int i = 0; i < data.length(); i++) {
//                String word = "";
//                while (i < data.length() && data.charAt(i) != ' ') {
//                    word += data.charAt(i);
//                    i++;
//                }
//                stack.push(word);
//            }
//
//            while (!stack.isEmpty()) {
//                System.out.print(stack.peek());
//                stack.pop();
//            }


        }
    }


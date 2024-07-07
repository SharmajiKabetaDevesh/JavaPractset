import java.lang.reflect.Array;
import java.util.*;
import java.util.Stack;

public class MonoticStack {
    public  static int[] asteroidCollision(int[] arr) {
        int n=arr.length;
        ArrayList<Integer>temp=new ArrayList<>();
        for (int i=0;i<n;i++){
            if(temp.isEmpty()){
                temp.add(arr[i]);
                continue;
            }
            if((temp.get(temp.size()-1) == Math.abs(arr[i])   && arr[i]<0 )|| (Math.abs(temp.get(temp.size()-1)) == arr[i]   && temp.get(temp.size()-1)<0) ){
                temp.remove(temp.size()-1);
                continue;
            }
            if(temp.get(temp.size()-1)>0 && arr[i]>0){
                temp.add(arr[i]);
                continue;
            }

            if(temp.get(temp.size()-1)<0 && arr[i]<0){
                temp.add(arr[i]);
                continue;
            }
            if(temp.get(temp.size()-1)>0  && arr[i]<0){
                while(!temp.isEmpty() && (Math.abs(arr[i]) >temp.get(temp.size()-1))  ){
                    temp.remove(temp.size()-1);

                }
            }
//            if(!temp.isEmpty() && temp.get(temp.size()-1) < 0 && arr[i]>0 ){
//                while(!temp.isEmpty() && !(Math.abs(temp.size()-1) > arr[i]) ){
//                    temp.remove(temp.size()-1);
//                }
//            }
        }
        int []ans=new int[temp.size()];
        int loc=0;
        for(int i=0;i<temp.size();i++){
            ans[loc]=temp.get(i);
            loc++;
        }
        temp.clear();

        return ans;
    }

    public  static int[] asteroidCollision1(int[] arr){
//        int n=arr.length;
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            while(!stack.isEmpty() && arr[i]<0 && stack.peek()>0){
//                int sum=arr[i]+stack.peek();
//                if(sum<0){
//                    stack.pop();
//                }else if(sum>0){
//                    arr[i]=0;
//                }else{
//                    arr[i]=0;
//                }
//            }
//            if(arr[i]!=0){
//                stack.push(arr[i]);
//            }
//
//        }
//        int []ans=new int [stack.size()];
//        int loc=stack.size()-1;
//        while(!stack.isEmpty()){
//             ans[loc]=stack.pop();
//             loc--;
//        }
//        return ans;

        int n=arr.length;
        Stack <Integer>stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[i]<0 && stack.peek()>0){
                int sum=arr[i]+stack.peek();
                if(sum<0){
                    stack.pop();
                }else if(sum>0){
                    arr[i]=0;
                }else{
                    stack.pop();
                    arr[i]=0;
                }
            }
            if(arr[i]!=0){
                stack.push(arr[i]);
            }
        }

        int []ans=new int[stack.size()];
        int loc=stack.size()-1;
        while(!stack.isEmpty()){
            ans[loc]=stack.pop();
            loc--;
        }


        return ans;
    }
    static public void printNos(int n)
    {
        if(n==0)return;

        System.out.println(n);
        printNos(n-1);
    }

    public static void frequencyCount(int[] arr, int N, int P)
    {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);

        }
        int count=1;

        for(int i=0;i<arr.length;i++){
            arr[i]=map.getOrDefault(count,0);
            count++;
        }

    }




    static long merge(long[]arr,int low,int high){
        long count=0;
        if(low<high){
            int mid=(low+high)/2;
            count+=merge(arr,low,mid);
            count+=merge(arr,mid+1,high);
            count+=mergeSort(arr,low,mid,high);
            return count;
        }
        return count;
    }
    static long mergeSort(long []arr,int low,int mid,int high){
        ArrayList<Long>temp=new ArrayList<>();
        int count=0;
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high) {
            if (arr[left] < arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                count=(mid-left+1);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=0;i<temp.size();i++) {
            arr[i + low] = temp.get(i);
        }

        return count;
    }
//    static void quickSort(int[] arr, int low, int high)
//    {
//        if(low<high){
//            int part=partition(arr,low,high);
//            quickSort(arr,low,part-1);
//            quickSort(arr,part+1,high);
//        }
//    }
//    static int partition(int[] arr, int low, int high){
//        int pivot =low;
//        int i=low+1;
//        int j=high;
//        while(i<=high && j>low){
//            while(arr[i] > arr[pivot]) i++;
//            while(arr[j] <=arr[pivot]) j--;
//            if(i<j){
//                int temp=arr[i];
//                arr[i]=arr[j];
//                arr[j]=temp;
//            }
//        }
//        int temp=arr[pivot];
//        arr[pivot]=arr[j];
//        arr[j]=temp;
//        return j;
//    }

    static void reverse(int []arr,int start,int end){
        int low=start;
        int high=end;

        while(low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
    }


     static void quickSort(int[] arr, int low, int high){
         if(low<high){
             int mid=partition(arr,low,high);
             quickSort(arr,low,mid-1);
             quickSort(arr,mid+1,high);
         }
     }
     static int partition(int [] arr,int low,int high){
         int pivot=arr[low];
         int i=low+1;
         int j=high;
         while(i<j){
             while( i<=high && pivot >= arr[i] )i++;
             while(j>=low && pivot < arr[j] )j--;
             if(i<j){
                 int temp=arr[i];
                 arr[i]=arr[j];
                 arr[j]=temp;
             }
         }
         int temp=arr[low];
         arr[low]=arr[j];
         arr[j]=temp;
         return j;
     }

    static long pow2(long num,long n){
        if(n==0){
            return 1;
        }
        if(num==0){
            return 1;
        }
        if(n%2==1){
            n=n-1;
            return pow2(num,n-1)*n;
        }else{
            return pow2(num,n/2)*pow2(num,n/2);
        }
    }

    public static  String removeOuterParentheses(String s) {
        StringBuffer temp=new StringBuffer();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' ){
                stack.push(s.charAt(i));
                System.out.println(stack);
            }else if(s.charAt(i)==')' && stack.peek()==')' ){
                while(!stack.isEmpty() && stack.peek()!='('){
                    System.out.println(stack);
                    temp.append(stack.pop());
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        return temp.toString();
    }

    public static String longestCommonPrefix(String[] strs) {

        String a=strs[0];
        int n=strs.length;
        if(n==1)return a;
        String ans="";
        for(int i=1;i<=a.length();i++){
            String temp=a.substring(0,i);
            for(int j=1;j<n;j++){
                String now=strs[j];
                if(i>now.length() || !temp.equals(now.substring(0,i))){
                    System.out.println(ans+"1");
                    // System.out.println(temp);
                    return now.substring(0,i-1);
                }
                ans=temp;

            }


        }
        return ans;

    }
    public static boolean isIsomorphic(String s, String t) {
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);


    }

    public static int myAtoi(String s) {
        if(s.isEmpty())return 0;
        int i=0;
        int n=s.length();
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        if(s.charAt(0)=='.') return 0;
        if(i>=n || Character.isLetter(s.charAt(0))){
            return 0;
        }
        // if(s.charAt(i)=='+' && (i+1)<n &&  s.charAt(i+1)=='-'){
        //     return 0;
        // }
        // if(s.charAt(i)=='-' && (i+1)<n &&  s.charAt(i+1)=='+'){
        //     return 0;
        // }
        int negative=0;
        if(s.charAt(i)=='-'){
            negative=1;
            i++;
        }else if(s.charAt(i)=='+'){
            negative=0;
            i++;
        }

        int ans=0;
        for(int j=i;j<n;j++){
            if(Character.isDigit(s.charAt(j))){
                ans=(ans*10)+(s.charAt(j)-'0');
            }else{
                break;
            }
            if(ans >(Integer.MAX_VALUE/10)) {
                if(negative==1){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            };

        }

        if(negative==1)return ans*-1;
        else return ans;

    }
    public static void main(String []args){
//        String [] s= {"ab", "a"};
//        String x ="egg";

        String f="I will die soon";
        String []h=f.split(" ");
        System.out.println(Arrays.toString(h));
        String t ="2147483646";
//        HashMap<Character,Integer> map=new HashMap<>();
//List<Character>z=new ArrayList<>(map.keySet());
        System.out.println(myAtoi(t));
        System.out.println(2147483646>Integer.MAX_VALUE);
//        System.out.println(longestCommonPrefix(s));
//        System.out.println(s!=" ");?
//        System.out.println(removeOuterParentheses(s));

//        int k=3;
//        HashMap<Integer,Integer>map=new HashMap<>();
//        ArrayList<Long>temp=new ArrayList<>();
//     int []arr={16 ,17 ,4 ,3 ,5, 2,4,65,87,25,87,2,854,6,684,2,85,4,0,1,6};
//       quickSort(arr,0,arr.length-1);


//        System.out.println(pow2(5,2));

//     Arrays.sort(arr);
//      int n=arr.length;
//        List<Integer>list=new ArrayList<>();
//        list.sort(null);
//        Stack<Integer>stack=new Stack<>();
//
//        stack.push(arr[n-1]);
//        for(int i=n-2;i>=0;i--){
//            if(arr[i] >stack.peek()){
//                stack.push(arr[i]);
//            }
//        }
//
//        ArrayList<Integer>temp=new ArrayList<>();
//        while(!stack.isEmpty()){
//            temp.add(stack.pop());
//        }
//
//        System.out.println(temp);
//        reverse(nums,k+1,nums.length-1);
//        System.out.println(Arrays.toString(nums));
//        reverse(nums,0,nums.length-1);
//        System.out.println(Arrays.toString(nums));


//        int []ans=asteroidCollision1(arr);
//        System.out.println(Arrays.toString(ans));
//        StringBuilder str=new StringBuilder();
//        str.append("devesh");
//        str.deleteCharAt(0);
//        int s=Integer.parseInt("110");
//        int a=354293;
//        Long b=125208L;
//        long d=(long) a;
//        Long min= Math.min(a,b);
//        Long gcd =0L;
//        Long lcm=0L;
//        for(Long i=min;i>2L;i-- ){
//            if(gcd == 0L && a % i==0L && b %i==0L){
//                gcd=i;
//            }
//        }
//        if(gcd !=0) lcm =(a*b)/gcd ;
//        else {lcm =(a*b); gcd =1L;}
//        Long []arr={lcm,gcd};
//        System.out.println(Arrays.toString(arr));
//printNos(64);
//        String s="A man, a plan, a canal: Panama";
//        StringBuffer a=new StringBuffer();
//        for(int i=0;i<s.length();i++){
//            if(Character.isLetterOrDigit(s.charAt(i))){
//                a.append(Character.toLowerCase(s.charAt(i)));
//            }
//        }
//StringBuffer b = new StringBuffer();
//        b.append(a);
//        b.reverse();
//        System.out.println(a.compareTo(b)==0);


//        Scanner sc=new Scanner(System.in);
//        String d=sc.nextLine();
//                    switch (Integer.parseInt(d)){
//                        case 4:
//                            System.out.println(4);
//                            break;
//                        case 5:
//                            System.out.println(7);
//                            break;
//                    }
//        if((d.charAt(0)) >= ('A') && d.charAt(0) <= ('Z') ){
//            System.out.println(1);
//        }else if((d.charAt(0))>= ('a') && (d.charAt(0) )<= ('z')){
//            System.out.println(0);
//        }else{
//            System.out.println(-1);
//        }
        
    }
}

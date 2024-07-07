import java.util.*;
import java.util.ArrayList;
import static java.lang.System.in;
import static java.lang.System.out;


public class Main {
    public static  void print1(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("*");
            };
            System.out.println();
        };
    }
    public static  void print2(int n){
       for(int i=0;i<n;i++){
           for(int j=0;j<=i;j++){
               System.out.print("*");
           }
           System.out.println();
       }
    }
    public static void nNumberTriangle(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            for(int k=0;k<n-i-1;k++){
                System.out.print(" ");
            }
            System.out.println();

        }
    }
    public static void nStarTriangle(int n) {
        for(int i=n;i>0;i--){
            for(int j=0;j<=n-i-1;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*i-1;j++){
                System.out.print("*");
            }
            for(int k=0;k<=n-i-1;k++){
                System.out.print(" ");
            }
            System.out.println();
        }

    }
    public static void nBinaryTriangle(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print(1+" ");
                } else if ((i+j)%2==1) {
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }
    public static void numberCrown(int n) {

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            for(int k=0;k<(2*(n-i));k++){
                System.out.print(" ");
            }

            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            System.out.println();


        }


        }

    public static void alphaRamp(int n) {
        char[]m={'A','B','C','D','R','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for(int i =0;i<n;i++){

            for(int j=0;j<=i;j++){
                System.out.print(m[i]+" ");
            }

            System.out.println();
        }
    }




        public static void alphaHill(int n) {
            char[] c={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z'};
            for(int i=0;i<n;i++){
                for(int j=0;j<n-i-1;j++){
                    System.out.print(" ");
                }
                for(int k=0;k<=i;k++){
                    System.out.print(" "+c[k]+"");
                }

                for(int k=i-1;k>=0;k--){
                    System.out.print(" "+c[k]+"");
                }

                System.out.println();
            }
        }


    public static void alphaHill2(int n) {

        // Create 'l' and 'r' and assign (2*N-1)/2.
        int l = (2*n-1)/2, r = (2*n-1)/2 ;

        // For loop 'row' in range 0 to N-1.
        for(int row = 0; row < n; row++) {

            // For loop 'col' in range 0 to 2*N-2.
            // Create char 'ch' and assign with 'A'.
            char ch = 'A' ;
            for(int col = 0; col < 2*n-1; col++) {

                // Condition for forward increment in alphabets.
                if(col>=l && col<=(l+r)/2) {
                    System.out.print(ch + " ");
                    ch++ ;
                }

                if (col < l || col > r) {
                    System.out.print(" ");
                }

                // Condition for transition.
                if(col == (l+r)/2) {
                    ch-- ;
                }

                // Condition for reverse order.
                if(col>(l+r)/2 && col<=r) {
                    ch-- ;
                    System.out.print(ch + " ");
                }
            }

            // Update l and r.
            --l ;
            ++r ;

            // End the current row of the pattern.
            System.out.println();
        }
    }


    public static void alphaTriangle(int n) {
     char []ch ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z'};
     for(int i=n-1;i>=0;i--){
         for(int j=n-1;j>=i;j--){
             System.out.print(ch[j]+" ");
         }
         System.out.println();
     }


    }

    public static void print19(int n){
        for(int i=0;i<n;i++){
            for(int j=n-i-1;j>=0;j--){
                System.out.print("*");
            }
            for(int j=0;j<2*i;j++){
                System.out.print(" ");
            }
            for(int j=n-i-1;j>=0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            for(int j=0;j<2*(2-i);j++){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }


    }
    public static void symmetry(int n) {
        for(int i=0;i<n;i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 0; j < 2 * (2 - i); j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int i=0;i<n-1;i++){
            for(int j=n-2;j>=i;j--){
                System.out.print("* ");
            }
            for(int k=0;k<(2*i)+2;k++){
                System.out.print("  ");
            }
            for(int j=n-2;j>=i;j--){
                System.out.print("* ");
            }

            System.out.println();
        }


    }


    public static void hollow(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0||i==n-1){
                    System.out.print("*");
                }else if(j==0||j==n-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
    public static void getNumberPattern(int n) {
        for(int i=0;i<(2*n)-1;i++){
            for(int j=0;j<(2*n)-1;j++){
                int top=i;
                int left=j;
                int right=(2*n)-2-j;
                int bottom=(2*n)-2-i;
                int output=n-Math.min(Math.min(top,bottom),Math.min(left,right));
                System.out.print(output);
            }
            System.out.println();
        }


    }
    public static int countDigits(int n){

        int count=0;
        while (n>0){
            count=count+1;
            n=n/10;
        }
        return count;
    }
    public static int DivideDigits(int n){
        int first=0;

        int digit=n;
        while(digit>0){
            int divisor=digit%10;
            if(divisor==0){
                digit=digit/10;
                divisor=digit%10;
            }
            if(n%divisor==0){
                first=first+1;

            }
            digit=digit/10;
        }


        return first;
    }

    public static int reverse(int x) {
        int reversenumber=0;

        while(x!=0){
            int lastdigit=x%10;
            x=x/10;
            reversenumber=(reversenumber*10)+lastdigit;
        }
        return reversenumber;
    }
    public static int calcGCD(int n, int m) {
         int gcd=0;
         int max=Math.max(n,m);

            for (int i = 2; i <= max; i++) {
                if (n % i == 0 && m % i == 0) {
                    gcd=i;
                }

            }

        if(gcd==0){
            return 1;
        }else{
            return gcd;
        }

    }
    public static boolean checkArmstrong(int n){
        int arms=0;
        int check=n;
        String num=Integer.toString(n);
        while(n!=0){
            int lastdigit=n%10;
            n=n/10;
            arms= (int) (arms+Math.pow(lastdigit,num.length()));

        }
        return arms == check;
    }
    public static int sumOfAllDivisors(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i%j==0){
                    sum=sum+j;
                }
            }


        }
        return sum;
    }

    public static String isPrime(int num) {
        int flag=1;

        for(int i=num+1;i<num;num++){
            if(num%i==0){
                flag=0;
            }
        }
        return "NO";
    }
    public static int[] printNos(int x,int[]array,int index) {
        if(index>x){
            return array;
        }

        array[index-1]=index;
        System.out.println(array[index-1]);
       return printNos(x,array,index+1);

    }
    public static int print1ton(int n){
        if(n==1){
            System.out.println(1);
            return 0;
        }
        print1ton(n-1);
        System.out.println(n);
        return 0;
    }
    public static void printNtimes(int n){
        if(n==1){
            System.out.print(" Coding Ninjas");
            return;
        }
        System.out.print(" Coding Ninjas");
        printNtimes(n-1);
    }
    public static int[] addelement(int x,int []array,int index){
        if(index>x){
            return array;
        }
        array[index-1]=index;
       return addelement(x,array,index+1);

    }
    public static int[] printNos(int x) {
         int []array=new int[x];
        return addelement(x,array,1);

    }

    public static long helpermethod(long n,long j){
        if(n==0){
            return j;
        }
        return helpermethod(n-1, j+n);
    }
    public static long sumFirstN(long n) {
        long j=0;
        return helpermethod(n, j);
    }
    public static int fact(int num){
        if(num==1){
            return 1;
        }

        return num*fact(num-1);
    }
    public static List<Long> factorialNumbers(long n) {
        // Write Your Code Here
        List<Long> arrayforstoring=new ArrayList<Long>();
        arrayforstoring.reversed();

        for(long i=1;i<n;i++){
            long fact=1;

            for(long j=1;j<=i;j++){
                fact=fact*j;
            }
            if(fact<=n){
                arrayforstoring.add(fact);
            }else{
                fact=0;
                break;
            }
        }
        return arrayforstoring;
    }
    public static int[] reverseme(int n,int [] nums,int[]reversed,int index){
        if(n==0){
            return reversed;
        }
        reversed[n-1]=nums[index];
        return reverseme(n-1, nums, reversed, index+1);
    }
    public static int[] reverseArray(int n, int []nums) {
        int[] reversed=new int[n];
        return reverseme(n, nums, reversed, 0);
    }
    public static boolean helperMethod(String str,String reversed,int stringlength){
        if(stringlength<0){
            if(str.equals(reversed)){
                return true;
            }else{
                return false;
            }
        }

        String a=reversed +str.charAt(stringlength);
        return helperMethod(str, a, stringlength-1);

    }
    public static boolean isPalindrome(String str) {
        int stringlength=str.length();
        String reversed="";
        return helperMethod(str,reversed,stringlength-1);

    }
    public static int fibbonacci(int i,int j,int upto){
        if(upto==0){
            return j;
        }
        System.out.print(i+" ");
        return fibbonacci(j,j+i,upto-1);
    }

    public static int[] countFrequency(int n, int x, int []nums){
        int[] hashcounts=new int [nums.length];

        for(int i=0;i< nums.length;i++){
            if(nums[i]>=n){
                continue;
            }
            hashcounts[nums[i]]+=1;
        }
        for(int i=0;i<nums.length-1;i++){
            int temp=hashcounts[i+1];
            hashcounts[i]=temp;
            hashcounts[i+1]=0;
        }

        return hashcounts;

    }

    public static int[] hashcountcharacter(char[]array){
        int []hasharray=new int[26];

        for (char c : array) {
                hasharray[c - 'a']++;
        }
        return hasharray;
    }
    public static int[] getFrequencies(int []v) {
       int []hash=new int[v.length];
       int []highlow=new int [2];
       int high=0;
       int low=0;
        for(int i=0;i<v.length;i++){
            if(v[i]<v.length){

                hash[v[i]-1]+=1;

            }
        }for(int i=0;i<hash.length;i++){
            if(hash[i]>high){
                System.out.print(hash[i]+" high");
                high=i;
            }else if(hash[i]<=low){
                System.out.print(hash[i]+"low ");
                low=i;
            }
        }
        highlow[0]=low;
        highlow[1]=high;

        return highlow;

    }

    public static int[] hashtrial(int []array){

        Map<Integer,Integer> data=new HashMap<>();

        for(int i=0;i< array.length;i++){
            if(data.containsKey(array[i])){
                out.println(array[i]+"d");
                data.put(array[i],data.get(array[i])+1);
            }else{
                data.put(array[i],1);
            }
        }
         int maxEle=0,maxCount=0;
        int minEle=0,minCount= array.length;
        for(Map.Entry<Integer,Integer> entry:data.entrySet()){
            int count=entry.getValue();
            int value=entry.getKey();


            if(count>maxCount){
                maxCount=count;
                maxEle=value;
            }
            if (count < minCount) {
                minEle = value;
                minCount = count;
            }

        }
        return new int[]{maxEle,minEle};





    }static void Frequency(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int maxFreq = 0, minFreq = n;
        int maxEle = 0, minEle = 0;
        // Traverse through map and find the elements
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int element = entry.getKey();

            if (count > maxFreq) {
                maxEle = element;
                maxFreq = count;
            }
            if (count < minFreq) {
                minEle = element;
                minFreq = count;
            }
        }

    }
    public static int[] getFrequencies2(int []v) {

        Map<Integer,Integer> datahash=new HashMap<>();

        for(int i=0;i<v.length;i++){

            if(datahash.containsKey(v[i])){
                datahash.put(v[i],datahash.get(v[i])+1);
            }else{
                datahash.put(v[i],1);
            }
        }


        int maxEle=0,maxCount=0;
        int minEle=0,minCount=v.length;

        for(Map.Entry<Integer,Integer> findinghighlowcount:datahash.entrySet()){
            int count=findinghighlowcount.getValue();
            int element=findinghighlowcount.getKey();
            if(count>maxCount){
                maxCount=count;
                maxEle=element;
            }
            if(count<minCount){
                minCount=count;
                minEle=element;
            }
        }

        return new int[]{maxEle,minEle};

    }
    public static int[] getFrequencies1(int []v) {

        Map<Integer,Integer> datahash=new HashMap<>();

        for(int i=0;i<v.length;i++){

            if(datahash.containsKey(v[i])){
                datahash.put(v[i],datahash.get(v[i])+1);
            }else{
                datahash.put(v[i],1);
            }
        }


        int maxEle=0,maxCount=0;
        int minEle=Integer.MAX_VALUE,minCount=v.length;

        for(Map.Entry<Integer,Integer> findinghighlowcount:datahash.entrySet()){
            int count=findinghighlowcount.getValue();
            int element=findinghighlowcount.getKey();
            if(count>maxCount){
                maxCount=count;
                maxEle=element;
            }
            if (count < minCount) {
                minCount = count;
                minEle = element;
            } else if (count == minCount && element < minEle) {
                minEle = element;
            }
//            if(count<minCount){
//                minCount=count;
//                if(minEle>element){
//
//                minEle=element;
//            }
//            }
        }

        return new int[]{maxEle,minEle};

    }

    public static int[] selectionsort(int[]array){

        for(int i=0;i<array.length;i++){
            int smallest=i;
            for(int j=i+1;j<array.length;j++){
                if(array[smallest]>array[j]){
                    smallest =j;
                }
            }
            int temp=array[smallest];
            array[smallest]=array[i];
            array[i]=temp;
        }
        return array;
    }



    public static void bubbleSort(int[]array){

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        for(int d:array){
            out.print(d+" ");
        }
    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low>=high) return;

        int mid=(low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1, high);
        sort(arr,low,mid,high);

    }

    public static void sort(int[] arr,int low,int mid,int high){
        ArrayList<Integer> temp=new ArrayList<Integer>();
        int left=low;
        int right=mid+1;

        while(left<=mid&&right<=high){
            if(arr[left]<arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
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

        for(int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }

    }

    public static int[] bubbleSort1(int[]array){

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }

        return array;
    }

    static int[] selectionSort1(int []array){
        for(int i=0;i<array.length;i++){
            int smallest =i;
            for(int j=1+i;j<array.length;j++){
                if(array[smallest]>array[j]){
                    smallest=j;
                }
            }
            int temp=array[i];
            array[i]=array[smallest];
            array[smallest]=temp;

        }

        return array;
    }

    static int[] insertionSort1(int[]array){
        for(int i=1;i<array.length;i++){
            int current=array[i];
            int j=i-1;
            while(j>=0&&current<array[j]){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=current;
        }
        return array;
    }

//
static int[] mergeSort1(int[] array, int low, int high) {
    if (low >= high) {
        return array;
    }
    int mid = (low + high) / 2;
    mergeSort1(array, low, mid);
    mergeSort1(array, mid + 1, high);
    return merger(array, low, mid, high);
}

    static int[] merger(int[] array, int low, int mid, int high) {
        ArrayList<Integer> datasorted = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                datasorted.add(array[left]);
                left++;
            } else {
                datasorted.add(array[right]);
                right++;
            }
        }
        while (left <= mid) {
            datasorted.add(array[left]);
            left++;
        }
        while (right <= high) {
            datasorted.add(array[right]);
            right++;
        }

        for (int i = 0; i < datasorted.size(); i++) {
            array[low + i] = datasorted.get(i);
        }

        return array;
    }

    static int[] recursiveBubblesort(int []array,int low){
        if(low>=array.length-1){
            return array;
        }
        for(int i=0;i<array.length-low-1;i++){
        if(array[i]>array[i+1]){
            int temp =array[i];
            array[i]=array[i+1];
            array[i+1]=temp;
        }
        }

        return recursiveBubblesort(array,low+1);
    }

    public static int[] bubbleSort123(int[] arr, int n) {
        if(n==0){
            return arr;};
        for(int j=0;j<n-1;j++){
            if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
          return  bubbleSort123(arr, n-1);


    }


    static int[] recursiveselectionSort(int []array,int n,int iterative){
        if(n==0) return array;
        int smallest =iterative;
        for(int i=1+iterative;i<array.length;i++){
            if(array[smallest]>array[i]){
                smallest=i;
            }
        }
        int temp =array[iterative];
        array[iterative]=array[smallest];
        array[smallest]=temp;

       return  recursiveselectionSort(array,n-1,++iterative);

    }


    public static int[] insertion(int []array,int i){
        if(i==array.length) return array;
        int current=array[i];
            int j=i-1;
            while(j>=0&&current<array[j]){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=current;


        return insertion(array,++i);
    }

    static int[] QuickSort(int []array,int low,int high){

        if(low<high){
            int partitionindex=partition(array,low,high);
            QuickSort(array,low,partitionindex-1);
            QuickSort(array,partitionindex+1,high);

        }
        return array;
    }
    static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (pivot>=array[i]  && i <= high - 1) {
                i++;
            }
            while ( pivot<array[j]  && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap pivot with the correct position
        int temp = array[low];
        array[low] = array[j];
        array[j] = temp;

        return j;
    }

//    static int partition(int []array,int low,int high){

//
//        int i=low;
//        int j=high;
//        int pivot=array[low];
//        while(i<j){
//            while(array[i]<=pivot&&i<=high-1){
//                i++;
//            }
//            while(array[j]>pivot&&j>=low+1){
//                j--;
//            }
//            if(i<j){
//            int temp =array[i];
//            array[i]=array[j];
//            array[j]=temp;
//        }
//        }
//        int temp = array[low];
//        array[low] = array[j];
//        array[j] = temp;
//
//        return j;
//    }
public static List<String> appendOperators(String num, int target) {
    int first=num.charAt(0)-'0';
    StringBuffer s=new StringBuffer();
    s.append(first);
    List<String >ans=new ArrayList<>();
    solveMe(num,1,first,target,ans,s);
    return ans;
}

    public static void solveMe(String num,int index,int val,int target,List<String>ans,StringBuffer ds){
        if(index>=num.length()){
            if(val==target){
                out.println(ds.toString());
                ans.add(ds.toString());
            }
            return;
        }
        out.println(ds.toString());
        int currDigit=num.charAt(index)-'0';
        int plus = val+currDigit;
        ds.append('+');
        ds.append(num.charAt(index));
        solveMe(num,index+1,plus,target,ans,ds);
        ds.deleteCharAt(ds.length()-1);
        ds.deleteCharAt(ds.length()-1);


        int minus = val-currDigit;
        ds.append('-');
        ds.append(num.charAt(index));
        solveMe(num,index+1,minus,target,ans,ds);
        ds.deleteCharAt(ds.length()-1);
        ds.deleteCharAt(ds.length()-1);

        int multi = val*currDigit;
        ds.append('*');
        ds.append(num.charAt(index));
        solveMe(num,index+1,multi,target,ans,ds);
        ds.deleteCharAt(ds.length()-1);
        ds.deleteCharAt(ds.length()-1);
    }

    public static void quickSort(int []arr,int low,int high){
        if(low<=high){
            int part=partition1(arr,low,high);
            quickSort(arr,low,part-1);
            quickSort(arr,part+1,high);
        }
    }
    public static int partition1(int[] arr, int low, int high){
        int pivot=low;
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]<=arr[pivot] && i<=high )i++;
            while(arr[j]>arr[pivot] && j>=low) j--;
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        int temp=arr[pivot];
        arr[pivot]=arr[j];
        arr[j]=temp;
        return j;
    }
    public static void main(String[] args) {
        HashMap <Character,Integer>map=new HashMap<>();


    }

    static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
        int i = 0, j = 0; // pointers
        ArrayList<Integer> Union = new ArrayList<>(); // Uninon vector
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) // Case 1 and 2
            {
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            } else // case 3
            {
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                    Union.add(arr2[j]);
                j++;
            }
        }
        while (i < n) // IF any element left in arr1
        {
            if (Union.get(Union.size() - 1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }
        while (j < m) // If any elements left in arr2
        {
            if (Union.get(Union.size() - 1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }
        return Union;
    }
}


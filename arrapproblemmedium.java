
import java.lang.reflect.Array;
import java.util.*;
public class arrapproblemmedium {
    public static String read(int n, int []arr, int target){
        // Write your code here.

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if((arr[i]+arr[j])==target){
                    return "YES";
                }
            }
        }
        return "NO";
    }
    public static String read1(int n, int []arr, int target){

        HashMap<Integer,Integer> hashmap=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int subtracted=target-arr[i];

            if(hashmap.containsKey(subtracted)){
                return "YES";
            }else{
                hashmap.put(arr[i],i);
            }
        }

        return "NO";

    }
    public static String read2(int n, int []arr, int target){
        // Write your code here.

        HashMap<Integer,Integer> hashmap=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int subtracted=target-arr[i];

            if(hashmap.containsKey(subtracted)){
                return "YES";
            }else{
                hashmap.put(arr[i],i);
            }
        }

        return "NO";
    }

    static int[] mergeSort(int[]arr,int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
           return merge(arr,low,mid,high);
        }
        return arr;
    }

    static int[] merge(int[] arr,int low,int mid,int high){
      ArrayList<Integer> temparray=new ArrayList<>();
        int left=low;
      int right=mid+1;

      while(left<=mid && right<=high){
          if(arr[left]<arr[right]){
              temparray.add(arr[left]);
              left++;
          }else{
              temparray.add(arr[right]);
              right++;
          }
      }
      while(left<=mid){
          temparray.add(arr[left]);
          left++;
      }
      while(right<=high){
          temparray.add(arr[right]);
          right++;
      }

      for(int i=0;i<temparray.size();i++){
         arr[low+i]=temparray.get(i);
          System.out.println(arr[i]+"in");
        }

return arr;

    }
    public static String read4(int n, int []array, int target){
        // Write your code here.
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }

        int left=0;
        int right=array.length-1;
        while(left<right){
            if((array[left]+array[right])==target){
                return "YES";
            }
            else if((array[left]+array[right])<target){
                left++;
            }else right--;

        }
        return "NO";

    }
    public static void sortArray2(ArrayList<Integer> arr, int n) {
        // Write your code here.
        Collections.sort(arr);
        int count0 =0;
        int count1 =0;
        int count2 =0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==0) {
                count0++;
            }
            else if(arr.get(i)==1) {
                count1++;
            }
            else {
                count2++;
            }
        }


        for(int i=0;i<count0;i++) {

            arr.set(i, 0);
        }
        for(int i=0;i<count1;i++) {

            arr.set(count0+i, 1);
        }
        for(int i=0;i<count2;i++) {

            arr.set(count0+count1+i, 2);
        }

    }
    public static int majorityElement(int[] v) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int j : v) {
                int value = hash.getOrDefault(j,0);
                hash.put(j, ++value);

        }

        for (HashMap.Entry<Integer,Integer> it:hash.entrySet()) {
            if (it.getValue() >= v.length / 2) {
                return it.getKey();
            }
        }
        return -1;
    }


    public static long maxSubarraySum(int[] arr, int n) {
        // write your code here
        if(n==0){
            return 0;
        }

        long sum=0;
        for(int d:arr){
            sum+=d;
        }
        return sum;
    }

    public static void maxSubarraySum1(int[] arr, int n) {
        // write your code here
        long maxSum=Integer.MIN_VALUE;
        long sum=0;
        int start=0,end=0;
        for(int i=0;i<n;i++){
            if(sum==0) {
                start=i;
            }
                sum+=arr[i];
                if(sum>maxSum) maxSum=sum;
                end=i;
            System.out.println(sum);
            if(sum<0){
                sum=0;
            }
        }

        System.out.println("Start "+ start +"End "+end +"Max "+maxSum);

    }
    public static int longestSubarrayWithSumK12(int []arr, long k) {
        int maxSum =0;
        int left=0;
        int right=0;
        int sum=arr[0];
        while(right<arr.length){
            while(left<right&&sum>k){
                sum-=arr[left];
                left++;
            }
            if(sum==k){
                maxSum=Math.max(maxSum,right-left+1);
            }
            right++;
            if(right<arr.length){
                sum+=arr[right];
            }
        }
        return maxSum;
    }

    public static int bestTimeToBuyAndSellStock(int []arr) {
        int daylowestprice=arr[0];
        int maxprofit=0;

        for(int i=1;i<arr.length;i++){
            int cost=maxprofit-daylowestprice;
            maxprofit=Math.max(maxprofit,cost);
            daylowestprice=Math.min(daylowestprice,arr[i]);
        }
return maxprofit;

    }
    public static int[] alternateNumbers(int []a) {
        // Write your code here.
     ArrayList<Integer> temppositive=new ArrayList<>();
        ArrayList<Integer> tempnegative=new ArrayList<>();

        int l=0;
        int h=0;
        for(int i=0;i<a.length;i++){
            if(a[i]<0){
                tempnegative.add(a[i]);
                l++;
            } else if (a[i]>=0) {
                temppositive.add(a[i]);
                h++;
            }
        }

        for(int i=0;i< temppositive.size();i++){
            System.out.println(tempnegative.get(i)+" "+temppositive.get(i));
        }

        return a;
    }

    public static ArrayList<String> permutations(String data,String permutation,ArrayList<String> perm){
        if(data.isEmpty()){
           perm.add(permutation);
            return perm;
        }

        for(int i=0;i<data.length();i++){
            char permutable =data.charAt(i);
            String newStr=data.substring(0,i)+data.substring(i+1);
             permutations(newStr,permutation+permutable,perm);
        }
return perm;
    }



    static List<List<Integer>> generatePermutation(int[] nums,List<Integer> perm,List<List<Integer>> ans,boolean[]used){
   if(perm.size()==nums.length){
       ans.add(new ArrayList<Integer>(perm));
       return ans;
   }
   for(int i=0;i<nums.length;i++){
       if(!used[i]){
           used[i]=true;
           perm.add(nums[i]);
           generatePermutation(nums,perm,ans,used);
           perm.remove(perm.size()-1);
           used[i]=false;
       }
   }
        return ans;
    }



    public static List<Integer> next (List<Integer> data){
        int index=-1;
        int n=data.size();
        for(int i=n-2;i>=0;i--){
            if(data.get(i)<data.get(i+1)){
                index=i;
                break;
            }
        }
        if(index==-1){
         reversearray(data,0,n-1);
         return data;
        }
    for(int i=n-1;i>=index;i--){
        if(data.get(i)>data.get(index)){
            int temp=data.get(index);
            data.set(index,data.get(i));
            data.set(i,temp);
            break;
        }
    }

    List<Integer> sublist=data.subList(index+1,n);
    Collections.reverse(sublist);

    return data;

    }
    public static void reversearray(List<Integer> data,int start,int end){
        for(int i=start;i<=end;i++){
            if(start==end) break;
        int temp=data.get(start);
        data.set(start,data.get(end));
        data.set(end,temp);
        start++;
        end--;
    }
    }
    public static void QuickSort(int []a,int low,int high){
        if(low<high){
            int partition=sort(a,low,high);
            QuickSort(a,low,partition-1);
            QuickSort(a,partition+1,high);
        }
    }
    public static int sort(int []a,int low,int high){
        int i=low;
        int j=high;
        int pivot=a[low];
        while(i<j){
            while(i<=high &&a[i]<=pivot) i++; //a[i] >pivot
            while(j>=low && a[j]>pivot) j--;
            if(i<j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
          }
        }
        int temp=a[low];
        a[low]=a[j];
        a[j]=temp;
        return j;
    }
    public static int longestSuccessiveElements(int []a) {
        QuickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
        int var=a[0];
        int count=1;
        int maxCount=1;
        for(int i=1;i<a.length;i++){
            if(var+1==a[i]){
                count++;
                maxCount=Math.max(maxCount,count);
 }else{
                count=2;

            }
            var=a[i];
        }
        return maxCount;
    }


    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(matrix.get(i).get(j)==0){
                    setRow(matrix,i,n);
                    setColumn(matrix,j,m);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.println(matrix.get(i).get(j));
                if(matrix.get(i).get(j)==-1){
                    matrix.get(i).set(j,0);
                }
            }
        }

return matrix;


    }

    public static void setRow(ArrayList<ArrayList<Integer>> matrix,int i,Integer n){
        for(int j=0;j<n;j++){
            if(matrix.get(i).get(j)!=0){
                matrix.get(i).set(j,-1);
            }

        }
    }

    public static void setColumn(ArrayList<ArrayList<Integer>> matrix,int j,Integer m){
        for(int i=0;i<m;i++){
            if(matrix.get(i).get(j)!=0){
                matrix.get(i).set(j,-1);
            }

        }

    }


    public static ArrayList<ArrayList<Integer>> zeroMatrix1(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m){

        for( int i=0;i<n;i++){

        }
        return matrix;
    }
    public static void main(String[]args){





//        int[] nums={15 ,6 ,2, 1 ,16, 4 ,2 ,29,9, 12 ,8 ,5, 14, 21, 8 ,12 ,17, 16, 6 ,26 ,3 };
//        HashSet<Integer> x =new HashSet<>();
//        for(int d:nums){
//            x.add(d);
//
//        }
//        ArrayList<ArrayList<Integer>>  db=new ArrayList<>();
//        int index=0;
//        for(int i=0;i<4;i++){
//            ArrayList<Integer> row1=new ArrayList<>();
//            row1.add(2);
//            row1.add(4);
//            row1.add(3);
//
//        int [][]mat={{10, 154, 54, 4, 54},{12,13,14,15,16}};
//        int []trix={0};
//        System.out.println(trix[1]);
//        for(int i=0;i<mat.length;i++){
//            for(int j=0;j<mat.length/2;j++){
//                int temp = 0;
//                temp = mat[i][j];
//                mat[i][j] = mat[i][mat.length - 1 - j];
//                mat[i][mat.length - 1 - j] = temp;
//            }
//        }
//
//        System.out.println(mat[0].length);



//       row2.add(1);
//       row2.add(0);
//       row2.add(0);
//
//       db.add(row1);
//       db.add(row2);
//        ArrayList<ArrayList<Integer>>  output=  zeroMatrix(db,1,2);

//        setRow(db,0,3);
//        setColumn(db,0,2);
//        for(ArrayList<Integer> x:db){
//            System.out.println(x);
//        }
//            for(int j=0;j<4;j++){
//                ++index;
//                row.add(index);
//            }
//            db.add(row);
//        }

//db.get(2).set(1,89);
//        System.out.println( " sd"+ db.get(1).get(1));



//        ArrayList<Integer> data=new ArrayList<>();
//        data.add(1);
//        data.add(2);
//        data.add(3);
//        Collections.reverse(data);
//        System.out.println(data);`
//ArrayList<String> d=new ArrayList<>();

//        ArrayList<Integer> perm =new ArrayList<>(); ArrayList<ArrayList<Integer>> perms=new ArrayList<>();
//       ArrayList<ArrayList<Integer>> output= generatePermutation(data,perm,perms);
//       for(ArrayList<Integer> a:output){
//           System.out.println(a);
//       }

//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
//
//        System.out.println(longestSuccessiveElements(nums));
//   List<Integer> ds=new ArrayList<>();
//
//
////        List<List<Integer>> ans=new ArrayList<>();
////        boolean[]freq=new boolean[nums.length];
////       List<List<Integer>> output= generatePermutation(nums,ds,ans,freq);
////
////       for(List<Integer> a:output){
////           System.out.println(a);
////       }
//       ds.add(1);
//       ds.add(2);
//       ds.add(3);
//        reversearray(ds,0,2);
//
//        System.out.println(ds);
//       nextGreaterPermutation(ds);



//        int[] arr={1 ,2 ,-8,1 ,3,-5,-4};

//        alternateNumbers(arr);
//        ArrayList<Integer> a=new ArrayList<>();
//        for(int i:arr){
//            a.add(i);
//        }
//        Collections.sort(a);
//        for(int i:a){
//            System.out.println(i);
//        }




//       sortArray2(a,a.size()-1);

//           ArrayList <Integer>d=mergeSort2(a,0,a.size()-1);
//           for(int g:d){
//               System.out.println(g);
//           }
//        TreeSet <Integer> set=new TreeSet<>();
//           set.add(1047815);
//           set.add(104785);
//           set.add(10456785);
//           set.add(10465785);
//           set.add(104785);
//           set.add(104847785);
//           set.add(74104785);
//           set.add(10484785);
//           set.add(10894785);
//
//        for (Integer integer : set) {
//            System.out.println(integer);
//        }
    }
    static ArrayList<Integer> mergeSort2(ArrayList<Integer> arr, int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergeSort2(arr,low,mid);
            mergeSort2(arr,mid+1,high);
            return merge2(arr,low,mid,high);
        }
        return arr;
    }
    static ArrayList<Integer> merge2(ArrayList<Integer> arr, int low,int mid,int high){
        ArrayList<Integer> temparray=new ArrayList<>();
        int left=low;
        int right=mid+1;

        while(left<=mid&&right<=high){
            if(arr.get(left)<arr.get(right)){
                temparray.add(arr.get(left));
                left++;
            }else{
                temparray.add(arr.get(right));
                right++;
            }
        }
        while(left<=mid){
            temparray.add(arr.get(left));
            left++;
        }
        while(right<=high){
            temparray.add(arr.get(right));
            right++;
        }

        for(int i=0;i<temparray.size();i++){
            arr.set(i+low,temparray.get(i));
        }
        return arr;

    }
    public static void sortArray(ArrayList<Integer> arr, int n) {
        // Write your code here.
        ArrayList<Integer> sortedArray= mergeSort2(arr,0,arr.size()-1);

        for(Integer s:sortedArray){
            System.out.print(s+" ");
        }

    }
    static List<List<Integer>> generatePermutation(List<Integer> data,List<Integer>perm,List<List<Integer>> perms,boolean []used){
        if(perm.size()==data.size()){
            perms.add(new ArrayList<Integer>(perm));
            return perms;
        }

        for(int i=0;i<data.size();i++){
            if(!used[i]){
                used[i]=true;
                perm.add(data.get(i));
                generatePermutation(data,perm,perms,used);
                used[i]=false;
                perm.remove(perm.size()-1);
            }
        }

        return perms;
    }
    public static List< Integer > nextGreaterPermutation(List< Integer > A) {
        boolean[] used = new boolean[A.size()];
        List<Integer> perm = new ArrayList<>();
        List<List<Integer>> perms = new ArrayList<>();
        List<List<Integer>> output = generatePermutation(A, perm, perms, used);

        for(List<Integer> a:output){
            System.out.println(a);
        }
        return perm;
    }
}




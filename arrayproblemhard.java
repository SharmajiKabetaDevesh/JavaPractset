import java.lang.reflect.Array;
import java.util.*;

public class arrayproblemhard {

    static long factorial(long n){
        if(n==0||n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static void printpascal(int n){
        for(long i = 0; i<= (long) n; i++){
            for(long j=0;j<=i;j++){
                long combination=(factorial(i)/(factorial(j)*(factorial(i-j))));
                System.out.print(combination+" ");
            }
            System.out.println();
        }
    }

    public static void printapascalrow(int n){
        n=n-1;
        for(long i=0;i<=(long)n;i++){
            long combination=(factorial(n)/(factorial(i)*(factorial(n-i))));
            System.out.print(combination+" ");
        }
    }
    public static int subarrayWithMaxProduct(int []arr){
        int n= arr.length;
        if(n==1) return arr[0];
        int maxproduct=0;
        for(int i=0;i<n;i++){
            int product=1;
            for(int j=i;j<n;j++){
                if(arr[j]==0){
                    maxproduct=Math.max(maxproduct,product);
                    product=1;
                    continue;
                }
                product*=arr[j];
                maxproduct=Math.max(maxproduct,product);
            }

        }
        return maxproduct;
    }
    public static int subarrayWithMaxProduct2(int []arr){
        int n= arr.length;
        if(n==1) return arr[0];
        int maxproduct=0;
        int left=0;
        int product=1;
        while(left<n){
            if(arr[left]==0){
                maxproduct=Math.max(maxproduct,product);
                product=1;
                left++;
                continue;
            }
            product*=arr[left];
            maxproduct=Math.max(maxproduct,product);
            left++;

        }
        return maxproduct;
    }

    public static int fact(int n){
        if(n==0){
            return 1;
        }

        return n*fact(n-1);
    }
    public static int binary(int []arr, int low, int high, int target, int ans){
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(arr[mid]==target){
            return mid;
        }else if(target>arr[mid]) {
            return binary(arr, mid + 1, high, target, ans);
        }else {
            return binary(arr, low, mid - 1, target, ans);
        }
    }
    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) return -1; //Base case.

        // Perform the steps:
        int mid = (low + high) / 2;
        if (nums[mid] == target) return mid;
        else if (target > nums[mid])
            return binarySearch(nums, mid + 1, high, target);
        return binarySearch(nums, low, mid - 1, target);
    }


     public static int lowerboundbinary(int []arr,int low,int high,int target,int ans){
        if(low>high){
            return ans;
        }
        int mid=(low+high)/2;
        if(arr[mid]>=target){
            ans=mid;
            return lowerboundbinary(arr,low,mid-1,target,ans);
        }else{
            return lowerboundbinary(arr,mid+1,high,target,ans);
        }
     }
    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k){
        // Write your code here.
        int first=-1;
        int last=-1;
        int low=0;
        int high=n-1;

        while(low<=high){
            if(arr.get(low)==k){
                if(first==-1){
                    first=low;
                }
            }

            if(arr.get(high)==k){
                last=high;
            }

            low++;
            high--;
            if(first!=-1 && last !=-1){
                break;
            }

        }

        return new int[]{first,last};
    }
    public static int[] searchRange(int[] arr, int k) {
        int n=arr.length;
        int first=lowerbound(arr,0,n-1,k,n);
        if(first==n ) return new int[]{-1,-1};
        int last=upperbound(arr,0,n-1,k,n);
        return new int[]{first,last};
    }
    public static int lowerbound(int []arr,int low,int high,int target,int ans){
    if(low>high){
        return ans;
    }
    int mid=(low+high)/2;
    if(arr[mid]>=ans){
        ans=mid;
        return lowerbound(arr,low,mid-1,target,ans);
    }else{
        return lowerbound(arr,mid+1,high,target,ans);
    }
    }

    public static int upperbound(int[]arr,int low,int high,int target,int ans){
        if(low>high){
            return ans;
        }

        int mid=(low+high)/2;

        if(arr[mid]>target){
            ans=mid;
            return upperbound(arr,low,mid-1,target,ans);
        }else {
            return upperbound(arr, mid + 1, high, target, ans);
        }
    }


    public static int search(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        arr.sort(null);
        return binary(arr,0,n,k);

    }

    public static int binary(ArrayList<Integer>arr,int low,int high,int target){
        if(low>high){
            return -1;
        }

        int mid=(low+high)/2;

        if(arr.get(mid)==target){
            return mid;
        }else if(arr.get(mid)>target){
            return binary(arr,low,mid-1,target);
        }else{
            return binary(arr,mid+1,high,target);
        }
    }


     public static int binaryrotated(int []arr,int low,int high,int target){
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[low]<arr[mid]){
            if(target>=arr[low] && target <= arr[mid]){
                return binaryrotated(arr,low,mid-1,target);
            }else{
                return binaryrotated(arr,mid+1,high,target);
            }
        }else{
            if(target>= arr[mid] && target<=arr[high]){
                return binaryrotated(arr,mid+1,high,target);
            }else{
                return binaryrotated(arr,low,mid-1,target);
            }
        }
     }


    public static  int binary3(ArrayList<Integer>arr,int low,int high){
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(arr.get(mid)!= arr.get(mid + 1) && arr.get(mid)!= arr.get(mid - 1)){
            return arr.get(mid);
        }

        if(arr.get(mid).equals(arr.get(mid-1))&&(mid%2==1) ){
            return binary(arr,mid+1,high);
        }else{
            return binary(arr,low,mid-1);
        }
    }

    public static int findPeakElement(ArrayList<Integer> arr) {
        int n= arr.size();
        int low=1;
        int high=n-2;
        if(n==1) {
            return arr.get(0);
        }
        if(arr.get(n-1)>arr.get(n-2)){
            return arr.get(n-1);
        }
        if(arr.get(0)>arr.get(1)){
            return 0;
        }
        return binary1(arr,low,high);
    }


    public static int binary1(ArrayList<Integer> arr,int low,int high){
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(arr.get(mid-1)<arr.get(mid) &&arr.get(mid)>arr.get(mid+1)){
            return mid;
        }
        if(arr.get(mid)>arr.get(mid-1)){
            return binary(arr,mid+1,high);
        }else {
            return binary(arr,low,mid-1);
        }
    }
    public static int NthRoot(int n, int m) {
        if(n==0){
            return 1;
        }
        if(m==0){
            return 0;
        }
        return roots(0,m,n,m,-1);
// int ans=-1;
//         for(int i=0;i<m;i++){
//             int pow=(int)power(i,n);
//             if(pow==m){
//                 return i;
//             }else if(pow>m){
//                 break;
//             }
//         }
//         return ans;
    }

    public static int roots(int low,int high,int n,int m,int ans){
        if(low>high){
            return ans;
        }
        int mid=(low+high)/2;
        int sqr=mid*mid;
        if(sqr==m){
            return mid;
        }
        if(sqr<m){
            return roots(mid+1,high,n,m,ans);
        }
        else{
            return roots(low,mid-1,n,m,ans);
        }


    }

//    public static long power(int n,int m){
//        if(m==0){
//            return 1;
//        }
//        if(n==0){
//            return 0;
//        }
//        if(m%2==1){
//            m=m-1;
//            return power(n,(m/2))*power(n,(m/2))*n;
//        }else{
//            return power(n,(m/2))*power(n,(m/2));
//        }
//    }
    static long power(int element,int raiseto){
        if(raiseto==0){
            return 1;
        }
        if(element==0){
            return 0;
        }

        if(raiseto%2==1){
            raiseto=raiseto-1;
            return power(element,raiseto/2)*power(element,raiseto/2)*element;
        }else{
            return power(element,raiseto/2)*power(element,raiseto/2);
        }
    }
    public static void main(String[]args){

        String dev="dr";
        System.out.println(dev.length());
//        ArrayList<Integer>arr=  new ArrayList<Integer>();
//                arr.add(1 );
//                arr.add(2 );
//                arr.add(3 );
//                arr.add(4 );
//                arr.add(5 );
//        System.out.println(findPeakElement(arr));
      //  System.out.println(NthRoot(9 ,1953125));
//        System.out.println(power(2,3));
//        System.out.println(roots(0,25,3,25,-1));
//        System.out.println(subarrayWithMaxProduct2(a));


//
//        System.out.println(Arrays.toString(searchRange(a,4)));
//

//        mergeTwoSortedArraysWithoutExtraSpace(a,b);
//        merge(a,b,a.length,b.length);
//        int[][] elements = {
//                {1, 2},
//                {1, 3},
//                {1, 6},
//                {3, 4},
//                {4, 4},
//                {4, 5},
//                {5, 5},
//                {6, 6},
//                {6, 6}
//        };
//           List<List<Integer>> output=mergeOverlappingIntervals(elements);
//           for(List<Integer> it:output){
//               System.out.println(it);
//           }
//        List<List<Integer>> hg=new ArrayList<>();
//
////
////        List<Integer> db=new ArrayList<>();
//        ArrayList<Integer> dx=new ArrayList<>();
//        dx.add(10);
//        dx.add(20);
//        dx.add(11);
//        dx.add(40);
//
//        System.out.println(search(dx,dx.size(),11));
//        System.out.println(Arrays.toString(firstAndLastPosition(dx, dx.size(), 40)));
//        db.addAll(dx);
//        db.sort(null);
//        System.out.println(db);
//        Set<List<Integer>> uniquelist=new HashSet<>();
//
//        List<List<Integer>> answerlist=new ArrayList<>();
//        System.out.println(uniquelist.size());
//        hg.add(db);
//        System.out.println(hg.contains(db));
//        System.out.println(db.contains(0));
//        HashMap<Integer,Integer> hash=new HashMap<>();

//
//        for(HashMap.Entry<Integer,Integer>x : hash.entrySet()){
//
//        }
    }
    public static  int binary(ArrayList<Integer>arr,int low,int high){
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(!Objects.equals(arr.get(mid), arr.get(mid + 1)) && !Objects.equals(arr.get(mid), arr.get(mid - 1))){
            return arr.get(mid);
        }

        if(arr.get(mid).equals(arr.get(mid-1)) && ((mid==0 ||mid%2==0) &&(mid-1)%2==1)){
            return binary(arr,mid+1,high);
        }
        if(Objects.equals(arr.get(mid), arr.get(mid + 1)) && ((mid%2==0) &&(mid+1)%2==1)){
            return binary(arr,low,mid-1);
        }

        return -1;
    }
    public static List< Integer > majorityElement(int []arr) {
        List<Integer> answer=new ArrayList<>();

        HashMap <Integer,Integer> hash=new HashMap<>();

        int threshold=arr.length/3;
        for(int i=0;i<arr.length;i++){
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }

        for(HashMap.Entry<Integer,Integer> hashit:hash.entrySet()){
            if(hashit.getValue()>threshold){
                answer.add(hashit.getKey());
            }
        }
        return answer;
    }
    public static List< List < Integer > > triplet(int n, int []arr) {
        Set<List<Integer>> uniquelist=new HashSet<>();
        List<List<Integer>> answerlist=new ArrayList<>();
        System.out.println(uniquelist.size());
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                for(int k=j+1;k<n;k++){
                    if((arr[i]+arr[j]+arr[k])==0){
                        List<Integer> temparray=new ArrayList<>();
                        temparray.add(arr[i]);
                        temparray.add(arr[j]);
                        temparray.add(arr[k]);
                        temparray.sort(null);
                        uniquelist.add(temparray);
                    }

                }
            }
        }
        answerlist.addAll(uniquelist);
        return answerlist;
    }
    public static int[][] pascalTriangle1(int n) {
        // Write your code here.
        int[][] answer=new int[n][];

        for(int i=0;i<n;i++){
            int [] temparray=new int[i+1];
            for(int j=0;j<=i;j++){
                long com=combination(i,j);
                temparray[j]= (int) com;
            }
            answer[i]=temparray;
        }
        return answer;
    }

    public static List< List< Integer > > mergeOverlappingIntervals(int [][]arr){
        int n= arr.length;
        List< List< Integer > > answer=new ArrayList<>();


        for(int i=0;i<n;i++){
            int firstel=arr[i][0];
            int secondel=arr[i][1];
            if(!answer.isEmpty() && secondel<=answer.get(answer.size()-1).get(1)){
                continue;
            }

            for(int j=0;j<n;j++){
                if(arr[j][0]<=secondel){
                    secondel=Math.max(secondel,arr[j][i]);
                }
            }
            List<Integer> templist=new ArrayList<>();
            templist.add(firstel);
            templist.add(secondel);
            answer.add(templist);

        }

        return answer;
    }

    public static long combination(int n,int r){
        long res=1;
        for(int i=0;i<r;i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        return res;
    }
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        int n=a.length;
        int m=b.length;
        long [] ans=new long[n+m];
        int location=0;
        int  left=0;
        int right=0;
        while(left<n && right<m){
            if(a[left]<=b[right]){
                ans[location]=a[left];
                location++;
                left++;
            }else {
                ans[location]=a[right];
                location++;
                right++;
            }
        }
        while(left<n){
            ans[location]=a[left];
            location++;
            left++;
        }
        while(right<m){
            ans[location]=b[right];
            location++;
            right++;
        }
        for(int i=0;i<n+m;i++){
            if(i<n){
                a[i]=ans[i];
            }else{
                b[i-n]=ans[i];
            }
        }
        System.out.println(Arrays.toString(a)+" "+Arrays.toString(b));
    }
    public static void merge(long[] arr1, long[] arr2, int n, int m) {

        // Declare a 3rd array and 2 pointers:
        long[] arr3 = new long[n + m];
        int left = 0;
        int right = 0;
        int index = 0;

        // Insert the elements from the 2 arrays
        // into the 3rd array using left and right
        // pointers:

        while (left < n && right < m) {
            if (arr1[left] <= arr2[right]) {
                arr3[index] = arr1[left];
                left++;
                index++;
            } else {
                arr3[index] = arr2[right];
                right++;
                index++;
            }
        }

        // If right pointer reaches the end:
        while (left < n) {
            arr3[index++] = arr1[left++];
        }

        // If left pointer reaches the end:
        while (right < m) {
            arr3[index++] = arr2[right++];
        }

        // Fill back the elements from arr3[]
        // to arr1[] and arr2[]:
        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                arr1[i] = arr3[i];
            } else {
                arr2[i - n] = arr3[i];
            }
        }
        System.out.println(Arrays.toString(arr1) +" "+Arrays.toString(arr2));
    }

    public static int numberOfInversions(int []arr, int n) {
        // Write your code here.

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    count++;
                }
            }
        }

        return count;
    }



    public static int mergeSort (int []arr,int low,int high,int count){
        if(low<high){
            int mid=(low+high)/2;
            mergeSort(arr,low,mid,count);
            mergeSort(arr,mid+1,high,count);
            return merge(arr,low,mid,high,count);
        }
        return count;
    }

    public static int merge(int []arr,int low,int mid,int high,int count){
        ArrayList <Integer> temparray=new ArrayList<>();
        int left=low;
        int right=mid+1;

        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
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
            arr[i]=temparray.get(i);
        }

        return count;



    }
}

import java.lang.reflect.Array;
import java.util.*;

public class arrayproblem {
    static int largestElement(int[] arr, int n) {
        int largest=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        return largest;
    }


    static int[] quickSort(int[]array,int low,int high){
        if(low<high) {
            int pIndex = partition(array, low, high);
            quickSort(array, low, pIndex - 1);
            quickSort(array, pIndex + 1, high);
        }
        return array;
    }
    static int partition(int []array,int low,int high){
        int pivot=array[low];
        int i=low;
        int j=high;

        while(i<j){
            while(pivot<=array[i]&&i<=high-1){
                i++;
            }
            while(pivot>array[j]&&j>=low+1){
                j--;
            }
            if(i<j){
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }

        }
        int temp=array[low];
        array[low]=array[j];
        array[j]=temp;
        return j;
    }  public static void quickSort1(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partitionIndex = partition(array, startIndex, endIndex);
            quickSort(array, startIndex, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, endIndex);
        }
    }

    public static int partition1(int[] array, int low, int high) {
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

    public static int secondLargest(int n,int[]array){
        int largest=array[0];
        int slargest=-1;
        for(int i=1;i<n;i++){
            if(array[i]>largest){
                slargest=largest;
                largest=array[i];
            }
           else if(array[i]>slargest&&array[i]!=largest) {
                slargest=array[i];
            }
        }

        return slargest;
    }
    public static int secondSmallest(int n,int[]array){
        int smallest=array[0];
        int ssmallest= Integer.MAX_VALUE;
        for(int i=1;i<n;i++) {
            if (array[i] < smallest) {
                ssmallest = smallest;
                smallest = array[i];
            } else if (array[i] < ssmallest && array[i] != smallest) {
                ssmallest = array[i];
            }
        }
        return ssmallest;
    }
    public static int[] getSecondOrderElements(int n, int []array) {
        int ssmallest=secondSmallest(n,array);
        int slargest=secondLargest(n,array);

        return new int[]{slargest,ssmallest};
    }


    public static int removeDuplicatesBrute(ArrayList<Integer> arr,int n) {
         TreeSet <Integer> a=new TreeSet<>();
        for(int i=0;i<arr.size();i++){
            a.add(arr.get(i));
        }
        for(int d:a){
            arr.add(d);
        }
        return a.size();
    }

    public static int removeDulpicatesOptimal(ArrayList<Integer> array,int n ){
        int i=0;
        for(int j=1;j<array.size();j++){
            if(!(array.get(i)).equals(array.get(j))){
                i++;
                array.add(i,array.get(j));
            }
        }return i+1;
    }
    public static int removeDuplicates(ArrayList<Integer> array,int n) {
        TreeSet<Integer> set=new TreeSet<>();

        for(int i=0;i<array.size();i++){
            set.add(array.get(i));
        }
        return set.size();

    }
    static int[] rotateArray(int[] arr, int n,int k) {
        if(k==0){return arr;}
        int firstelement=arr[0];

        for(int i=1;i<n;i++){
            arr[i-1]=arr[i];
        }
        arr[n-1]=firstelement;

        return rotateArray(arr,n,k-1);
    }
    public static ArrayList <Integer>rotateArray(ArrayList<Integer> arr, int k) {
        k=k%arr.size();
        ArrayList<Integer> temparray=new ArrayList<>();
        for(int i=0;i<k;i++){
            temparray.add(arr.get(i));
        }
        for(int i=k;i<arr.size();i++){
            arr.set(i-k,arr.get(i));
        }
        for(int i=arr.size()-k;i<arr.size();i++){
            arr.set(i,temparray.get(i-(arr.size()-k)));
        }
        return arr;
    }

    public static ArrayList<Integer> rotateArray1(ArrayList<Integer> array,int k){
        k=k%array.size();
        reverse(array,0,k);
        reverse(array,k,array.size());
         return reverse(array,0,array.size());
    }

    public static ArrayList<Integer> reverse(ArrayList<Integer> array,int k,int n){
        n=n-1;
        for(int i=k;i<n;i++){
            int temp =array.get(i);
            array.set(i,array.get(n));
            array.set(n,temp);
            n--;
        }
        return array;
    }
    public static int[] moveZeros(int n, int []a) {
        // Write your code here.
        int count =0;
        ArrayList<Integer> temparray=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                temparray.add(a[i]);
            }else{
                count++;
            }
        }
        for(int i=0;i<count;i++){
            temparray.add(0);
        }
        for(int i=0;i<temparray.size();i++){
            a[i]=temparray.get(i);
        }
        return a;
    }
    public static int[] moveZerosOptimal(int n, int []a) {
        // Write your code here.
        int j=-1;
        for (int i=0;i<n;i++){
            if(a[i]==0){
                j=i;
                System.out.println("first");
                break;
            }
        }
        if(j!=-1) {
            for (int i = j + 1; i < n; i++) {
                if (a[i] != 0) {
                    System.out.println("second");
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    j++;
                }
            }

        }

       return a;
    }
    public static List< Integer > sortedArray(int []a, int []b) {
        TreeSet <Integer> temparray=new TreeSet<>();
        List<Integer> unionarray=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            temparray.add(a[i]);
        }
        for(int i=0;i<b.length;i++){
            temparray.add(b[i]);
        }
        int i=0;
        for(int d:temparray){
            unionarray.add(d);
            i++;
        }
        return unionarray;
    }

    static  List<Integer> union(int []a, int []b) {
        List<Integer> unionarray=new ArrayList<>();
        int n1=a.length;
        int n2=b.length;
        int i=0;
        int j=0;
        while(i<n1&&j<n2){
            if(a[i]<=b[j]){
                   if(unionarray.isEmpty() || unionarray.get(unionarray.size()-1)!=a[i]){
                unionarray.add(a[i]);
            }
                   i++;
            }
            else{
                    if(unionarray.isEmpty() ||unionarray.get(unionarray.size()-1)!=b[j]){
                        unionarray.add(b[j]);
                    }
                    j++;
            }
        }
        while(i<n1){
            if(unionarray.get(unionarray.size()-1)!=a[i]){
                unionarray.add(a[i]);
            }
            i++;
        }
        while(j<n2){
            if(unionarray.isEmpty()||unionarray.get(unionarray.size()-1)!=b[j]){
                unionarray.add(b[j]);
            }
            j++;
        }



        return unionarray;
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


public static int missing(int []arr,int n){
        int flag=0;
         for(int i=0;i<=n;i++){
             flag=0;
             for(int j=0;j<arr.length;j++){
                 if(arr[j]==i){
                     flag=1;
                     break;
                 }
             }
             if(flag==0){
                 return i;
             }
         }
         return -1;
}

    public static int missingBetter(int []arr,int n){
        int [] hash=new int[n+1];
        for(int i=0;i<arr.length;i++){
            hash[arr[i]] = 1;
        }
        for(int i=0;i<=n;i++){
            if(hash[i]==0){
                return i;
            }
        }
        return -1;
    }
    public static int missingNumberOptimal(int[] nums) {
        int n=nums.length;
        int sum1=((n*(n+1))/2);
        int sum2=0;
        for(int i=1;i<nums.length;i++){
            sum2=sum2+nums[i];
        }
        System.out.println(sum1+" "+sum2);
        return sum1-sum2;
    }
    public static int singleNumber(int[] arr) {
  Map<Integer,Integer> map=new HashMap<>();
  for(int i=0;i<arr.length;i++){
      int value=map.getOrDefault(arr[i],0);
     map.put(arr[i],++value);
  }

  for(Map.Entry<Integer,Integer> it:map.entrySet()){
      int count=it.getValue();
      if(count==1){
          return it.getKey();
      }
  }
return -1;
    }

    public static int longestSubarrayWithSumK(int []arr, long k) {
        int n=arr.length;
        int length=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=sum+arr[j];
                if(sum==k){
                 length=Math.max(length,j-i);
                }
            }
        }
return length;


    }

    public static int largestsubarray(int []arr,int k){
        int maxlength=0;
        int sum=arr[0];
        int left=0;
        int right=0;
        int n=arr.length;
        while(right<n){
            while (left<=right&&sum>k){
                sum-=arr[left];
                left++;
            }

            if(sum==k){
                maxlength=Math.max(maxlength,right-left+1);
            }

            right++;
            if(right<n) sum+=arr[right];
        }

        return maxlength;
    }

    public static void main(String[]args) {
//
        int[]arr={0,0,1,1,2,2,1,1,1,1,2,3};
        int []g={8, 15, 17, 0 ,11 };
        int[]abb={2,3,4,5,10,12,14};
        System.out.println(largestsubarray(g,17));

//List<Integer> alag=union(arr,abb);
//        for(int d:alag){
//            System.out.println(d);
//        }

//        int []a=moveZerosOptimal(arr.length,arr);
//        for(int s:a){
//            System.out.print(" "+s);
//        }
//Set<Integer> daa=new TreeSet<>();
//        daa.add(44);
//        for(int i=0;i<15;i++){
//            daa.add(i);
//        }
//        for(int d:daa){
//            System.out.println(d);
//        }
//List<Integer> d=new ArrayList<>();

//        ArrayList<Integer> data=new ArrayList<>();
//        for(int i=1;i<8;i++){
//            data.add(i);
//        }
//
//        ArrayList <Integer>d=rotateArray1(data,9);
//        for(int db:d){
//            System.out.print(" "+db);
//        }





//        int[]d=rotateArray(arr,arr.length,22);
//        for(int s:d){
//            System.out.print(" "+s);
//        }


//        ArrayList<Integer> data=new ArrayList<>();



//       int []s=getSecondOrderElements(data.length, data);
//       for(int d:s) System.out.println(d);

    }

}

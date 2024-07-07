import java.util.ArrayList;
import java.util.Arrays;

public class binarysearchonanswers {
    public static int minimumRateToEatBananas(int []v, int h) {
        int maximumnum=largestelementfun(v);
        int low=0;
        int high=maximumnum;
        int ans=0;

        while(low<=high){
            int mid=(low+high)/2;
            int timetakentoeat=bananaseateninhours(v,mid);
            if(timetakentoeat<=h){
                ans=mid;
                low=mid+1;

            }else{
                high=mid-1;
            }

        }
        return ans;
    }


    public static int largestelementfun(int []arr){
        int largest=arr[0];
        for(int i=0;i<arr.length;i++){
            if (largest<arr[i]){
                largest=arr[i];
            }
        }
        return largest;
    }

    public static int bananaseateninhours(int[]arr,int hour){
        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans+=(int)Math.ceil((double)(arr[i]/hour));
        }
        return ans;
    }
    public static int smallestDivisor(int arr[], int limit) {
        int n=arr.length;
        int max=0;
        for(int i=0;i<n;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        for(int i=1;i<max;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=(int)(Math.ceil((double) arr[j] /i));
            }
            System.out.println(sum);

            if(sum<=limit){
                return i;
            }
        }
        return 0;
    }
    public static int smallestDivisor1(int arr[], int limit) {
        int n=arr.length;
        if (n == 0 || n == 1) {
            return -1;
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        // for(int i=1;i<max;i++){
        //     int sum=0;
        //     for(int j=0;j<n;j++){
        //         sum+=(Math.ceil((double)arr[j]/i));
        //     }
        //     if(sum<=limit){
        //             return i;
        //         }
        // }
        int low=1;
        int high=max;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;

            boolean sumislessornot=findsum(arr,limit,mid);

            if(sumislessornot){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }


        return ans;
    }


    public static boolean findsum(int []arr,int limit,int divisor){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+= (int) Math.ceil((double)arr[i]/divisor);
        }

        if(sum<limit){
            return true;
        }else{
            return false;
        }
    }

    public static int leastWeightCapacity(int[] arr, int maxdays) {

        int n= arr.length;
        int max=0;
        int sumofallweights=0;
        for (int i=0;i<n;i++){
            if(max<arr[i]){
                max=arr[i];
            }
            sumofallweights+=arr[i];
        }
        if(maxdays==1){
            return sumofallweights;
        }

        int low=max;
        int high=sumofallweights;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int daycount=finddays(arr,mid,maxdays);

            if(daycount<=maxdays){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }

        }
        return ans;
    }

    public static int finddays(int []arr,int midweight,int maxdays){
        int countdays=1;
        int load=0;
        for(int i=0;i<arr.length;i++){
            if((load+arr[i])>midweight){
                countdays+=1;
                load=arr[i];
            }else{
                load=arr[i];
            }
        }
        return countdays;
    }

    public static int findMedian(int[][] matrix, int m, int n) {
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                temp.add(matrix[i][j]);
            }
        }

        temp.sort(null);
        System.out.println(temp);
        int sizeofarraylist=temp.size();

        if(sizeofarraylist%2==0){
            return (temp.get(sizeofarraylist/2)+temp.get((sizeofarraylist/2)-1))/2;
        }else{
            return temp.get(sizeofarraylist/2);
        }
    }

    public static void main(String []args){
        int [][]arr={{1, 5, 7 ,9, 11},
                {2 ,3 ,4 ,8 ,9},
                {4 ,11, 14, 19, 20},
                {6 ,10 ,22 ,99 ,100},{7 ,15, 17, 24, 28 }};

        System.out.println(findMedian(arr,5,5));
//        ArrayList<ArrayList<Integer>> temp=new ArrayList<>();
//        ArrayList<Integer> data=new ArrayList<>(Arrays.asList(10,20,30,40));
//        temp.add(data);
//        System.out.println(temp.get(0).get(1));
//
//        System.out.println( smallestDivisor1(arr,8));
    }
//    import java.util.ArrayList;
//    public class Solution
//    {
//        public static int maximumOnesRow(ArrayList<ArrayList<Integer>> arr, int n, int m)
//        {
//            int index=-1;
//            int countones=-1;
//            // for(int i=0;i<n;i++){
//            //     int count=0;
//            //     for(int j=0;j<m;j++){
//            //         if((arr.get(i).get(j))==1){
//            //             count++;
//            //         }
//            //     }
//            //     if(count>countones){
//            //         countones=count;
//            //         index=i;
//            //     }
//            // }
//
//            // return index;
//
//
//            for(int i=0;i<n;i++){
//                int lower=lowerbound(arr,i,m);
//                int no_ofones=m-lower;
//                if(no_ofones>countones){
//                    countones=no_ofones;
//                    index=1;
//                }
//            }
//        }

        public static int lowerbound(ArrayList<ArrayList<Integer>> arr,int row,int m,int k){
            int low=0;
            int high=m;
            int ans=-1;
            k=k-1;
            while(low<high){
                int mid=(low+high)/2;

                if((arr.get(row).get(mid))>=k){
                    ans=mid;
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            return ans;


        }
    }


public class bubble {
    public static void printarr(int []arr){
      for(int i=0;i<arr.length;i++){
          System.out.println(arr[i]);
      }
    }
    public static void main(String[]args){

        int[] a ={8,9,11,3,1,2,5};

        for(int i =0;i<a.length-1;i++){
            for (int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }printarr(a);

    }
}

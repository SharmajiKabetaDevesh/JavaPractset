public class insertionsort {
    public static void main(String[] args) {

        int []a={11,78,98,5,6,7,1,2,3};

        for(int i=1;i<a.length;i++){

            int temp=a[i];
            int j=i-1;

            while(j>=0&&temp<a[j]){
                a[j+1]=a[j];
                j--;
            }

            a[j+1]=temp;
        }



        bubble.printarr(a);
    }
}

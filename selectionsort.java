
public class selectionsort {
    public static void main(String[] args) {

        int []a={11,78,98,5,6,7,1,2,3};

        for(int i=0;i<a.length;i++){
            int temp=a[i];

            for(int j=i+1;j< a.length;j++){
                if(a[i]>a[j]){
                    a[i]=a[j];
                    a[j]=temp;
                }

            }
        }



        bubble.printarr(a);
    }
}

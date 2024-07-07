public class recursionbasics {
    public static void printnumdescending(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printnumdescending(n-1);

    }


    public static void printnumascending(int n){
        if(n==0){
            return;

        }


         printnumascending(n-1);
        System.out.println(n);
    }

    public static void printsumnaturalnum(int sum,int n){
        if(n==0){
            System.out.println(sum);
            return;
        }
        sum=sum+n;
        printsumnaturalnum(sum,n-1);
    }


    public static int factorialnumber(int n){
        if(n==0){
            return 1;
        }
        return n*factorialnumber(n-1);
    }
public static void fibonacci(int x,int y,int j){
        if(j==0){
            return;
        }

    System.out.print(x+" ");

    fibonacci(y,x+y,j-1);

}


// Print x^n (with stack height = n)


    public static int exponentheight(int n,int ex){
        if(n==0){
            return 0;
        }
if(ex==0){

    return 1;
}

return n*exponentheight(n,ex-1);

    }



    public static int logexponentheight(int n,int ex){
        if(n==0){
            return 0;
        }
        if(ex==0){
            return 1;
        }
        if(ex%2!=0){
            ex=ex-1;
            return logexponentheight(n,ex/2)*logexponentheight(n,ex/2)*n;
        }else{
            return logexponentheight(n,ex/2)*logexponentheight(n,ex/2);
        }
    }
    public static void main(String []args){


//        printnumascending(10);
//        printnumdescending(5);
//        printsumnaturalnum(0,5);

//        System.out.println(factorialnumber(5));
//        fibonacci(0,1,10);

//        System.out.println(exponentheight(5,4));
        System.out.println(logexponentheight(2,11));

    }
}
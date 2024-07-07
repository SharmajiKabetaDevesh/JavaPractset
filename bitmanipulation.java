import java.util.*;
public class bitmanipulation {
    public static void main(String []args){


//getbit(5,2);
// setbit(5,1);
//
//clearbit(5,2);
//        System.out.println(ispoweroftwo(4));
//
//        toggle(3,2);
//        System.out.println(countone(5));
//        tobinary(150);
toDecimal("1010");

    }
    static void setbit(int n, int pos){
   int bitmask=1<<pos;
        System.out.println(bitmask|n);
    }


    static void getbit(int n,int pos){
 int bitmask=1<<pos;
 if((n&bitmask)==0){
     System.out.println("Bit is zero");
 }else{
     System.out.println("Bit is One");
 }
    }

    static void clearbit(int n,int pos){
        int bitmask = 1<<pos;
        int notbitmask = ~(bitmask);
        System.out.println(n&notbitmask);
    }


    //a program to find if a number is a power of 2 or not.

    static boolean ispoweroftwo(int n){
        if(n<=0){
            return false;
        }
       return (n&(n-1))==0;

    }


    //a program to toggle a bit a position = “pos” in a number “n”.


    static void toggle(int n,int pos){
        int bitmask=1<<pos;
       int result =n^bitmask;
        System.out.println(result);

        }



    //a program to count the number of 1’s in a binary representation of the number.

    public static int countone(int n){
        int counts=0;
        while(n>0){
            int remainder=n%2;
            if(remainder==1){
                counts++;
            }
            n=n/2;
        }
        return counts;
    }



    //Write 2 functions => decimalToBinary() & binaryToDecimal() to convert a number from one number system to another

    public static void  tobinary(int n){
        StringBuffer sf= new StringBuffer(100);
        while(n>0){
            int remainder=n%2;
            if(remainder==1){
                sf.append('1');
            }else{
                sf.append('0');
            }
            n=n/2;
        }
        String binary=sf.toString();

        for(int i=(binary.length()-1);i>=0;i--){
            System.out.print(binary.charAt(i));
        }
    }


    public static void toDecimal(String Binary){
        // Initialize index 'i' to the last position of the binary string
        int i = Binary.length() - 1;

        // Initialize a variable 'num' to store the decimal value
        double num = 0;

        // Loop through the binary string from right to left
        while(i >= 0){
            // Check if the current bit is '1'
            if(Binary.charAt(i) == '1'){
                // If true, add the corresponding decimal value (2^position) to 'num'
                num += Math.pow(2, Binary.length() - i - 1);
            }

            // Move to the next bit (leftwards)
            i--;
        }

        // Print the final decimal value
        System.out.println(num);
    }

}




import java.util.HashMap;
import java.util.HashSet;

public class recursionmediumlevel {
//tower of hanoi
    public static void towerofhanoi(int numberofplates,String source,String helper,String destination){
if(numberofplates==1){
    System.out.println(source+" --> "+destination);
    return;
}

        towerofhanoi(numberofplates-1,source,destination,helper);
        towerofhanoi(1,source,helper,destination);
        towerofhanoi(numberofplates-1,helper,source,destination);

    }



    //print a string in reverse

    public static void printstringreverse(String data,int index){
        if(index<0){
            return;
        }
        System.out.println(data.charAt(index));
        printstringreverse(data,index-1);
    }



    //Find the occurrence of the first and last occurrence of an element using recursion.
    int first=-1;
    int last=-1;

    public void occurence(String data,char element,int index){
        if(index==0){
            System.out.println(last+" occurence "+first);
            return;
        }

        if(data.charAt(index)==element){
            if(first==-1) {
                first = index;
            }else{
                last=index;
            }

        }occurence(data,element,index-1);


    }
//check if an array is strictly sorted

    static boolean sorted=true;
public static void arraysorted(int[]arr,int index){
    if(index==arr.length-1){
        System.out.println("Array is sorted ");
        return;
    }if(arr[index]>arr[index+1]){
        sorted=false;
        System.out.println("Array is not sorted ");
        return;
    }arraysorted(arr,index+1);

}
//move all x or any element to the end of the character

    static int xcount=0;
    public static String xmovetoend(String data,String ansappendable,int stringpointer){
        if(stringpointer==data.length()){
            for(int i=0;i<=xcount;i++){
                ansappendable=ansappendable+'x';
            }
            return ansappendable;
        }

        if(data.charAt(stringpointer)!='x'){
            ansappendable+=data.charAt(stringpointer);
        }else{
            xcount++;
        }
        return xmovetoend(data,ansappendable,stringpointer+1);
    }


    ///Remove duplicates from a string

    static HashSet<Character> dev=new HashSet<>();

    public static void duplicatesfrommstring(String data,int index,String ans){
if(index==data.length()){
    System.out.println(ans);
    return;
}
    if (!dev.contains(data.charAt(index))) {
        dev.add(data.charAt(index));
        ans=ans + data.charAt(index);
    }

    duplicatesfrommstring(data, index + 1,ans );
    }


    //permutations of an string
    public static void permutations(String data,String permutation){
        if(data.length()==0){
            System.out.println(permutation);
            return;
        }
        for(int i=0;i<data.length();i++){
            String newstr=data.substring(0,i)+data.substring(i+1);
            permutations(newstr,permutation+data.charAt(i));
        }

    }

    // sudequence of a given string
    public static void subsequence(String data ,String subsequence){
        if(data.length()==0){
            System.out.println(subsequence);
            return;
        }
        subsequence(data.substring(1),subsequence+data.charAt(0));
        subsequence(data.substring(1),subsequence);
    }

    //p[rint all keyvboard combinations

    public static String []keypad={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","uz"};
    public static void keyvcombination(String str,String answer ){
if(str.isEmpty()){
    System.out.println(answer);
    return;
};

String key=keypad[str.charAt(0)-'0'];
for(int i=0;i<key.length();i++){
   keyvcombination(str.substring(1),answer+key.charAt(i));
}

    }

//print all unique subsequences of a string
public static void uniqueSubsequence(String str, String answer, HashSet<String> set) {
    if (str.isEmpty()) {
        if (set.contains(answer)) {
            return;
        } else {
            set.add(answer);
            System.out.println(answer);
        }
    }

    uniqueSubsequence(str.substring(1), answer + str.charAt(0), set);
    uniqueSubsequence(str.substring(1), answer, set);
}

    public static void main(String[]args){
//towerofhanoi(3,"A","B","C");

//        printstringreverse("devesh",5);
//        recursionmediumlevel occurence=new recursionmediumlevel();
//        occurence.occurence("Devesh",'e',5);

//        int []arr={1,2,3,4,8,6};
//arraysorted(arr,0);
     //   System.out.println(xmovetoend("axxbxxdxxcd","",0));
//duplicatesfrommstring("abxa",0,"");

//        permutations("abc","");

//    subsequence("abc","");

//        keyvcombination("245","");
HashSet <String> set=new HashSet<>();
        uniqueSubsequence("aaa","",set);
    }

}

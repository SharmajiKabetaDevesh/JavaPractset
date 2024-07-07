import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>>ans=new ArrayList<>();
        if(n==1){
            List<String>temp=new ArrayList<>();
            temp.add("Q");
            ans.add(temp);
            return ans;
        }
        char[][]board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        solve(board,0,ans);
        return ans;
    }
    public static void solve(char[][] board, int col, List<List<String>> ans){
        if(col==board.length){
            ans.add(construct(board));
        }
        for(int row=0;row<board.length;row++){
            if(isPossible(row,col,board)){
                board[row][col]='Q';
                solve(board,col+1,ans);
                board[row][col]='.';
            }
        }
    }
    public static List<String> construct(char[][] board){
        List<String> res=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String s=new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static boolean isPossible(int row, int col, char[][] board){

        int duprow=row;
        int dupcol=col;

        while(row>=0 && col>=0){
            if(board[row][col]=='Q')return false;
        }
        row=duprow;
        col=dupcol;
        while(col>=0){
            if(board[row][col] =='Q')return false;
            col--;
        }

        row=duprow;
        col=dupcol;
        while(row<board.length && col>=0){
            if(board[row][col]=='Q')return false;
            row++;
            col--;
        }


        return true;


    }


    public static void main(String[]args){
//        List<List<String>> dev= new ArrayList<>();
//        dev=solveNQueens(4);
//        System.out.println(dev);


    }
}
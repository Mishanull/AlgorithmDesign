import java.util.Arrays;

public class nQueens {
    public static boolean isOK(boolean[][] board, int col, int row){
        //Row left side
        for(int i=0; i<col; i++){
            if(board[row][i])
                return false;
        }
        //Left side upper diagonal
        for(int i=row, j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j])
                return false;
        }

        //Left side lower diagonal
        for(int i=row,j=col; j>=0 && i<board.length; i++, j--){
            if(board[i][j])
                return false;
        }
        return true;
    }
    public static boolean solve(boolean[][] board, int col){
        int n=board.length;
        if(col>=n)
            return true;
        for(int i=0;i<n;i++){
            if(isOK(board, col, i)){
                board[i][col]=true;
                if(solve(board,col+1)){
                    return true;
                }
                board[i][col]=false;
            }

        }
        return true;
    }
    public static void printBooleanMatrix(boolean[][] matrix){
        for (boolean[] booleans : matrix) {
            System.out.println(Arrays.toString(booleans));
        }
    }
    public static void main(String[] args) {
        int n=6;
        boolean[][] board=new boolean[n][n];
        if(solve(board,0)){
            printBooleanMatrix(board);
        }
        else System.out.println("No solution is existent");
    }
}

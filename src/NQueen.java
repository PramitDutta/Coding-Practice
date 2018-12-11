import java.util.ArrayList;
import java.util.List;

public class NQueen {
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        } 
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helper(board, result, n, new ArrayList<>(), 0);
        return result;     
    }
    
    private void helper(char[][] board, List<List<String>> res, int n,List<String> temp, int row){
        if(row==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int col=0;col<n;col++){
            if(isValid(board,row,col)){
                board[row][col]='Q';
                temp.add(new String(board[row]));
                helper(board, res, n, temp, row+1);
                board[row][col]='.';
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isValid(char[][] board, int row, int col){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}

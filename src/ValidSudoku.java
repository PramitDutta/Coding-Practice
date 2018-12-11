import java.util.*;
public class ValidSudoku {
	 public static boolean isValidSudoku(char[][] board) {
	        for(int i=0;i<9;i++){
	            HashSet<Character> rows = new HashSet<Character>();
	            HashSet<Character> columns = new HashSet<Character>();
	            HashSet<Character> cube = new HashSet<Character>();
	            for(int j=0;j<9;j++){
	                if(board[i][j]!='.' && !rows.add(board[i][j]))
	                    return false;
	                if(board[j][i]!='.' && !columns.add(board[j][i]))
	                    return false;
	                int rowIndex = 3*(i/3);
	                int columnIndex = 3*(i%3);
	                int n=rowIndex+j/3;
	                int m=columnIndex+j%3;
	                if(board[n][m]!='.' && !cube.add(board[n][m]))
	                    return false;
	            }
	        }
	        return true;
	    }
	 public static void main(String[] args){
		 char[][] board = {{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
		 boolean result = isValidSudoku(board);
		 System.out.println(result);
	 }
}

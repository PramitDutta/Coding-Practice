package LeetCode_Medium;

public class GameOfLife {
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;
		int m = board.length;
		int n = board[0].length;

		// board[i][j & 1 to get current state
		// board[i][j] >> 1 to get the next state
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int lives = liveNeighbors(board, m, n, i, j);

				// in the beginning every 2nd bit is 0;
				// we only need to care about when 2nd bit becomes 1
				if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
					board[i][j] = 3; // make 2nd bit 1: 01 --> 11;
				}
				if (board[i][j] == 0 && lives == 3) {
					board[i][j] = 2; // make 2nd bit 1 : 00 -->10
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] >>= 1; // get the 2nd state
			}
		}
	}

	public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
		int lives = 0;
		for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
			for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
				lives += board[x][y] & 1;
			}
		}
		lives -= board[i][j] & 1;
		return lives;
	}
}

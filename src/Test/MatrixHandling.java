package Test;

public class MatrixHandling {
	public static void matrixHandle(int[][] matrix, int row, int col) {
		int m = matrix.length;
		int n = matrix[0].length;

		System.out.println(m);
		System.out.println(n);
		for (int i = 0; i < m; i++) {
			System.out.print(matrix[row][i]);
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		matrixHandle(matrix, 1, 1);
	}
}

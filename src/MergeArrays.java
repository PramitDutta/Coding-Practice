
public class MergeArrays {
	public static int[] merge(int[] A, int[] B) {
	      int i, j, k, m, n;
	      i = 0;
	      j = 0;
	      k = 0;
	      m = A.length;
	      n = B.length;
	      int[] C = new int[m+n];
	      while (i < m && j < n) {
	            if (A[i] <= B[j]) {
	                  C[k] = A[i];
	                  i++;
	            } else {
	                  C[k] = B[j];
	                  j++;
	            }
	            k++;
	      }
	      if (i < m) {
	            for (int p = i; p < m; p++) {
	                  C[k] = A[p];
	                  k++;
	            }
	      } else {
	            for (int p = j; p < n; p++) {
	                  C[k] = B[p];
	                  k++;
	            }
	      }
	      return C;
	}
	public static void main(String[] args){
		int[] A = {2,4,6,8};
		int[] B = {1,3,5,7};
		int[] result = merge(A,B);
		for(int num:result){
			System.out.print(num+" ");
		}
	}
}

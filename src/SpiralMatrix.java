import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix.length==0) return list;
        int m=matrix.length; //ending row index
        int n=matrix[0].length; //ending column index
        
        int i,k=0,l=0;
        
        while(k<m && l<n)
        {
            for(i=l;i<n;++i){
                list.add(matrix[k][i]);
            }
            k++;
            for(i=k;i<m;++i){
                list.add(matrix[i][n-1]);
            }
            n--;
            if(k<m){
                for(i=n-1;i>=l;--i){
                    list.add(matrix[m-1][i]);
                }
                m--;
            }
            if(l<n){
                for (i = m-1; i >= k; --i){
                list.add(matrix[i][l]);
                }
                l++;    
            }  
        }
        return list;
    }
	public static void main(String args[]){
		
		int[][] arr = {{1,  2,  3,  4,  5,  6},
		        {7,  8,  9,  10, 11, 12},
		        {13, 14, 15, 16, 17, 18}
		    };
		 List<Integer> result = spiralOrder(arr);
		 for(int n:result){
			 System.out.print(n+" ");
		 }
	}
}

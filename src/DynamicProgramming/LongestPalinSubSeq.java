package DynamicProgramming;

public class LongestPalinSubSeq {
	public static int LCS(String X, String Y){
		int m=X.length(),n=Y.length();
		int[][] L=new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0||j==0)
					L[i][j]=0;
				else if(X.charAt(i-1)==Y.charAt(j-1))
					L[i][j]=L[i-1][j-1]+1;
				else 
					L[i][j]=Math.max(L[i-1][j], L[i][j-1]);
			}
		}
		return L[m][n];              			
	}
	public static int LPS(String s){
		int result = LCS(s,new StringBuilder(s).reverse().toString());
		return result;
	}
	public static void main(String[] args){
		String str="GEEKSFORGEEKS";
		int LPS= LPS(str);
		System.out.println("Length of LPS" +LPS);
	}
}

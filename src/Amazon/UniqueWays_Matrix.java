package Amazon;

public class UniqueWays_Matrix {
	public static int uniquePaths(int m, int n){
		if(m>n) return uniquePaths(n,m);
		int[] current = new int[m];
		for(int i=0;i<m;i++){
			current[i]=1;
		}
		for(int j=1;j<n;j++){
			for(int i=1;i<m;i++){
				current[i]+=current[i-1];
			}
		}
		return current[m-1];
	}
	public static int numPaths(int m, int n){
		int[][] dp = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0 || j==0){
					dp[i][j]=1;
				}
				else{
					dp[i][j]=dp[i-1][j]+dp[i][j-1];
				}
			}
		}
		return dp[m-1][n-1];
	}
	
	public static void main(String[] args){
		int result = uniquePaths(4,4);
		int result1 = numPaths(4,4);
		System.out.println(result+"   "+result1);
	}
}

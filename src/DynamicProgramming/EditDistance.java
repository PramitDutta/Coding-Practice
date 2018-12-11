package DynamicProgramming;

public class EditDistance {
	public static int minMoves(String x, String y){
		int m=x.length();
		int n=y.length();
		int dp[][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0) // if first string empty insert all of second string
					dp[i][j]=j;
				else if(j==0) // if second string is empty, remove all of first string
					dp[i][j]=i;
				else if(x.charAt(i-1)==y.charAt(j-1))// if last characters are same ignore and recur for the remaining chars
					dp[i][j]=dp[i-1][j-1];
				else
					dp[i][j]=1+Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args){
		String str1 = "sunday";
	    String str2 = "saturday";
	    System.out.println("The minimum edit distance is "+minMoves(str1,str2));
	}
}

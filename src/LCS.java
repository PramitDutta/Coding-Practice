
public class LCS {
	public static void LCSubsequence(String a, String b){
		int m=a.length();
		int n=b.length();
		int[][] dp = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0)
					dp[i][j]=0;
				else if(a.charAt(i-1)==b.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else{
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
					
			}
		}
		int index=dp[m][n];
		System.out.println("Length of LCS " +index);
		char[] lcs = new char[index+1];
		lcs[index]='\0';
		
		int i=m,j=n;
		while(i>0 && j>0){
			if(a.charAt(i-1)==b.charAt(j-1)){
				lcs[index-1]=a.charAt(i-1);
				i--;j--;index--;
			}
			else if(dp[i-1][j]>dp[i][j-1])
				i--;
			else
				j--;
		}
		System.out.println(lcs);
	}
	public static void main(String[] args){
		String a="AGGTAB";
		String b="GXTXAYB";
		LCSubsequence(a,b);
	}
}

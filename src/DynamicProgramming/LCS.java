package DynamicProgramming;

public class LCS {
	public static String findLCS(String X, String Y){
		int m=X.length(),n=Y.length();
		int L[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0)
					L[i][j]=0;
				else if(X.charAt(i-1)==Y.charAt(j-1))
					L[i][j]=L[i-1][j-1]+1;
				else
					L[i][j]=Math.max(L[i-1][j],L[i][j-1]);
			}
		}
		System.out.println("The length of LCS is "+L[m][n]);
		
		//For printing the LCS
		int index=L[m][n];
		char lcs[]=new char[index+1];
		lcs[index]='\0';
		int i=m,j=n;
		while(i>0 && j>0){
			if(X.charAt(i-1)==Y.charAt(j-1)){
				lcs[index-1]=X.charAt(i-1);
				i--;
				j--;
				index--;
			}
			else if(L[i-1][j]>L[i][j-1])
				i--;
			else
				j--;
		}
		return new String(lcs);		
	}
	public static void main(String[] args){
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		System.out.println(findLCS(X,Y));
	}
}

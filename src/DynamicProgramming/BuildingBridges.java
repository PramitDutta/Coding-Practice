package DynamicProgramming;

import java.util.Arrays;

public class BuildingBridges {
	
	public static int lis(int[] A){
		
		int n=A.length;
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		int max=dp[0];
		
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(A[i]> A[j]  && dp[i]<dp[j]+1){
					dp[i]=dp[j]+1;
				}
			}
			max= Math.max(max, dp[i]);
		}
		return max;		
	}
	public static void main(String[] args){
		int[] a = {3,1,4,5,2};
		int[] b = {2,3,1,4,5};
		int result= Math.min(lis(a), lis(b));
		System.out.println(result);
		
	}
	
}

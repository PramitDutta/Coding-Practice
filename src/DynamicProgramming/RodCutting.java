package DynamicProgramming;

public class RodCutting {
	public static int cutRod(int prices[], int n){
		int val[] = new int[n+1];
		val[0]=0;
		for(int i=1;i<=n;i++){
			int max= Integer.MIN_VALUE;
			for(int j=0;j<i;j++){
				max=Math.max(max, prices[j]+val[i-j-1]);
			}
			val[i]=max;
		}
		return val[n];
	}
	public static void main(String[] args){
		int prices[]= new int[] {1, 5, 8, 9, 10, 17, 17, 20};
		int n=prices.length;
		int maxPrice=cutRod(prices,n);
		System.out.println("Maximum Price obtainable is "+maxPrice);
	}
}

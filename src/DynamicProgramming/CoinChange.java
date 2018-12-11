package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
	public static long numWays(int[] nums, int k){
		int m=nums.length;
		long table[] = new long[k+1];
		Arrays.fill(table, 0);
		table[0]=1;
		for(int i=0;i<m;i++){
			for(int j=nums[i];j<=k;j++){
				table[j]+=table[j-nums[i]];
			}
		}
		return table[k];
	}
	public static void main(String[] args){
		int[] nums={1,2,3};
		long result = numWays(nums,4);
		System.out.println((int)result);
		
		List<String> stockList = new ArrayList<String>();
		stockList.add("stock1");
		stockList.add("stock2");

		String[] stockArr = new String[stockList.size()];
		stockArr = stockList.toArray(stockArr);

		for(String s : stockArr)
		    System.out.println(s);
	}
}

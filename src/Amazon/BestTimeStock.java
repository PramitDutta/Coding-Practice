package Amazon;

public class BestTimeStock {
	public static int maxProfit(int[] prices) {
		int maxCur = 0, maxSoFar = 0;
		for (int i = 1; i < prices.length; i++) {
			maxCur += prices[i] - prices[i - 1];
			maxCur = Math.max(0, maxCur);
			maxSoFar = Math.max(maxCur, maxSoFar);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int result = maxProfit(prices);
		System.out.println(result);
	}
}

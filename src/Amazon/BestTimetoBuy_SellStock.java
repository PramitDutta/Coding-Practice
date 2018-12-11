package Amazon;

public class BestTimetoBuy_SellStock {
	public int maxProfit_III(int[] prices) {
		int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}
		return sell2;
	}

	public int maxProfit_II(int[] prices) {
		int total = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				total += prices[i + 1] - prices[i];
			}
		}
		return total;
	}

	public int maxProfit_I(int[] prices) {
		int maxCurr = 0, maxSoFar = 0;
		for (int i = 1; i < prices.length; i++) {
			maxCurr += prices[i] - prices[i - 1];
			maxCurr = Math.max(0, maxCurr);
			maxSoFar = Math.max(maxSoFar, maxCurr);
		}
		return maxSoFar;
	}

	public int maxProfit_Cooldown(int[] prices) {
		int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
		for (int price : prices) {
			prev_buy = buy;
			buy = Math.max(prev_sell - price, prev_buy);
			prev_sell = sell;
			sell = Math.max(prev_buy + price, prev_sell);
		}
		return sell;
	}
}

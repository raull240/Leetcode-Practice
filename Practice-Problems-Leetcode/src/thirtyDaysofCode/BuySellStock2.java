package thirtyDaysofCode;


 /*
  * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
  * 
  *  */
public class BuySellStock2 {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int[] dp = new int[prices.length];
		int max = 0;
		dp[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			dp[i] = prices[i] - prices[i - 1];
		}
		for (int num : dp) {
			if (num > 0) {
				max += num;
			}
		}
		return max;
	}

	public static void main(String[] args) {

		int[] stockList = { 7, 1, 5, 3, 6, 4 };
		int result = new BuySellStock2().maxProfit(stockList);
		System.out.println(result);

	}
}
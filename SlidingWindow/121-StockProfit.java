// problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package SlidingWindow;

class Solution {
    public int maxProfit(int[] prices) {

        int minBuy = prices[0];
        int maxProfit = 0;

        for (int i : prices) {
            minBuy = Math.min(i, minBuy);
            maxProfit = Math.max(i - minBuy, maxProfit);
        }

        return maxProfit;

    }
}
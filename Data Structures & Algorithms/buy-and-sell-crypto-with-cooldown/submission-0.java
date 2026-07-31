class Solution {
    public int maxProfit(int[] prices) {
        int holding = -prices[0];
        int sold = Integer.MIN_VALUE;
        int cooldown = 0;

        for(int i=1;i<prices.length;i++)
        {
            int prevHolding = holding;
            int prevSold = sold;
            int prevCooldown = cooldown;

            holding = Math.max(prevHolding,prevCooldown-prices[i]);
            sold = prevHolding + prices[i];
            cooldown = Math.max(prevCooldown, prevSold);
        }

        return Math.max(sold,cooldown);
    }
}

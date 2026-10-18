class Solution {
    public int maxProfit(int[] prices) {
       int hold = -prices[0];
       int sold = 0 ; 
       int rest = 0 ;

       for(int i = 1 ; i < prices.length ; i++){
        int prevhold = hold;
        int prevsold = sold;
        int prevrest = rest;

        hold = Math.max(prevhold , prevrest - prices[i]);
        sold = prevhold + prices[i];
        rest = Math.max(prevrest , prevsold);
       } 
       return Math.max(sold,rest);
    }
}
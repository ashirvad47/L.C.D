class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int currProfit = 0;
        int maxProfit=0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } 
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        for (int i =0; i < prices.length-1; i++){
             if(prices[i]<= prices[i+1]){
                currProfit += prices[i+1] - prices[i];
             }
        }

        if(currProfit>maxProfit){
            return currProfit;
        } else{
            return maxProfit;
        }

        
    }
}

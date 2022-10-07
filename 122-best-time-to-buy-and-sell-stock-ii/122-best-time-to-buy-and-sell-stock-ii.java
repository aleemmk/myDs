class Solution {
    
    /**
                    /\
         /\        /  \
        /  \  /\  /    \
       /    \/  \/      \
      /
    
    when ever price[i] (currprice) > lastprice [i-1] we need to find the difference and simly add the diff
    and return;
    */
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        
        int maxProfit=0;
        
        for(int i=1;i<n;i++){
            
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }
}
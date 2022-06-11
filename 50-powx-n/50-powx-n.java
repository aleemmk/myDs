class Solution {
    public double myPow(double x, int n) {
        
        /**
           1.The idea behind approach is 
           every number is represented as a sum of power of 2 .
           set bit in a binary representaion
           
           2. we can traverse all bit of a binary representaion in O(lon n ) time
           
           3 ^ 10 = 3 ^ 8 * 3 ^ 2;
        */
        if(n == 0 || x==1 ) return 1;
        
        if(x == -1){
            if(n % 2 ==0) return 1;
            else return -1;
        }
        
         if (n == Integer.MIN_VALUE) return 0;
        
        if(n < 0){
            
            n = -n;
            x = 1/x;
        }
        
         double res = 1;
        
        while(n > 0){
            
            if( n %2 == 1)
                res = res *x;
            
            x = x*x;
            
             n = n/2;
        }
        return res;
    }
}
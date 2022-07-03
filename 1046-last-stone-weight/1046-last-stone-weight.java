class Solution {
    
    
        /** The idea is to use max heap we build the max heap 
         pop top elment(x) then again pop element(y) . 
         if x-y > 0  then add x-y in heap increase size n++;
         we keep on doing untill size is 1 or 0 .
         
         TC
         ===
         build heap O(n);
         
         2 pop and one push operation 3 (log n)
         
         at most n operations so 3n(log n )
         
         hence O(log);
         
         space complexity O(log n);
         
         
        */
    
    public int lastStoneWeight(int[] stones) {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int stone:stones) pq.offer(stone);  // build heap
        
        int n = stones.length;
        
        while(n > 1){
            int first = pq.poll();
            int second = pq.poll();
            n -= 2;
            if(first-second > 0){
                pq.offer(first-second);
                n++;
            }
        }
        
        if(n == 1) return pq.peek();
        return 0;
    }
}
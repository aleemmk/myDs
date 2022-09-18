class Solution {
    /**
     [
         [1, 5, 9 ],
         [10,11,13],
         [12,13,15]
     ]
     maitained max heap of size 8 . push all element , answer at top.
    */
    public int kthSmallest(int[][] matrix, int k) {
         int rows = matrix.length;
        int cols= matrix[0].length; 
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxHeap.offer(matrix[i][j]);
                if (maxHeap.size() > k) maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
}
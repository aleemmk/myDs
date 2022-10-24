class Solution {
    /**
    Brute force and intutive solution:
    we can merge two sorted array and find the mid as a median .
 
   TC is O(n) 
   
   optimize solution:
     
     1.
     We want to make two cuts, separating nums1 into [. . . . L1 | R1 . . . ] 
     and nums2 into [. . . . L2 | R2 . . . ] respectively, 
     so that [. . . . L1] + [. . . . L2] has equal number of elements as [R1 . . . ] + [R2 . . . ].
     Our goal is to find such cutting positions that give us the median values.
     
     2. 
     With two arrays, a valid cutting position that gives the median can be ANY cutting position of the shorter array. This is not true for the longer array. Therefore, we always cut the shorter array, and then calculate the cutting position of longer array directly(by using the fact that each half has the same number of cutting positions). We want to make nums1 always point to the shorter array for convenience.

3.
Using binary search, If L1 > R2, we know current cutting position is incorrect. 
A valid cutting position for median should be on the left half of nums1.

4.
If L2 > R1, we know current cutting position is incorrect. A valid cutting position for median should be on the right half of nums1.

5.
     if L1 < R2 and L2 < R1, we are good. median = (max(L1, L2) + min(R1, R2)) / 2

    */
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        if(m > n) return findMedianSortedArrays(nums2, nums1);
        
        // now m is always smaller 
        
        int l =0;
        int r = m;
        
        while(l<=r){
            int p1 = (l+r)/2;
            int p2 = (m+n+1)/2 - p1;
            
            // boundry cases
            int max_l1 = (p1 == 0) ?   Integer.MIN_VALUE:  nums1[p1-1];  // if left partion is not found in mum1
            int min_r1=  (p1== m) ? Integer.MAX_VALUE :  nums1[p1];   // if right partion is not found in mum1
            int max_l2 = (p2 == 0) ?   Integer.MIN_VALUE:  nums2[p2-1];  // if left partion is not found in num2
            int min_r2=  (p2== n) ? Integer.MAX_VALUE :  nums2[p2];
            
            if((max_l1 <= min_r2) && (max_l2 <=min_r1)){  // found partion 
                if((m+n)%2 == 0){   // total even element
                    return (Math.max(max_l1,max_l2) + Math.min(min_r1,min_r2)) / 2.0;
                    
                }else   return Math.max(max_l1,max_l2);  // odd
                
            }else if(max_l1 > min_r2){    
                r = p1-1;
            }else{
                l=p1+1;
                
            }
            
           
        }
        
         return 0.0;
        
    }
}
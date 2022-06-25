class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      /**
         [1,3,4,2]
         3 4 -1 -1
         calculate next greater nge arr[]
         */
        int n = nums2.length;
        int [] nge = new int[n];

        Stack<Integer> stack = new Stack();
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=n-1;i>=0;i--){

            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            if(i < n){
                if(!stack.isEmpty()){
                    nge[i]=stack.peek();
                    map.put(nums2[i],nge[i]);
                }else{
                    nge[i] =-1;
                    map.put(nums2[i],-1);
                }
            }
            stack.push(nums2[i]);
        }
        System.out.println(Arrays.toString(nge));
        int res [] = new int[nums1.length];
        int i=0;
        for(int num:nums1){
            res[i++] =map.get(num);
        }

        return res;
    }
}
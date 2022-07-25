class NumArray {
       
    int st [];
    int st_idx;
    int start;
        int end;
    
    public NumArray(int[] nums) {
        int n = nums.length;
        st_idx =1;
        start=0;
        end= n-1;
        st = new int[4*n+1];
        buidSegTree(st_idx,nums,0,n-1);
    }
    
    private void buidSegTree(int st_idx,int nums[] ,int start,int end){
        
        if(start > end ) return ;
           
            if(start == end) {
                st[st_idx] = nums[start];
                return ;
            }
        // INTERNAL NODE
        int mid = start+(end-start)/2;
        
        buidSegTree(2*st_idx,nums,start,mid);
        buidSegTree(2*st_idx+1,nums,mid+1,end);
        
        st[st_idx] = st[2*st_idx]+st[2*st_idx+1];
        
    }
    
    public void update(int index, int val) {
        updateNode(st_idx,start,end,index,val);
    }
    
    private void updateNode(int st_idx,int start,int end,int pos,int newVal ){
    
        if(start > pos || end < pos) return ;
        if(start == end){
            st[st_idx] = newVal;
            return ;
        }
        int mid = start+(end-start)/2;
        updateNode(2*st_idx,start,mid,pos,newVal);
        updateNode(2*st_idx+1,mid+1,end,pos,newVal);
        
        st[st_idx] = st[2*st_idx]+st[2*st_idx+1] ;
    
    }
    
    
    public int sumRange(int left, int right) {
        return query(left,right,st_idx,start,end);
    }
    private int query(int qs,int qe,int st_idx,int start,int end){
        if( qs > end || qe < start) return 0;
        
        if(start >= qs && end <= qe)
            return st[st_idx];
        
        // partial overlap
        int mid = start+(end-start)/2;
        int lsum = query(qs,qe,2*st_idx,start,mid);
        int rsum = query(qs,qe,2*st_idx+1,mid+1,end);
        
        return lsum+rsum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
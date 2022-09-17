class MinStack {
    
    /**
     
     first intutive approach is to use two stack
     
     s1 -> to store element 
     s2-> to track min value
    */

    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public MinStack() {
       stack= new Stack<>();
        minStack = new Stack();
    }
    
    public void push(int val) {
        
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
       
        if(stack.peek().equals(minStack.peek())){    //  == will not work due to integer cache in java
            minStack.pop();
        }
       stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
       return  minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class MyQueue {

    java.util.Stack<Integer> s1,s2;

    /** Initialize your data structure here. */
    public MyQueue() {
     this.s1 = new java.util.Stack();
     this.s2 = new java.util.Stack();
    }

    /** Push element x to the back of queue. */
    
    // goal is to make every new element in bottom of stack. and last element in top FIFO
    
    public void push(int x) {
      if(s1.isEmpty()){
          s1.push(x);   // push in s1 if it is empty
      }else{
          while(!s1.isEmpty()){
              s2.push(s1.pop());   // make s1 empty ,track all element in another stack then push
          }
          s1.push(x);  // now s1 empty push element this elemnt is rear
          while(!s2.isEmpty()){
              s1.push(s2.pop());
          }
      }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }

    /** Get the front element. */
    public int peek() {
       return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
      return s1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyStack {
    
    /**
    below is pop heavy with two queues.
    */

    /** Initialize your data structure here. */
  /*  Queue<Integer> q1 ,q2;
    public MyStack() {
       this.q1 = new LinkedList();
       this.q2 = new LinkedList();
    }

    
    public void push(int x) {
       q1.add(x);
    }


    public int pop() {


     while(q1.size() != 1){
         q2.add(q1.peek());
         q1.remove(q1.peek());
     }
     int temp = q1.peek();
      q1.remove();

      //swap q1 and q2
        Queue q = q1;
        q1 = q2;
        q2 = q;

        return temp;
    }

    
    public int top() {
        if(q1.size() == 0){
            return -1;
        }
      while(q1.size() !=1){
          q2.add(q1.peek());
          q1.remove(q1.peek());
      }
        int temp = q1.peek();
        q1.remove();
         q2.add(temp);

        Queue q = q1;
        q1 = q2;
        q2 = q;

        return temp;
    }

  
    public boolean empty() {
        return q1.size() == 0;
    }*/
    
    
     /** Initialize your data structure here. */
    
    /**
     We can use one queue , logic is to add element in from only 
     how ?
     pop every elemnent from front except last after add and insert it again from rear.
    */
    Queue<Integer> queue;
    public MyStack() {
       this.queue = new LinkedList();
     
    }

    /** Push element x onto stack. */
    public void push(int x) {
    
         queue.offer(x);
        
        for(int i=1;i < queue.size();i++){
            queue.offer(queue.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return queue.remove();
    }

    /** Get the top element. */
    public int top() {
      return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
     return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
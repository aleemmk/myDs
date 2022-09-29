class Solution {
    /**
     use stack to remove problematic bracket , push index when see ( int to stack .
     when see ) cancel it from the last index of ( from stack.
     
     if stack empty 
     this bracket itself problematic mark it.
    
    */
    public String minRemoveToMakeValid(String s) {
        
        Stack<Integer> st = new Stack<>();
        
        
        char arr [] = s.toCharArray();
        int index =0;
        
        for(int i=0;i<s.length(); i++){
            
            if(arr[i] == '('){
                st.push(i);       // push index in stack
            }else if(arr[i] == ')'){
                
                if(st.isEmpty()){
                    arr[i] = '#';     // stack is empty , nothing to cancel so it is problemetic mark it
                }else{
                    st.pop();   //  cancel bracket just pop
                }
            }
        }
        
        while(!st.isEmpty()){
            arr[st.peek()] = '#';     // all problemetic bracket index in stack mark it for removal 
            st.pop();     
        }
        
        StringBuffer sb = new StringBuffer();
        
        for(char c:arr){
            if(c != '#'){
                sb.append(c);       // remove all marked char from string
            }
        }
        return sb.toString();
    }
}
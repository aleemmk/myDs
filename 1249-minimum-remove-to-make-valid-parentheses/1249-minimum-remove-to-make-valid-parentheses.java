class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Stack<Integer> st = new Stack<>();
        
        
        char arr [] = s.toCharArray();
        int index =0;
        
        for(int i=0;i<s.length(); i++){
            
            if(arr[i] == '('){
                st.push(i);
            }else if(arr[i] == ')'){
                
                if(st.isEmpty()){
                    arr[i] = '#';
                }else{
                    st.pop();
                }
            }
        }
        
        while(!st.isEmpty()){
            arr[st.peek()] = '#';
            st.pop();
        }
        
        StringBuffer sb = new StringBuffer();
        
        for(char c:arr){
            if(c != '#'){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
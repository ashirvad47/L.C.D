class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String i  :tokens){
            switch(i){
                case "+": st.push(st.pop()+st.pop());
                break;

                case "-": st.push(-st.pop()+st.pop());
                break;

                case "*": st.push(st.pop()*st.pop());
                break;

                case "/": 
                int a=st.pop();
                int b=st.pop();
                st.push(b/a);
                break;
                default: st.push(Integer.parseInt(i));
            }
        }

        return st.peek();
    }
}
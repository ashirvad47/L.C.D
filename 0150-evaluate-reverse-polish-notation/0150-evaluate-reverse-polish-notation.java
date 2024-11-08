class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();

        for(String i : tokens){
        if(!i.equals("+")&& !i.equals("-")&& !i.equals("*")&& !i.equals("/")){
            st.push(i);
        }else{
            int ans =0;
            int val1=Integer.parseInt(st.pop());
            int val2 = Integer.parseInt(st.pop());
            if(i.equals("+")) ans = val1+val2;
            else if(i.equals("-")) ans = val2-val1;
            else if(i.equals("*")) ans = val2*val1;
            else if(i.equals("/")) ans = val2/val1;

            String temp = Integer.toString(ans);
            st.push(temp);
        }
        }

        return Integer.parseInt(st.peek());
    }
}
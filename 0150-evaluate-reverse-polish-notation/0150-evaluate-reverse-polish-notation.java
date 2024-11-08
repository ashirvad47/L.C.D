// class Solution {
//     public int evalRPN(String[] tokens) {
//         Stack<String> st = new Stack<>();

//         for(String i : tokens){
//         if(!i.equals("+")&& !i.equals("-")&& !i.equals("*")&& !i.equals("/")){
//             st.push(i);
//         }else{
//             int ans =0;
//             int val1=Integer.parseInt(st.pop());
//             int val2 = Integer.parseInt(st.pop());
//             if(i.equals("+")) ans = val1+val2;
//             else if(i.equals("-")) ans = val2-val1;
//             else if(i.equals("*")) ans = val2*val1;
//             else if(i.equals("/")) ans = val2/val1;

//             String temp = Integer.toString(ans);
//             st.push(temp);
//         }
//         }

//         return Integer.parseInt(st.peek());
//     }
// }

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String i : tokens) {

            switch (i) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    int n1 = stack.pop(), n2 = stack.pop();
                    stack.push(n2 / n1);
                    break;
                default: stack.push(Integer.parseInt(i));
            }
        }

        return stack.peek();

    }
}
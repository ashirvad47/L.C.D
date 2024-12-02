class Solution {
    public boolean isValid(String s) {
        if(s.length()%2==1) return false;

        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if( ( c==')' || c== ']' || c== '}' ) && st.isEmpty()){
                    return false;
            }
            else if (c== '(' || c=='{' || c== '['){
                st.push(c);

            }
            else if ( c==')' || c== ']' || c== '}' ) {
                char z = st.pop();
                
                if(z=='(' && c!=')') return false;
                else if (z=='{' && c!='}') return false;
                else if (z=='[' && c!=']') return false;

            }
        }

        return st.isEmpty();
    }
}
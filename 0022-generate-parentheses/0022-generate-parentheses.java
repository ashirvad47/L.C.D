class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, n, "", n, n);
        return res;
        
    }
    public void helper(List<String> res, int n, String str,int left,int right){
        if(str.length()==2*n){
            res.add(str);
        }

        if(left>0){
            helper(res,n,str+"(",left-1,right);
        }
        if(right>left){
            helper(res,n,str+")",left,right-1);
        }
    }
}
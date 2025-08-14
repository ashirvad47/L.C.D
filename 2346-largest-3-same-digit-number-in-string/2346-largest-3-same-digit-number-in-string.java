class Solution {
    public String largestGoodInteger(String num) {
        int res = -1;
        char[] arr = num.toCharArray();
        for(int i = 2; i < arr.length; i++){
            if(arr[i] == arr[i - 1] && arr[i] == arr[i - 2]){
                int val = (arr[i - 2] - '0');
                val = val * 10 + (arr[i - 1] - '0');
                val = val * 10 + (arr[i] - '0');
                res = Math.max(res, val);
            }
        }
        if(res == 0){
            return "000";
        }
        if(res == -1){
            return "";
        }
        return String.valueOf(res);
    }
}
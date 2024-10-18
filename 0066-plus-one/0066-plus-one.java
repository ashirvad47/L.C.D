class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int j = digits.length - 1;
        while (carry != 0 && j >= 0) {
            int sum = digits[j]+carry;
            carry = sum / 10;
            digits[j] = sum % 10;
            j--;
        }
        if(carry!=0){
            int arr[]= new int[digits.length+1];
            System.arraycopy(digits,0,arr,1,digits.length);
            arr[0]=1;
            return arr;
        }
        return digits;
    }
}
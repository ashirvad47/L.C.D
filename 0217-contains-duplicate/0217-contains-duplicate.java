// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//        boolean repeat= false;
//         int start = 0;
//         int end= nums.length-1;
//        while(start<end){
//         if(nums[start]==nums[end]){
//             return true;
//         }
//         start++;
//         end--;
//        } 
//        return repeat;
//     }
// }
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
       for(int i =0; i < nums.length-1;i++){
        if(nums[i]==nums[i+1]){
            return true;
        }
       }
       return false;
    }
}